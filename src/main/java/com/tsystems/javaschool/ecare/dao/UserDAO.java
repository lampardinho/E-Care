package com.tsystems.javaschool.ecare.dao;


import com.tsystems.javaschool.ecare.entities.User;
import com.tsystems.javaschool.ecare.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class UserDAO implements IAbstractDAO<User>
{
    private static UserDAO instance;
    private EntityManager em = EntityManagerFactoryUtil.getEm();

    private UserDAO() {
    }

    public static UserDAO getInstance()
    {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    @Override
    public User saveOrUpdate(User cl) {
        return em.merge(cl);
    }

    @Override
    public User load(long id) {
        return em.find(User.class, id);
    }

    public User findClientByLoginAndPassword(String login, String password) {
        Query query = em.createNamedQuery("Client.findClientByLoginAndPassword", User.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }

    public User findClientByNumber(long number) {
        Query query = em.createNamedQuery("Client.findClientByNumber", User.class);
        query.setParameter("number", number);
        return (User) query.getSingleResult();
    }

    @Override
    public void delete(User cl) {
        em.remove(cl);
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery("Client.getAllClients", User.class).getResultList();
    }

    @Override
    public void deleteAll() {
        em.createNamedQuery("Client.deleteAllClients").executeUpdate();
    }

    @Override
    public long getCount() {
        return ((Number)em.createNamedQuery("Client.size").getSingleResult()).longValue();
    }

    public User findClientByLogin(String login) {
        Query query = em.createNamedQuery("Client.findClientByLogin", User.class);
        query.setParameter("login", login);
        return (User) query.getSingleResult();
    }
}
