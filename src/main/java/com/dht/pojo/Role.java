package com.dht.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="role")
public class Role implements Serializable {
    @Id
    private int id;
    private String role;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<Account> account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
