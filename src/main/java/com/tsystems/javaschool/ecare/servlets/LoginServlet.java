package com.tsystems.javaschool.ecare.servlets;

import com.tsystems.javaschool.ecare.dao.TariffDAO;
import com.tsystems.javaschool.ecare.entities.Contract;
import com.tsystems.javaschool.ecare.entities.Option;
import com.tsystems.javaschool.ecare.entities.Tariff;
import com.tsystems.javaschool.ecare.entities.User;
import com.tsystems.javaschool.ecare.services.ContractService;
import com.tsystems.javaschool.ecare.services.UserService;

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
 * Created by Kolia on 01.07.2015.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String isAdmin = request.getParameter("isAdmin");
        //out.println(isAdmin);

        UserService userService = UserService.getInstance();
        try
        {
            HttpSession session=request.getSession();

            User user = userService.findClient(email, password);
            session.setAttribute("user", user);

            List<Contract> contracts = ContractService.getInstance().getUserContracts(user);
            session.setAttribute("contracts", contracts);

            Contract currentContract = contracts.get(0);
            session.setAttribute("currentContract", currentContract);

            Tariff currentTariff = currentContract.getTariff();
            session.setAttribute("currentTariff", currentTariff);

            Collection<Option> options = currentTariff.getAvailableOptions();
            session.setAttribute("options", options);

            Collection<Option> disabledOptions = new LinkedList<>();
            for (Option option : currentContract.getSelectedOptions())
            {
                disabledOptions.addAll(option.getLockedOptions());
            }
            session.setAttribute("disabledOptions", disabledOptions);

            List<Tariff> tariffs = TariffDAO.getInstance().getAll();
            session.setAttribute("tariffs", tariffs);

            if (isAdmin != null)
            {
                request.getRequestDispatcher("/WEB-INF/jsp/admin_lobby.jsp").include(request, response);
            }
            else
            {
                request.getRequestDispatcher("/WEB-INF/jsp/client_lobby.jsp").include(request, response);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
