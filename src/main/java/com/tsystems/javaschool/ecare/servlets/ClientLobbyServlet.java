package com.tsystems.javaschool.ecare.servlets;

import com.tsystems.javaschool.ecare.entities.Contract;
import com.tsystems.javaschool.ecare.entities.Option;
import com.tsystems.javaschool.ecare.entities.Tariff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        //doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        System.out.println(action);

        List<Contract> contracts = new LinkedList<>();
        contracts.add(new Contract(34535235));
        contracts.add(new Contract(65432254));
        contracts.add(new Contract(87654356));
        contracts.add(new Contract(23456363));

        switch (action)
        {
            case "get_contracts":
            {

                request.setAttribute("contracts", contracts);
                request.getRequestDispatcher("/WEB-INF/jsp/contracts_list.jsp").include(request, response);
                break;
            }
            case "get_current_contract":
            {
                out.print("Current contract: " + contracts.get(0).getPhoneNumber());
                break;
            }
            case "get_options":
            {
                List<Option> options = new LinkedList<>();
                options.add(new Option("Option 1", 100, 50));
                options.add(new Option("Option 2", 100, 50));
                options.add(new Option("Option 3", 100, 50));
                options.add(new Option("Option 4", 100, 50));
                request.setAttribute("options", options);
                request.getRequestDispatcher("/WEB-INF/jsp/options_list.jsp").include(request, response);
                break;
            }
            case "get_tariffs":
            {
                List<Tariff> tariffs = new LinkedList<>();
                tariffs.add(new Tariff("Tariff 1", 100));
                tariffs.add(new Tariff("Tariff 2", 100));
                tariffs.add(new Tariff("Tariff 3", 100));
                tariffs.add(new Tariff("Tariff 4", 100));
                request.setAttribute("tariffs", tariffs);
                request.getRequestDispatcher("/WEB-INF/jsp/tariffs_list.jsp").include(request, response);
                break;
            }
        }
    }
}
