package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "tariffs", schema = "", catalog = "ecare")
public class Tariff
{
    @Id
    @Column(name = "tariff_id", nullable = false, insertable = true, updatable = true)
    private int tariffId;

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    private String name;

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    private int price;

    @ManyToMany
    @JoinTable(name="available_options",
            joinColumns=@JoinColumn(name="tariff_id"),
            inverseJoinColumns=@JoinColumn(name="option_id"))
    private Collection<Option> availableOptions;

    public int getTariffId()
    {
        return tariffId;
    }

    public void setTariffId(int tariffId)
    {
        this.tariffId = tariffId;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }


    public Collection<Option> getAvailableOptions()
    {
        return availableOptions;
    }

    public void setAvailableOptions(Collection<Option> availableOptions)
    {
        this.availableOptions = availableOptions;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tariff that = (Tariff) o;

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
}
