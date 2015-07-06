package com.tsystems.javaschool.ecare.services;



import com.tsystems.javaschool.ecare.entities.Option;

import java.util.List;

/**
 * Interface of service level for option entity. It is an intermediate level
 * between controllers and option DAO.
 *
 */

public interface IOptionService {

    /**
     * This method provides saving or updating of option in the storage.
     *
     * @param op option entity to be saved or updated.
     * @return saved or updated option entity.
     */
    public Option saveOrUpdateOption(Option op) throws Exception;

    /**
     * This method provides loading of option from the storage.
     *
     * @param id option id for search that option in the storage.
     * @return loaded option entity.
     */
    public Option loadOption(long id) throws Exception;

    /**
     * This method provides deleting of option from the storage.
     *
     * @param id option id for deleting that option from the storage.
     */
    public void deleteOption(long id) throws Exception;

    /**
     * This method provides receiving of all options from the storage.
     *
     * @return list of received options.
     */
    public List<Option> getAllOptions() throws Exception;

    /**
     * This method provides receiving of all options for tariff from the storage.
     *
     * @param id contract id for searching of all options for this contract.
     * @return list of received options.
     */
    public List<Option> getAllOptionsForTariff(long id) throws Exception;

    /**
     * This method provides deleting of all options for tariff from the storage.
     *
     * @param id tariff id for deleting of all options for this tariff.
     */
    public void deleteAllOptionsForTariff(long id);

    /**
     * This method provides receiving number of all options from the storage.
     *
     * @return number of options in the storage.
     */
    public long getNumberOfOptions();


}
