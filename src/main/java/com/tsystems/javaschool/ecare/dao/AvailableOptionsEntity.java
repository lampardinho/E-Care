package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "available_options", schema = "", catalog = "ecare")
public class AvailableOptionsEntity
{
    private int id;
    private int tariffId;
    private int optionId;
    private TariffsEntity tariffsByTariffId;
    private OptionsEntity optionsByOptionId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
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
    @Column(name = "option_id", nullable = false, insertable = true, updatable = true)
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

    @ManyToOne
    @JoinColumn(name = "tariff_id", referencedColumnName = "tariff_id", nullable = false)
    public TariffsEntity getTariffsByTariffId()
    {
        return tariffsByTariffId;
    }

    public void setTariffsByTariffId(TariffsEntity tariffsByTariffId)
    {
        this.tariffsByTariffId = tariffsByTariffId;
    }

    @ManyToOne
    @JoinColumn(name = "option_id", referencedColumnName = "option_id", nullable = false)
    public OptionsEntity getOptionsByOptionId()
    {
        return optionsByOptionId;
    }

    public void setOptionsByOptionId(OptionsEntity optionsByOptionId)
    {
        this.optionsByOptionId = optionsByOptionId;
    }
}
