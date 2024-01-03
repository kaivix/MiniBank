package com.kaivix.mini_bank.Models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String LastName;
    private String Surname;
    private String Password;
    private Long pnum;
    private Date DOB;
    private Long Series_of_passport;
    private Long Number_of_passport;
    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public Users(Long id, String username, String lastName, String surname, String password, Long pnum, Date DOB, Long series_of_passport, Long number_of_passport, Collection<Role> roles) {
        this.id = id;
        this.username = username;
        LastName = lastName;
        Surname = surname;
        Password = password;
        this.pnum = pnum;
        this.DOB = DOB;
        Series_of_passport = series_of_passport;
        Number_of_passport = number_of_passport;
        this.roles = roles;
    }

    public Users() {

    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Long getPnum() {
        return pnum;
    }

    public void setPnum(Long pnum) {
        this.pnum = pnum;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        username = name;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
