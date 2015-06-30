package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;

/**
 * Created by Kolia on 27.06.2015.
 */
@Entity
@Table(name = "available_options", schema = "", catalog = "com/tsystems/javaschool/ecare")
public class AvailableOptionsEntity
{
    private int id;
    private int tariffId;
    private int optionId;

    @Id
    @Column(name = "id")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "tariff_id")
    public int getTariffId()
    {
        return tariffId;
    }

    public void setTariffId(int tariffId)
    {
        this.tariffId = tariffId;
    }

    @Basic
    @Column(name = "option_id")
    public int getOptionId()
    {
        return optionId;
    }

    public void setOptionId(int optionId)
    {
        this.optionId = optionId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvailableOptionsEntity that = (AvailableOptionsEntity) o;

        if (id != that.id) return false;
        if (optionId != that.optionId) return false;
        if (tariffId != that.tariffId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + tariffId;
        result = 31 * result + optionId;
        return result;
    }
}
