package com.dht.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "shift")
public class Shift implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int begin;
    private int end;

    @OneToMany(mappedBy = "shiftid")
    private List<ShiftDetail> shiftDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<ShiftDetail> getShiftDetail() {
        return shiftDetail;
    }

    public void setShiftDetail(List<ShiftDetail> shiftDetail) {
        this.shiftDetail = shiftDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
