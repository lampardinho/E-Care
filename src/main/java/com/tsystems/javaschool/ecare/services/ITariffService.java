package com.tsystems.javaschool.ecare.services;


import com.tsystems.javaschool.ecare.entities.Tariff;

import java.util.List;

/**
 * Interface of service level for tariff entity. It is an intermediate level
 * between controllers and tariff DAO.
 *
 */

public interface ITariffService {

    /**
     * This method provides saving or updating of tariff in the storage.
     *
     * @param tr tariff entity to be saved or updated.
     * @return saved or updated tariff entity.
     */
    public Tariff saveOrUpdateTariff(Tariff tr) throws Exception;

    /**
     * This method provides loading of tariff from the storage.
     *
     * @param id tariff id for search that tariff in the storage.
     * @return loaded tariff entity.
     */
    public Tariff loadTariff(long id) throws Exception;

    /**
     * This method provides deleting of tariff from the storage.
     *
     * @param id tariff id for deleting that tariff from the storage.
     */
    public void deleteTariff(long id) throws Exception;

    /**
     * This method provides receiving of all options from the storage.
     *
     * @return list of received tariffs.
     */
    public List<Tariff> getAllTariffs() throws Exception;

    /**
     * This method provides deleting of all tariffs from the storage.
     */
    public void deleteAllTariffs();

    /**
     * This method provides receiving number of all tariffs from the storage.
     *
     * @return number of tariffs in the storage.
     */
    public long getNumberOfTariffs();
}
