package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "contract_locking", schema = "", catalog = "ecare")
public class ContractLockingEntity
{
    private int id;
    private int contractId;
    private int lockerId;
    private ContractsEntity contractsByContractId;
    private UsersEntity usersByLockerId;

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
    @Column(name = "locker_id", nullable = false, insertable = true, updatable = true)
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

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id", nullable = false)
    public ContractsEntity getContractsByContractId()
    {
        return contractsByContractId;
    }

    public void setContractsByContractId(ContractsEntity contractsByContractId)
    {
        this.contractsByContractId = contractsByContractId;
    }

    @ManyToOne
    @JoinColumn(name = "locker_id", referencedColumnName = "user_id", nullable = false)
    public UsersEntity getUsersByLockerId()
    {
        return usersByLockerId;
    }

    public void setUsersByLockerId(UsersEntity usersByLockerId)
    {
        this.usersByLockerId = usersByLockerId;
    }
}
