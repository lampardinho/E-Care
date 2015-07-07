package com.tsystems.javaschool.ecare.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerFactoryUtil
{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecarePU");

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
