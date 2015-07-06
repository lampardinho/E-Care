package com.tsystems.javaschool.ecare.services;


import com.tsystems.javaschool.ecare.entities.Contract;
import com.tsystems.javaschool.ecare.entities.Option;
import com.tsystems.javaschool.ecare.entities.Tariff;

import java.util.List;

/**
 * Interface of service level for contract entity. It is an intermediate level
 * between controllers and contract DAO.
 *
 */

public interface IContractService {

    /**
     * This method provides saving or updating of contracts in the storage.
     *
     * @param cn contract entity to be saved or updated.
     * @return saved or updated contract entity.
     */
    public Contract saveOrUpdateContract(Contract cn) throws Exception;

    /**
     * This method provides loading of contracts from the storage.
     *
     * @param id contract id for search that contract in the storage.
     * @return loaded contract entity.
     */
    public Contract loadContract(long id) throws Exception;

    /**
     * This method provides finding of contracts by telephone number in
     * the storage.
     *
     * @param number contract number for search that contract in the storage.
     * @return found contract entity.
     */
    public Contract findContractByNumber(long number) throws Exception;

    /**
     * This method provides deleting of contract from the storage.
     *
     * @param id contract id for deleting that contract from the storage.
     */
    public void deleteContract(long id) throws Exception;

    /**
     * This method provides receiving of all contracts from the storage.
     *
     * @return list of received contracts.
     */
    public List<Contract> getAllContracts() throws Exception;

    /**
     * This method provides receiving of all contracts for client from the storage.
     *
     * @param id client id for searching of all contracts for this client.
     * @return list of received contracts.
     */
    public List<Contract> getAllContractsForClient(long id) throws Exception;

    /**
     * This method provides deleting of all contracts from the storage.
     */
    public void deleteAllContracts();

    /**
     * This method provides deleting of all contracts for client from the storage.
     *
     * @param id client id for deleting of all contracts for this client.
     */
    public void deleteAllContractsForClient(long id);

    /**
     * This method provides receiving number of all contracts from the storage.
     *
     * @return number of contracts in the storage.
     */
    public long getNumberOfContracts();



}
