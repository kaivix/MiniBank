package com.kaivix.mini_bank.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String Name;
    private String LastName;
    private String Surname;
    private String Password;
    private Date DOB;
    private Long Series_of_passport;
    private Long Number_of_passport;

    public Users() {
    }

    public Users(Long id, String name, String lastName, String surname, String password, Date DOB, Long series_of_passport, Long number_of_passport) {
        this.id = id;
        Name = name;
        LastName = lastName;
        Surname = surname;
        Password = password;
        this.DOB = DOB;
        Series_of_passport = series_of_passport;
        Number_of_passport = number_of_passport;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Long getSeries_of_passport() {
        return Series_of_passport;
    }

    public void setSeries_of_passport(Long series_of_passport) {
        Series_of_passport = series_of_passport;
    }

    public Long getNumber_of_passport() {
        return Number_of_passport;
    }

    public void setNumber_of_passport(Long number_of_passport) {
        Number_of_passport = number_of_passport;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
