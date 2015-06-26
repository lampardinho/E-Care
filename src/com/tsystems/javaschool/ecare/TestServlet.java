package com.tsystems.javaschool.ecare;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kolia on 26.06.2015.
 */
public class TestServlet extends javax.servlet.http.HttpServlet
{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        out.println("Hi");
    }
}
