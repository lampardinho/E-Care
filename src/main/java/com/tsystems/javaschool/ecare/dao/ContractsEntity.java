package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "contracts", schema = "", catalog = "ecare")
public class ContractsEntity
{
    private int contractId;
    private int userId;
    private int tariffId;
    private Collection<ContractLockingEntity> contractLockingsByContractId;
    private UsersEntity usersByUserId;
    private TariffsEntity tariffsByTariffId;
    private Collection<SelectedOptionsEntity> selectedOptionsesByContractId;

    @Id
    @Column(name = "contract_id", nullable = false, insertable = true, updatable = true)
    public int getContractId()
    {
        return contractId;
    }

    public void setContractId(int contractId)
    {
        this.contractId = contractId;
    }

    @Basic
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true)
    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractsEntity that = (ContractsEntity) o;

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

    @OneToMany(mappedBy = "contractsByContractId")
    public Collection<ContractLockingEntity> getContractLockingsByContractId()
    {
        return contractLockingsByContractId;
    }

    public void setContractLockingsByContractId(Collection<ContractLockingEntity> contractLockingsByContractId)
    {
        this.contractLockingsByContractId = contractLockingsByContractId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UsersEntity getUsersByUserId()
    {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId)
    {
        this.usersByUserId = usersByUserId;
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

    @OneToMany(mappedBy = "contractsByContractId")
    public Collection<SelectedOptionsEntity> getSelectedOptionsesByContractId()
    {
        return selectedOptionsesByContractId;
    }

    public void setSelectedOptionsesByContractId(Collection<SelectedOptionsEntity> selectedOptionsesByContractId)
    {
        this.selectedOptionsesByContractId = selectedOptionsesByContractId;
    }
}
