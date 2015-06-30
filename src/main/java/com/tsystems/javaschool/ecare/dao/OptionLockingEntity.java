package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;

/**
 * Created by Kolia on 01.07.2015.
 */
@Entity
@Table(name = "option_locking", schema = "", catalog = "ecare")
public class OptionLockingEntity
{
    private int id;
    private int selectedOptionId;
    private int lockedOptionId;
    private OptionsEntity optionsBySelectedOptionId;
    private OptionsEntity optionsByLockedOptionId;

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
    @Column(name = "selected_option_id", nullable = false, insertable = true, updatable = true)
    public int getSelectedOptionId()
    {
        return selectedOptionId;
    }

    public void setSelectedOptionId(int selectedOptionId)
    {
        this.selectedOptionId = selectedOptionId;
    }

    @Basic
    @Column(name = "locked_option_id", nullable = false, insertable = true, updatable = true)
    public int getLockedOptionId()
    {
        return lockedOptionId;
    }

    public void setLockedOptionId(int lockedOptionId)
    {
        this.lockedOptionId = lockedOptionId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OptionLockingEntity that = (OptionLockingEntity) o;

        if (id != that.id) return false;
        if (lockedOptionId != that.lockedOptionId) return false;
        if (selectedOptionId != that.selectedOptionId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + selectedOptionId;
        result = 31 * result + lockedOptionId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "selected_option_id", referencedColumnName = "option_id", nullable = false)
    public OptionsEntity getOptionsBySelectedOptionId()
    {
        return optionsBySelectedOptionId;
    }

    public void setOptionsBySelectedOptionId(OptionsEntity optionsBySelectedOptionId)
    {
        this.optionsBySelectedOptionId = optionsBySelectedOptionId;
    }

    @ManyToOne
    @JoinColumn(name = "locked_option_id", referencedColumnName = "option_id", nullable = false)
    public OptionsEntity getOptionsByLockedOptionId()
    {
        return optionsByLockedOptionId;
    }

    public void setOptionsByLockedOptionId(OptionsEntity optionsByLockedOptionId)
    {
        this.optionsByLockedOptionId = optionsByLockedOptionId;
    }
}
