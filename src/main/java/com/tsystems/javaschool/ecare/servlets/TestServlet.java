package com.tsystems.javaschool.ecare.servlets;

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


        //out.println(getContract("1lampard@mail.ru"));
    }

    /*private ContractsEntity getContract(String userEmail)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecarePU");
        EntityManager em = emf.createEntityManager();

        String queryString = "SELECT a FROM ContractsEntity a " + "WHERE :userEmail IS NULL OR LOWER(a.lastName) = :userEmail";
        Query query = em.createQuery(queryString); query.setParameter("userEmail", userEmail);
        ContractsEntity contract = query.getSingleResult();
        em.close();
        emf.close();

        return contract;
    }*/
}
