package com.dht.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shiftdetail")
public class ShiftDetail implements Serializable {

    @EmbeddedId
    private ShiftDetailKey id;

    @ManyToOne
    @MapsId(value = "doctorid")
    @JoinColumn(name = "doctorid" )
    private Doctor doctor;

    @Id
    private int dayofweek;

    @ManyToOne
    @MapsId(value = "shiftid")
    private Shift shiftid;



    public ShiftDetailKey getId() {
        return id;
    }

    public void setId(ShiftDetailKey id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(int dayofweek) {
        this.dayofweek = dayofweek;
    }

    public Shift getShiftid() {
        return shiftid;
    }

    public void setShiftid(Shift shiftid) {
        this.shiftid = shiftid;
    }
}
