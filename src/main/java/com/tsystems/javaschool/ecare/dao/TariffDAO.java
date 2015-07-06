package com.tsystems.javaschool.ecare.dao;


import com.tsystems.javaschool.ecare.entities.Tariff;
import com.tsystems.javaschool.ecare.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;


public class TariffDAO extends AbstractDAO<Tariff> {
    private static TariffDAO instance;
    private EntityManager em = EntityManagerUtil.getEm();

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
    protected Tariff doSaveOrUpdate(Tariff tr) {
        return em.merge(tr);
    }

    @Override
    protected Tariff doLoad(long id) {
        return em.find(Tariff.class, id);
    }

    @Override
    protected void doDelete(Tariff tr) {
        em.remove(tr);
    }

    @Override
    protected List<Tariff> doGetAll() {
        return em.createNamedQuery("Tariff.getAllTariffs", Tariff.class).getResultList();
    }

    @Override
    protected void doDeleteAll() {
        em.createNamedQuery("Tariff.deleteAllTariffs").executeUpdate();
    }

    @Override
    protected long doSize() {
        return ((Number)em.createNamedQuery("Tariff.size").getSingleResult()).longValue();
    }
}
