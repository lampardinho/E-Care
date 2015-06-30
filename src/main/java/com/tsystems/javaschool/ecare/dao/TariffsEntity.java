package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "tariffs", schema = "", catalog = "ecare")
public class TariffsEntity
{
    private int tariffId;
    private String name;
    private int price;
    private Collection<AvailableOptionsEntity> availableOptionsesByTariffId;
    private Collection<ContractsEntity> contractsesByTariffId;

    @Id
    @Column(name = "tariff_id", nullable = false, insertable = true, updatable = true)
    public int getTariffId()
    {
        return tariffId;
    }

    public void setTariffId(int tariffId)
    {
        this.tariffId = tariffId;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffsEntity that = (TariffsEntity) o;

        if (price != that.price) return false;
        if (tariffId != that.tariffId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = tariffId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @OneToMany(mappedBy = "tariffsByTariffId")
    public Collection<AvailableOptionsEntity> getAvailableOptionsesByTariffId()
    {
        return availableOptionsesByTariffId;
    }

    public void setAvailableOptionsesByTariffId(Collection<AvailableOptionsEntity> availableOptionsesByTariffId)
    {
        this.availableOptionsesByTariffId = availableOptionsesByTariffId;
    }

    @OneToMany(mappedBy = "tariffsByTariffId")
    public Collection<ContractsEntity> getContractsesByTariffId()
    {
        return contractsesByTariffId;
    }

    public void setContractsesByTariffId(Collection<ContractsEntity> contractsesByTariffId)
    {
        this.contractsesByTariffId = contractsesByTariffId;
    }
}
