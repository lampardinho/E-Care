package com.tsystems.javaschool.ecare.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "options", schema = "", catalog = "ecare")
@NamedQueries(
        {
                @NamedQuery (name = "Option.getAllOptions", query = "SELECT o FROM Option o"),
                @NamedQuery (name = "Option.findOptionByTitleAndTariffId", query = "SELECT o FROM Option o WHERE o.name = :title AND o.tariff.id = :id"),
                @NamedQuery (name = "Option.getAllOptionsForTariff", query = "SELECT o FROM Option o WHERE o.tariff.id = :id"),
                @NamedQuery (name = "Option.deleteAllOptions", query = "DELETE FROM Option"),
                @NamedQuery (name = "Option.deleteAllOptionsForTariff", query = "DELETE FROM Option WHERE tariff.id = ?1"),
                @NamedQuery (name = "Option.size", query="SELECT count(o) FROM Option o")
        })
public class Option
{
    @Id
    @Column(name = "option_id", nullable = false, insertable = true, updatable = true)
    private int optionId;

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    private String name;

    @Basic
    @Column(name = "connection_price", nullable = false, insertable = true, updatable = true)
    private int connectionPrice;

    @Basic
    @Column(name = "monthly_price", nullable = false, insertable = true, updatable = true)
    private int monthlyPrice;

    @ManyToMany
    @JoinTable(name="available_options",
            joinColumns=@JoinColumn(name="option_id"),
            inverseJoinColumns=@JoinColumn(name="tariff_id"))
    private Collection<Tariff> availableTariffs;

    @ManyToMany
    @JoinTable(name="option_locking",
            joinColumns=@JoinColumn(name="selected_option_id"),
            inverseJoinColumns=@JoinColumn(name="locked_option_id"))
    private Collection<Option> lockedOptions;


    public int getOptionId()
    {
        return optionId;
    }

    public void setOptionId(int optionId)
    {
        this.optionId = optionId;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public int getConnectionPrice()
    {
        return connectionPrice;
    }

    public void setConnectionPrice(int connectionPrice)
    {
        this.connectionPrice = connectionPrice;
    }


    public int getMonthlyPrice()
    {
        return monthlyPrice;
    }

    public void setMonthlyPrice(int monthlyPrice)
    {
        this.monthlyPrice = monthlyPrice;
    }

    public Collection<Tariff> getAvailableTariffs()
    {
        return availableTariffs;
    }

    public void setAvailableTariffs(Collection<Tariff> availableTariffs)
    {
        this.availableTariffs = availableTariffs;
    }

    public Collection<Option> getLockedOptions()
    {
        return lockedOptions;
    }

    public void setLockedOptions(Collection<Option> lockedOptions)
    {
        this.lockedOptions = lockedOptions;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option that = (Option) o;

        if (connectionPrice != that.connectionPrice) return false;
        if (monthlyPrice != that.monthlyPrice) return false;
        if (optionId != that.optionId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = optionId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + connectionPrice;
        result = 31 * result + monthlyPrice;
        return result;
    }


}
