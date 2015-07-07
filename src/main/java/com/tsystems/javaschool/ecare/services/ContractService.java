package com.tsystems.javaschool.ecare.services;

import com.tsystems.javaschool.ecare.dao.IAbstractDAO;
import com.tsystems.javaschool.ecare.dao.ContractDAO;
import com.tsystems.javaschool.ecare.entities.Contract;
import com.tsystems.javaschool.ecare.util.EntityManagerFactoryUtil;
import org.apache.log4j.Logger;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;

/**
 * This class is the implementation of IContractService for working with contract DAO
 * and contract entities. Class ContractService is a singleton.
 *
 */

public class ContractService
{

    /*Instance of the singleton class*/
    private static ContractService instance;

    /*Entity manager for working with JPA methods*/
    private EntityManager em = EntityManagerFactoryUtil.getEm();

    /*SQL contract implementations of abstract DAO class*/
    private IAbstractDAO<Contract> DAO = ContractDAO.getInstance();
    private ContractDAO cnDAO = ContractDAO.getInstance();

    /*Client service instance for some methods of working with client amount in contract service*/
    private ClientService clientService = ClientService.getInstance();

    /*Logger for contract service operations*/
    private static Logger logger = Logger.getLogger(ContractService.getInstance().getClass());

    /*Private constructor of singleton class*/
    private ContractService() {
    }

    /**
     * This method return instance of singleton class ContractService.
     *
     * @return instance of class.
     */
    public static ContractService getInstance()
    {
        if (instance == null)
        {
            instance = new ContractService();
        }
        return instance;
    }

    /**
     * Method implements saving or updating of contracts in the database.
     *
     * @param cn contract entity to be saved or updated.
     * @return saved or updated contract entity.
     * @throws Exception if an error occurred during saving or updating of entity
     * and DAO returns null.
     */
    public Contract saveOrUpdateContract(Contract cn) throws Exception {
        logger.info("Save/update contract " + cn + " in DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Contract contract = DAO.saveOrUpdate(cn);
            tx.commit();
            //If DAO returns null method will throws an Exception
            if(contract == null) {
                Exception ecx = new Exception("Failed to save/update contract " + cn + " in DB.");
                logger.error(ecx.getMessage(), ecx);
                throw ecx;
            }
            logger.info("Contract " + contract + " saved/updated in DB.");
            //else contract will be saved and method returns contract entity
            return contract;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements loading of contracts from the database.
     *
     * @param id contract id for search that contract in the database.
     * @return loaded contract entity.
     * @throws Exception if an error occurred during loading of entity
     * and DAO returns null.
     */
    public Contract loadContract(long id) throws Exception {
        logger.info("Load contract with id: " + id + " from DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Contract cn = DAO.load(id);
            tx.commit();
            //If DAO returns null method will throws an Exception
            if(cn == null) {
                Exception ecx = new Exception("Contract with id = " + id + " not found in DB.");
                logger.warn(ecx.getMessage(), ecx);
                throw ecx;
            }
            logger.info("Contract " + cn + " loaded from DB.");
            //else method returns contract entity
            return cn;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements finding of contracts by telephone number in
     * the database.
     *
     * @param number contract number for search that contract in the database.
     * @return found contract entity.
     * @throws Exception if DAO returns NoResultException during finding of contract
     * in the database.
     */
    public Contract findContractByNumber(long number) throws Exception {
        logger.info("Find contract by telephone number: " + number + " in DB.");
        Contract cn = null;
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            try {
                // Search of contract in the database by DAO method.
                cn = cnDAO.findContractByNumber(number);
                // If contract does not exist in database, block try catches the NoResultException and
                // throws an Exception.
            } catch(NoResultException nrx) {
                Exception ecx = new Exception("Contract with number: " + number + " not found.", nrx);
                logger.warn(ecx.getMessage(), nrx);
                throw ecx;
            }
            et.commit();
            logger.info("Contract " + cn + " found and loaded from DB.");
            return cn;
        }
        catch (RuntimeException re) {
            if(et.isActive()) {
                et.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements deleting of contract from the database.
     *
     * @param id contract id for deleting that contract from the database.
     * @throws Exception if an error occurred during intermediate loading
     * of entity and DAO returns null.
     */
    public void deleteContract(long id) throws Exception {
        logger.info("Delete contract with id: " + id + " from DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Contract cn = DAO.load(id);
            //If DAO returns null method will throws an Exception.
            if(cn == null) {
                Exception ecx = new Exception("Contract with id = " + id + " not exist.");
                logger.warn(ecx.getMessage(), ecx);
                throw ecx;
            }
            // Else contract will be deleted from the database.
            DAO.delete(cn);
            tx.commit();
            logger.info("Contract " + cn + " deleted from DB.");
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements receiving of all contracts from the database.
     *
     * @return list of received contracts.
     * @throws Exception if an error occurred during receiving of entities
     * and DAO returns null.
     */
    public List<Contract> getAllContracts() throws Exception {
        logger.info("Get all contracts from DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            List<Contract> contracts = DAO.getAll();
            tx.commit();
            //If DAO returns null method will throws an Exception
            if(contracts == null) {
                Exception ecx = new Exception("Failed to get all contracts from DB.");
                logger.error(ecx.getMessage(), ecx);
                throw ecx;
            }
            logger.info("All contracts obtained from DB.");
            // Else method returns list of contract entities.
            return contracts;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements receiving of all contracts for client from the database.
     *
     * @param id client id for searching of all contracts for this client.
     * @return list of received contracts.
     * @throws Exception if an error occurred during receiving of entities
     * and DAO returns null.
     */
    public List<Contract> getAllContractsForClient(long id) throws Exception {
        logger.info("Get all contracts from DB for client with id: " + id + ".");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            List<Contract> contracts = cnDAO.getAllContractsForClient(id);
            tx.commit();
            //If DAO returns null method will throws an Exception
            if(contracts == null) {
                Exception ecx = new Exception("Failed to get all contracts from DB.");
                logger.error(ecx.getMessage(), ecx);
                throw ecx;
            }
            logger.info("All contracts for client id: " + id + " obtained from DB.");
            // Else method returns list of contract entities
            return contracts;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements deleting of all contracts from the database.
     */
    public void deleteAllContracts() {
        logger.info("Delete all contracts from DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            DAO.deleteAll();
            tx.commit();
            logger.info("All contracts deleted from DB.");
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements deleting of all contracts for client from the database.
     *
     * @param id client id for deleting of all contracts for this client
     */
    public void deleteAllContractsForClient(long id) {
        logger.info("Delete all contracts from DB for client with id: " + id + ".");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            cnDAO.deleteAllContractsForClient(id);
            tx.commit();
            logger.info("All contracts for client id: " + id + " deleted from DB.");
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements receiving number of all contracts from the database.
     *
     * @return number of contracts in the database.
     */
    public long getNumberOfContracts() {
        logger.info("Get number of contracts in DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            long number = DAO.getCount();
            tx.commit();
            logger.info(number + "of contracts obtained from DB.");
            return number;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }


}
