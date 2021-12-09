package com.dht.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date date;
    private String email;
    private String phone;
    private Integer ccid;

    @ManyToOne
    @JoinColumn(name="departmentid")
    private Department department;
//    @ManyToOne
//    @JoinColumn(name = "patientid")
//    private Patient patientid;
//
//    @ManyToOne
//    @JoinColumn(name = "doctorid")
//    private Doctor doctorid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Patient getPatientid() {
//        return patientid;
//    }
//
//    public void setPatientid(Patient patientid) {
//        this.patientid = patientid;
//    }
//
//    public Doctor getDoctorid() {
//        return doctorid;
//    }
//
//    public void setDoctorid(Doctor doctorid) {
//        this.doctorid = doctorid;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
