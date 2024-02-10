package com.kaivix.mini_bank.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String username;
    private String lastname;
    @Column(nullable = false)
    @Size(min = 4, max = 4 )
    private String pincode;
    private String email;
    private Date dob;
    private String ProfileImageUrl;
    private String[] roles;

    private String[] authorities;
    private boolean isNotLocked;

    public User() {
    }

    public User(Long id, String username, String lastname, String pincode, String email, Date dob, String profileImageUrl, String[] roles, String[] authorities, boolean isNotLocked) {
        this.id = id;
        this.isNotLocked = isNotLocked;
        this.username = username;
        this.lastname = lastname;
        this.pincode = pincode;
        this.email = email;
        this.dob = dob;
        ProfileImageUrl = profileImageUrl;
        this.roles = roles;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public boolean isNotLocked() {
        return isNotLocked;
    }

    public void setNotLocked(boolean notLocked) {
        isNotLocked = notLocked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getProfileImageUrl() {
        return ProfileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        ProfileImageUrl = profileImageUrl;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }
}
