package com.tsystems.javaschool.ecare.servlets;

import com.tsystems.javaschool.ecare.entities.Contract;
import com.tsystems.javaschool.ecare.entities.Option;
import com.tsystems.javaschool.ecare.entities.Tariff;
import com.tsystems.javaschool.ecare.services.ContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kolia on 06.07.2015.
 */
@WebServlet(name = "ClientLobbyServlet")
public class ClientLobbyServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        System.out.println(action);

        HttpSession session=request.getSession();

        List<Contract> contracts = new LinkedList<>();

        switch (action)
        {
            case "select_contract":
            {
                int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
                Contract selectedContract = null;
                try
                {
                    selectedContract = ContractService.getInstance().getContractByPhoneNumber(phoneNumber);
                    session.setAttribute("currentContract", selectedContract);

                    Tariff currentTariff = selectedContract.getTariff();
                    session.setAttribute("currentTariff", currentTariff);

                    Collection<Option> options = currentTariff.getAvailableOptions();
                    session.setAttribute("options", options);

                    Collection<Option> disabledOptions = new LinkedList<>();
                    for (Option option : selectedContract.getSelectedOptions())
                    {
                        disabledOptions.addAll(option.getLockedOptions());
                    }
                    session.setAttribute("disabledOptions", disabledOptions);

                    request.getRequestDispatcher("client_lobby.jsp").include(request, response);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                break;
            }
            case "sign_out":
            {
                session.invalidate();
                break;
            }
        }
    }
}
