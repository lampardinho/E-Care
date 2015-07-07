package com.tsystems.javaschool.ecare.services;

import com.tsystems.javaschool.ecare.dao.IAbstractDAO;
import com.tsystems.javaschool.ecare.dao.OptionDAO;
import com.tsystems.javaschool.ecare.entities.Option;
import com.tsystems.javaschool.ecare.util.EntityManagerFactoryUtil;
import org.apache.log4j.Logger;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * This class is the implementation of IOptionService for working with option DAO
 * and option entities. Class OptionService is a singleton.
 *
 */

public class OptionService
{

    /*Instance of the singleton class*/
    private static OptionService instance;

    /*Entity manager for working with JPA methods*/
    private EntityManager em = EntityManagerFactoryUtil.getEm();

    /*SQL option implementations of abstract DAO class*/
    private IAbstractDAO<Option> DAO = OptionDAO.getInstance();
    private OptionDAO opDAO = OptionDAO.getInstance();

    /*Logger for option service operations*/
    private static Logger logger = Logger.getLogger(OptionService.getInstance().getClass());

    /*Private constructor of singleton class*/
    private OptionService() {
    }

    /**
     * This method return instance of singleton class OptionService.
     *
     * @return instance of class.
     */
    public static OptionService getInstance()
    {
        if (instance == null)
        {
            instance = new OptionService();
        }
        return instance;
    }

    /**
     * This method implements saving or updating of option in the database.
     *
     * @param op option entity to be saved or updated.
     * @return saved or updated option entity.
     * @throws Exception if an error occurred during saving or updating of entity
     * and DAO returns null.
     */
    public Option saveOrUpdateOption(Option op) throws Exception {
        logger.info("Save/update option " + op + " in DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Option option = DAO.saveOrUpdate(op);
            tx.commit();
            //If DAO returns null method will throws an Exception
            if(option == null) {
                Exception ecx = new Exception("Failed to save/update option " + op + " in DB.");
                logger.error(ecx.getMessage(), ecx);
                throw ecx;
            }
            logger.info("Option " + option + " saved in DB.");
            //else option will be saved and method returns option entity
            return option;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements loading of option from the database.
     *
     * @param id option id for search that option in the database.
     * @return loaded option entity.
     * @throws Exception if an error occurred during loading of entity
     * and DAO returns null.
     */
    public Option loadOption(long id) throws Exception {
        logger.info("Load option with id: " + id + " from DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Option op = DAO.load(id);
            tx.commit();
            //If DAO returns null method will throws an Exception
            if(op == null) {
                Exception ecx = new Exception("Option with id = " + id + " not found in DB.");
                logger.warn(String.valueOf(ecx), ecx);
                throw ecx;
            }
            logger.info("Options " + op + " loaded from DB.");
            //else method returns option entity
            return op;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements deleting of option from the database.
     *
     * @param id option id for deleting that option from the database.
     * @throws Exception if an error occurred during intermediate loading
     * of entity and DAO returns null.
     */
    public void deleteOption(long id) throws Exception {
        logger.info("Delete option with id: " + id + " from DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Option op = DAO.load(id);
            //If DAO returns null method will throws an Exception
            if(op == null) {
                Exception ecx = new Exception("Option with id = " + id + " not exist.");
                logger.warn(ecx.getMessage(), ecx);
                throw ecx;
            }
            // Else option will be deleted from the database.
            DAO.delete(op);
            tx.commit();
            logger.info("Option " + op + " deleted from DB.");
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements receiving of all options from the database.
     *
     * @return list of received options.
     * @throws Exception if an error occurred during receiving of entities
     * and DAO returns null.
     */
    public List<Option> getAllOptions() throws Exception {
        logger.info("Get all options from DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            List<Option> options = DAO.getAll();
            tx.commit();
            //If DAO returns null method will throws an Exception
            if(options == null) {
                Exception ecx = new Exception("Failed to get all options from DB.");
                logger.error(ecx.getMessage(), ecx);
                throw ecx;
            }
            logger.info("All options obtained from DB.");
            // Else method returns list of option entities
            return options;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements receiving of all options for tariff from the database.
     *
     * @param id contract id for searching of all options for this contract.
     * @return list of received options.
     * @throws Exception if an error occurred during receiving of entities
     * and DAO returns null.
     */
    public List<Option> getAllOptionsForTariff(long id) throws Exception{
        logger.info("Get all options from DB for tariff with id: " + id + ".");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            List<Option> options = opDAO.getAllOptionsForTariff(id);
            tx.commit();
            //If DAO returns null method will throws an Exception
            if(options == null) {
                Exception ecx = new Exception("Failed to get all options from DB for tariff id: " + id + ".");
                logger.error(ecx.getMessage(), ecx);
                throw ecx;
            }
            logger.info("All options for tariff id: " + id + " obtained from DB.");
            // Else method returns list of option entities
            return options;
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements deleting of all options for tariff from the database.
     *
     * @param id tariff id for deleting of all options for this tariff.
     */
    public void deleteAllOptionsForTariff(long id) {
        logger.info("Delete all options from DB for tariff with id: " + id + ".");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            opDAO.deleteAllOptionsForTariff(id);
            tx.commit();
            logger.info("All options for tariff id: " + id + " deleted from DB.");
        }
        catch (RuntimeException re) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }

    /**
     * This method implements receiving number of all options from the database.
     *
     * @return number of options in the storage.
     */
    public long getNumberOfOptions() {
        logger.info("Get number of options in DB.");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            long number = DAO.getCount();
            tx.commit();
            logger.info(number + "of options obtained from DB.");
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
