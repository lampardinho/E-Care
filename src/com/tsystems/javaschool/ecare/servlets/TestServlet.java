package com.tsystems.javaschool.ecare.servlets;

import com.tsystems.javaschool.ecare.dao.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecarePU");
        EntityManager em = emf.createEntityManager();

        List<UsersEntity> users = em.createQuery("select u from UsersEntity u", UsersEntity.class).getResultList();

        for(UsersEntity u:users){
            System.out.println(u);
        }

        em.close();
        emf.close();
    }
}
