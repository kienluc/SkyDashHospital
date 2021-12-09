package com.dht.pojo;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "account")
public class Account implements Serializable {
    @Id
    private String id;
    @Size(min = 3, max = 20, message = "Tu 3 den 20 ky tu")
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role role;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Doctor doctor;

    @Transient
    private String confirmPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}