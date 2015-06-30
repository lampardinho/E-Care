package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "options", schema = "", catalog = "ecare")
public class OptionsEntity
{
    private int optionId;
    private String name;
    private int connectionPrice;
    private int monthlyPrice;
    private Collection<AvailableOptionsEntity> availableOptionsesByOptionId;
    private Collection<OptionLockingEntity> optionLockingsByOptionId;
    private Collection<OptionLockingEntity> optionLockingsByOptionId_0;
    private Collection<SelectedOptionsEntity> selectedOptionsesByOptionId;

    @Id
    @Column(name = "option_id", nullable = false, insertable = true, updatable = true)
    public int getOptionId()
    {
        return optionId;
    }

    public void setOptionId(int optionId)
    {
        this.optionId = optionId;
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
    @Column(name = "connection_price", nullable = false, insertable = true, updatable = true)
    public int getConnectionPrice()
    {
        return connectionPrice;
    }

    public void setConnectionPrice(int connectionPrice)
    {
        this.connectionPrice = connectionPrice;
    }

    @Basic
    @Column(name = "monthly_price", nullable = false, insertable = true, updatable = true)
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

    @OneToMany(mappedBy = "optionsByOptionId")
    public Collection<AvailableOptionsEntity> getAvailableOptionsesByOptionId()
    {
        return availableOptionsesByOptionId;
    }

    public void setAvailableOptionsesByOptionId(Collection<AvailableOptionsEntity> availableOptionsesByOptionId)
    {
        this.availableOptionsesByOptionId = availableOptionsesByOptionId;
    }

    @OneToMany(mappedBy = "optionsBySelectedOptionId")
    public Collection<OptionLockingEntity> getOptionLockingsByOptionId()
    {
        return optionLockingsByOptionId;
    }

    public void setOptionLockingsByOptionId(Collection<OptionLockingEntity> optionLockingsByOptionId)
    {
        this.optionLockingsByOptionId = optionLockingsByOptionId;
    }

    @OneToMany(mappedBy = "optionsByLockedOptionId")
    public Collection<OptionLockingEntity> getOptionLockingsByOptionId_0()
    {
        return optionLockingsByOptionId_0;
    }

    public void setOptionLockingsByOptionId_0(Collection<OptionLockingEntity> optionLockingsByOptionId_0)
    {
        this.optionLockingsByOptionId_0 = optionLockingsByOptionId_0;
    }

    @OneToMany(mappedBy = "optionsByOptionId")
    public Collection<SelectedOptionsEntity> getSelectedOptionsesByOptionId()
    {
        return selectedOptionsesByOptionId;
    }

    public void setSelectedOptionsesByOptionId(Collection<SelectedOptionsEntity> selectedOptionsesByOptionId)
    {
        this.selectedOptionsesByOptionId = selectedOptionsesByOptionId;
    }
}
