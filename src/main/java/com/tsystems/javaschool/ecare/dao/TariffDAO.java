package com.tsystems.javaschool.ecare.dao;


import com.tsystems.javaschool.ecare.entities.Tariff;
import com.tsystems.javaschool.ecare.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;


public class TariffDAO implements IAbstractDAO<Tariff>
{
    private static TariffDAO instance;
    private EntityManager em = EntityManagerFactoryUtil.getEm();

    private TariffDAO() {
    }

    public static TariffDAO getInstance()
    {
        if (instance == null) {
            instance = new TariffDAO();
        }
        return instance;
    }

    @Override
    public Tariff saveOrUpdate(Tariff tr) {
        return em.merge(tr);
    }

    @Override
    public Tariff load(long id) {
        return em.find(Tariff.class, id);
    }

    @Override
    public void delete(Tariff tr) {
        em.remove(tr);
    }

    @Override
    public List<Tariff> getAll() {
        return em.createNamedQuery("Tariff.getAllTariffs", Tariff.class).getResultList();
    }

    @Override
    public void deleteAll() {
        em.createNamedQuery("Tariff.deleteAllTariffs").executeUpdate();
    }

    @Override
    public long getCount() {
        return ((Number)em.createNamedQuery("Tariff.size").getSingleResult()).longValue();
    }
}
