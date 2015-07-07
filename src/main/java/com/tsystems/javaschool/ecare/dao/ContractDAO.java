package com.tsystems.javaschool.ecare.dao;


import com.tsystems.javaschool.ecare.entities.Contract;
import com.tsystems.javaschool.ecare.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


public class ContractDAO implements IAbstractDAO<Contract>
{
    private static volatile ContractDAO instance;
    private EntityManagerFactory emf = EntityManagerFactoryUtil.getEmf();

    private ContractDAO() {
    }

    public static ContractDAO getInstance() {
        ContractDAO localInstance = instance;
        if (localInstance == null) {
            synchronized (ContractDAO.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ContractDAO();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Contract saveOrUpdate(Contract cn) {
        return em.merge(cn);
    }

    @Override
    public Contract load(long id) {
        return em.find(Contract.class, id);
    }

    public Contract findContractByNumber(long number) {
        Query query = em.createNamedQuery("Contract.findContractByNumber", Contract.class);
        query.setParameter("number", number);
        return (Contract) query.getSingleResult();
    }

    @Override
    public void delete(Contract cn) {
        em.remove(cn);
    }

    @Override
    public List<Contract> getAll() {
        return em.createNamedQuery("Contract.getAllContracts", Contract.class).getResultList();
    }

    public List<Contract> getAllContractsForClient(long id) {
        Query query = em.createNamedQuery("Contract.getAllContractsForClient", Contract.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void deleteAll() {
        em.createNamedQuery("Contract.deleteAllContracts").executeUpdate();
    }

    public void deleteAllContractsForClient(long id) {
        Query query = em.createNamedQuery("Contract.deleteAllContractsForClient");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Override
    public long getCount() {
        return ((Number)em.createNamedQuery("Contract.size").getSingleResult()).longValue();
    }
}
