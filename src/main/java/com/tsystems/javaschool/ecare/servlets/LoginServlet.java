package com.tsystems.javaschool.ecare.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
        String isAdmin = request.getParameter("isAdmin");
        //out.println(isAdmin);

        HttpSession session=request.getSession();
        session.setAttribute("email", email);

        if (isAdmin != null)
        {
            request.getRequestDispatcher("/WEB-INF/jsp/admin_lobby.jsp").include(request, response);
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/jsp/client_lobby.jsp").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
