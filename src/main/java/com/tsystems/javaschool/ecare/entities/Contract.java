package com.tsystems.javaschool.ecare.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "contracts", schema = "", catalog = "ecare")
@NamedQueries(
        {
                @NamedQuery (name = "Contract.getAllContracts", query = "SELECT c FROM Contract c"),
                @NamedQuery (name = "Contract.findContractByNumber", query = "SELECT c FROM Contract c WHERE c.number = :number"),
                @NamedQuery (name = "Contract.getAllContractsForClient", query = "SELECT c FROM Contract c WHERE c.client.id = :id"),
                @NamedQuery (name = "Contract.deleteAllContracts", query="DELETE FROM Contract"),
                @NamedQuery (name = "Contract.deleteAllContractsForClient", query = "DELETE FROM Contract WHERE client.id = ?1"),
                @NamedQuery (name = "Contract.size", query="SELECT count(c) FROM Contract c")
        })
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

    private int phoneNumber;

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


    public int getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }


    public Contract(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
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
