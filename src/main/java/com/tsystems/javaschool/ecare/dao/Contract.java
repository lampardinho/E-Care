package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "contracts", schema = "", catalog = "ecare")
public class Contract
{
    @Id
    @Column(name = "contract_id", nullable = false, insertable = true, updatable = true)
    private int contractId;

    @Basic
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true)
    private int userId;

    @Basic
    @Column(name = "tariff_id", nullable = false, insertable = true, updatable = true)
    private int tariffId;

    @ManyToMany
    @JoinTable(name="contract_locking",
            joinColumns=@JoinColumn(name="contract_id"),
            inverseJoinColumns=@JoinColumn(name="locker_id"))
    private Collection<User> lockedByUsers;

    @ManyToMany
    @JoinTable(name="selected_options",
            joinColumns=@JoinColumn(name="contract_id"),
            inverseJoinColumns=@JoinColumn(name="option_id"))
    private Collection<Option> selectedOptions;


    public int getContractId()
    {
        return contractId;
    }

    public void setContractId(int contractId)
    {
        this.contractId = contractId;
    }


    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }


    public int getTariffId()
    {
        return tariffId;
    }

    public void setTariffId(int tariffId)
    {
        this.tariffId = tariffId;
    }

    public Collection<User> getLockedByUsers()
    {
        return lockedByUsers;
    }

    public void setLockedByUsers(Collection<User> lockedByUsers)
    {
        this.lockedByUsers = lockedByUsers;
    }

    public Collection<Option> getSelectedOptions()
    {
        return selectedOptions;
    }

    public void setSelectedOptions(Collection<Option> selectedOptions)
    {
        this.selectedOptions = selectedOptions;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract that = (Contract) o;

        if (contractId != that.contractId) return false;
        if (tariffId != that.tariffId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = contractId;
        result = 31 * result + userId;
        result = 31 * result + tariffId;
        return result;
    }
}
