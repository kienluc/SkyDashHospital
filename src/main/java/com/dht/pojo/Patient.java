package com.dht.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer ccid;
    private Date dateOfBirth;
    private String gender;
    private String disease;
    private String email;
    private String phone;
    private String address;


    @OneToMany(mappedBy = "patientid", fetch=FetchType.LAZY)
    private List<Bills> bill;

//    @OneToMany(mappedBy = "patientid", fetch = FetchType.LAZY)
//    private List<Appointment> appointment;

//    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Account account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Bills> getBill() {
        return bill;
    }

    public void setBill(List<Bills> bill) {
        this.bill = bill;
    }

//    public List<Appointment> getAppointment() {
//        return appointment;
//    }
//
//    public void setAppointment(List<Appointment> appointment) {
//        this.appointment = appointment;
//    }

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    //    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
}
