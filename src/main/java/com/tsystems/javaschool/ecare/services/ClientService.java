package com.tsystems.javaschool.ecare.services;

import com.tsystems.javaschool.ecare.dao.IAbstractDAO;
import com.tsystems.javaschool.ecare.dao.UserDAO;
import com.tsystems.javaschool.ecare.entities.User;
import com.tsystems.javaschool.ecare.util.EntityManagerFactoryUtil;
import org.apache.log4j.Logger;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;

/**
 * This class is the implementation of IClientService for working with client DAO
 * and client entities. Class ClientService is a singleton.
 *
 */

public class ClientService
{

    /*Instance of the singleton class*/
    private static ClientService instance;

    /*Entity manager for working with JPA methods*/
    private EntityManagerFactory emf = EntityManagerFactoryUtil.getEmf();

    /*SQL client implementations of abstract DAO class*/
    private IAbstractDAO<User> DAO = UserDAO.getInstance();
    private UserDAO clDAO = UserDAO.getInstance();

    /*Logger for client service operations*/
    private static Logger logger = Logger.getLogger(ClientService.getInstance().getClass());

    /*Private constructor of singleton class*/
    private ClientService() {
    }

    /**
     * This method return instance of singleton class ClientService.
     * @return instance of class.
     */
    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }
        return instance;
    }

    /**
     * Method implements saving or updating of clients in the database.
     *
     * @param cl client entity to be saved or updated.
     * @return saved or updated client entity.
     * @throws Exception if an error occurred during saving or updating of entity
     * and DAO returns null.
     */
    public User saveOrUpdateClient(User cl) throws Exception {
        logger.info("Save/update client " + cl + " in DB.");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            User client = DAO.saveOrUpdate(cl);
            et.commit();
            //If DAO returns null method will throws an Exception
            if(client == null) {
                Exception ecx = new Exception("Failed to save/update client " + cl + " in DB.");
                logger.error(ecx.getMessage(), ecx);
                throw ecx;
            }
            logger.info("Client " + client + " saved/updated in DB.");
            //else client will be saved and method returns client entity
            return client;
        }
        catch (RuntimeException re) {
            if(et.isActive()) {
                et.rollback();
            }
            throw re;
        }
    }

    /**
     * Method implements loading of clients from the database.
     *
     * @param id client id for search that client in the database.
     * @return loaded client entity.
     * @throws Exception if an error occurred during loading of entity
     * and DAO returns null.
     */
    public User loadClient(long id) throws Exception {
        logger.info("Load client with id: " + id + " from DB.");
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            User cl = DAO.load(id);
            et.commit();
            //If DAO returns null method will throws an Exception
            if(cl == null) {
                Exception ecx = new Exception("Client with id = " + id + " not found in DB.");
                logger.warn(ecx.getMessage(), ecx);
                throw ecx;
            }
            logger.info("Client " + cl + " loaded from DB.");
            //else method returns client entity
            return cl;
        }
        catch (RuntimeException re) {
            if(et.isActive()) {
                et.rollback();
            }
            throw re;
        }
    }

    /**
     * Method implements finding of clients by their login and password in
     * the database.
     *
     * @param login client login for search that client in the database.
     * @param password client password for search that client in the database.
     * @return found client entity.
     * @throws Exception if DAO returns NoResultException during finding of client
     * in the database.
     */
    public User findClient(String login, String password) throws Exception {
        logger.info("Find client with login: " + login + " and password:" + password + " in DB.");
        User cl = null;
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            try {
                // Searching of client in the database by DAO method.
                cl = clDAO.findClientByLoginAndPassword(login, password);
                // If client does not exist in database, block try catches the NoResultException and
                // throws an Exception.
            } catch(NoResultException nrx) {
                Exception ecx = new Exception("Incorrect login/password or client does not exist.", nrx);
                logger.warn(ecx.getMessage(), nrx);
                throw ecx;
            }
            et.commit();
            logger.info("Client " + cl + " found and loaded from DB.");
            return cl;
        }
        catch (RuntimeException re) {
            if(et.isActive()) {
                et.rollback();
            }
            throw re;
        }
    }

    /**
     * Method implements finding of clients by their telephone number in the database.
     *
     * @param number telephone number of client for search that client in the database.
     * @return found client entity.
     * @throws Exception if DAO returns NoResultException during finding of client
     * in the database.
     */
    public User findClientByNumber(long number) throws Exception {
        logger.info("Find client with telephone number: " + number + " in DB.");
        EntityTransaction et = em.getTransaction();
        User cl = null;
        try {
            et.begin();
            try {
                // Search of client in the database by DAO method.
                cl = clDAO.findClientByNumber(number);
                // If client does not exist in database, block try catches the NoResultException and
                // throws an Exception.
            } catch(NoResultException nrx) {
                Exception ecx = new Exception("Client with number: " + number + " not found.", nrx);
                logger.warn(ecx.getMessage(), nrx);
                throw ecx;
            }
            et.commit();
            logger.info("Client " + cl + " found and loaded from DB.");
            return cl;
        }
        catch (RuntimeException re) {
            if(et.isActive()) {
                et.rollback();
            }
            throw re;
        }
    }

    /**
     * Method implements deleting of clients from the database.
     *
     * @param id client id for deleting that client from the database.
     * @throws Exception if an error occurred during intermediate loading
     * of entity and DAO returns null.
     */
    public void deleteClient(long id) throws Exception {
        logger.info("Delete client with id: " + id + " from DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User cl = DAO.load(id);
            //If DAO returns null method will throws an Exception.
            if(cl == null) {
                Exception ecx = new Exception("Client with id = " + id + " not exist.");
                logger.warn(ecx.getMessage(), ecx);
                throw ecx;
            }
            // Else client will be deleted from the database.
            DAO.delete(cl);
            tx.commit();
            logger.info("Client " + cl + " deleted from DB.");
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * Method implements receiving of all clients from the database.
     *
     * @return list of received clients.
     * @throws Exception if an error occurred during receiving of entities
     * and DAO returns null.
     */
    public List<User> getAllClients() throws Exception {
        logger.info("Get all clients from DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            List<User> clients = DAO.getAll();
            tx.commit();
            //If DAO returns null method will throws an Exception.
            if(clients == null) {
                Exception ecx = new Exception("Failed to get all clients from DB.");
                logger.error(ecx.getMessage(), ecx);
                throw ecx;
            }
            logger.info("All clients obtained from DB.");
            // Else method returns list of client entities
            return clients;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * Method implements deleting of all clients from the database.
     */
    public void deleteAllClients() {
        logger.info("Delete all clients from DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            DAO.deleteAll();
            tx.commit();
            logger.info("All clients deleted from DB.");
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * Method implements receiving number of all clients from the database.
     *
     * @return number of clients in the database.
     */
    public long getNumberOfClients() {
        logger.info("Get number of clients in DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            long number = DAO.getCount();
            tx.commit();
            logger.info(number + "of clients obtained fromDB.");
            return number;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements searching of client in database by client login.
     *
     * @param login client login
     * @return true if client with input login exist, or false if client not exist.
     */
    public boolean existLogin(String login) {
        logger.info("Find client with login: " + login + " in DB.");
        User cl = null;
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            try {
                // Search of client in the database by DAO method.
                cl = clDAO.findClientByLogin(login);
                // If client does not exist in database, block try catches the NoResultException and
                // return false.
            } catch(NoResultException nrx) {
                et.commit();
                logger.warn("Client with login: " + login + " does not exist.");
                return false;
            }
            et.commit();
            logger.info("Client " + cl + " found in DB.");
            // Else, if client exist and loaded, method return true.
            return true;
        }
        catch (RuntimeException re) {
            if(et.isActive()) {
                et.rollback();
            }
            throw re;
        }
    }
}
