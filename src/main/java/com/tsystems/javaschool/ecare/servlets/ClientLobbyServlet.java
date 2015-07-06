package com.tsystems.javaschool.ecare.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        switch (action)
        {
            case "get_contracts":
            {
                request.getRequestDispatcher("/WEB-INF/jsp/contracts_list.jsp").include(request, response);
                break;
            }
            case "get_current_contract":
            {
                out.print("Current contract: " + 32423434);
                break;
            }
            case "get_options":
            {
                request.getRequestDispatcher("/WEB-INF/jsp/options_list.jsp").include(request, response);
                break;
            }
            case "get_tariffs":
            {
                request.getRequestDispatcher("/WEB-INF/jsp/tariffs_list.jsp").include(request, response);
                break;
            }
        }
    }
}
