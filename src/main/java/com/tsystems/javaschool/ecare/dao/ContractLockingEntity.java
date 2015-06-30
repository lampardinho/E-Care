package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;

/**
 * Created by Kolia on 27.06.2015.
 */
@Entity
@Table(name = "contract_locking", schema = "", catalog = "com/tsystems/javaschool/ecare")
public class ContractLockingEntity
{
    private int id;
    private int contractId;
    private int lockerId;

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
    @Column(name = "locker_id")
    public int getLockerId()
    {
        return lockerId;
    }

    public void setLockerId(int lockerId)
    {
        this.lockerId = lockerId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractLockingEntity that = (ContractLockingEntity) o;

        if (contractId != that.contractId) return false;
        if (id != that.id) return false;
        if (lockerId != that.lockerId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + contractId;
        result = 31 * result + lockerId;
        return result;
    }
}
