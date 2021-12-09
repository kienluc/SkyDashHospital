package com.dht.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "departmentid", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Doctor> doctor;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Appointment> appointments;

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

    public List<Doctor> getDoctor() {
        return doctor;
    }

    public void setDoctor(List<Doctor> doctor) {
        this.doctor = doctor;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
