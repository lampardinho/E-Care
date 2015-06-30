package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "selected_options", schema = "", catalog = "ecare")
public class SelectedOptionsEntity
{
    private int id;
    private int optionId;
    private int contractId;
    private OptionsEntity optionsByOptionId;
    private ContractsEntity contractsByContractId;

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
    @Column(name = "contract_id", nullable = false, insertable = true, updatable = true)
    public int getContractId()
    {
        return contractId;
    }

    public void setContractId(int contractId)
    {
        this.contractId = contractId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectedOptionsEntity that = (SelectedOptionsEntity) o;

        if (contractId != that.contractId) return false;
        if (id != that.id) return false;
        if (optionId != that.optionId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + optionId;
        result = 31 * result + contractId;
        return result;
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
}
