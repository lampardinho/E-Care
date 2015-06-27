package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;

/**
 * Created by Kolia on 27.06.2015.
 */
@Entity
@Table(name = "options", schema = "", catalog = "ecare")
public class OptionsEntity
{
    private int optionId;
    private String name;
    private int connectionPrice;
    private int monthlyPrice;

    @Id
    @Column(name = "option_id")
    public int getOptionId()
    {
        return optionId;
    }

    public void setOptionId(int optionId)
    {
        this.optionId = optionId;
    }

    @Basic
    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "connection_price")
    public int getConnectionPrice()
    {
        return connectionPrice;
    }

    public void setConnectionPrice(int connectionPrice)
    {
        this.connectionPrice = connectionPrice;
    }

    @Basic
    @Column(name = "monthly_price")
    public int getMonthlyPrice()
    {
        return monthlyPrice;
    }

    public void setMonthlyPrice(int monthlyPrice)
    {
        this.monthlyPrice = monthlyPrice;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OptionsEntity that = (OptionsEntity) o;

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
