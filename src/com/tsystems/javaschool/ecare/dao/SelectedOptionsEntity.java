package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;

/**
 * Created by Kolia on 27.06.2015.
 */
@Entity
@Table(name = "selected_options", schema = "", catalog = "ecare")
public class SelectedOptionsEntity
{
    private int id;
    private int optionId;
    private int contractId;

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
    @Column(name = "option_id")
    public int getOptionId()
    {
        return optionId;
    }

    public void setOptionId(int optionId)
    {
        this.optionId = optionId;
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
}
