package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Kolia on 27.06.2015.
 */
@Entity
@Table(name = "users", schema = "", catalog = "ecare")
public class UsersEntity
{
    private int userId;
    private String name;
    private String surname;
    private Date birthDate;
    private String passportData;
    private String adress;
    private String email;
    private String password;
    private byte isAdmin;
    private Collection<ContractLockingEntity> contractLockingsByUserId;
    private Collection<ContractsEntity> contractsesByUserId;

    @Id
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
    @Column(name = "surname", nullable = false, insertable = true, updatable = true, length = 50)
    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    @Basic
    @Column(name = "birth_date", nullable = false, insertable = true, updatable = true)
    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "passport_data", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPassportData()
    {
        return passportData;
    }

    public void setPassportData(String passportData)
    {
        this.passportData = passportData;
    }

    @Basic
    @Column(name = "adress", nullable = false, insertable = true, updatable = true, length = 50)
    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 50)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Basic
    @Column(name = "is_admin", nullable = false, insertable = true, updatable = true)
    public byte getIsAdmin()
    {
        return isAdmin;
    }

    public void setIsAdmin(byte isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (isAdmin != that.isAdmin) return false;
        if (userId != that.userId) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (passportData != null ? !passportData.equals(that.passportData) : that.passportData != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (passportData != null ? passportData.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) isAdmin;
        return result;
    }

    @OneToMany(mappedBy = "usersByLockerId")
    public Collection<ContractLockingEntity> getContractLockingsByUserId()
    {
        return contractLockingsByUserId;
    }

    public void setContractLockingsByUserId(Collection<ContractLockingEntity> contractLockingsByUserId)
    {
        this.contractLockingsByUserId = contractLockingsByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<ContractsEntity> getContractsesByUserId()
    {
        return contractsesByUserId;
    }

    public void setContractsesByUserId(Collection<ContractsEntity> contractsesByUserId)
    {
        this.contractsesByUserId = contractsesByUserId;
    }
}
