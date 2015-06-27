package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;

/**
 * Created by Kolia on 27.06.2015.
 */
@Entity
@Table(name = "contracts", schema = "", catalog = "ecare")
public class ContractsEntity
{
    private int contractId;
    private int userId;
    private int tariffId;

    @Id
    @Column(name = "contract_id")
    public int getContractId()
    {
        return contractId;
    }

    public void setContractId(int contractId)
    {
        this.contractId = contractId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
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
}
