package com.tsystems.javaschool.ecare.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerUtil
{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecarePU");
    private static EntityManager em = emf.createEntityManager();

    public static EntityManager getEm() {
        return em;
    }
}
