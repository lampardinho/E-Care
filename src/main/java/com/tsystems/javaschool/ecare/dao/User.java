package com.tsystems.javaschool.ecare.dao;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Kolia on 27.06.2015.
 */
@Entity
@Table(name = "users", schema = "", catalog = "ecare")
public class User
{
    @Id
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true)
    private int userId;

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    private String name;

    @Basic
    @Column(name = "surname", nullable = false, insertable = true, updatable = true, length = 50)
    private String surname;

    @Basic
    @Column(name = "birth_date", nullable = false, insertable = true, updatable = true)
    private Date birthDate;

    @Basic
    @Column(name = "passport_data", nullable = false, insertable = true, updatable = true, length = 50)
    private String passportData;

    @Basic
    @Column(name = "address", nullable = false, insertable = true, updatable = true, length = 50)
    private String address;

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 50)
    private String email;

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 50)
    private String password;

    @Basic
    @Column(name = "is_admin", nullable = false, insertable = true, updatable = true)
    private byte isAdmin;

    @ManyToMany
    @JoinTable(name="contract_locking",
            joinColumns=@JoinColumn(name="locker_id"),
            inverseJoinColumns=@JoinColumn(name="contract_id"))
    private Collection<Contract> lockedContracts;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }


    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }


    public String getPassportData()
    {
        return passportData;
    }

    public void setPassportData(String passportData)
    {
        this.passportData = passportData;
    }


    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }


    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


    public byte getIsAdmin()
    {
        return isAdmin;
    }

    public void setIsAdmin(byte isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    public Collection<Contract> getLockedContracts()
    {
        return lockedContracts;
    }

    public void setLockedContracts(Collection<Contract> lockedContracts)
    {
        this.lockedContracts = lockedContracts;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (isAdmin != that.isAdmin) return false;
        if (userId != that.userId) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
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
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) isAdmin;
        return result;
    }



}
