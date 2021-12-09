package com.dht.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ShiftDetailKey implements Serializable {
    private String doctorid;

    private int shiftid;

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public int getShiftid() {
        return shiftid;
    }

    public void setShiftid(int shiftid) {
        this.shiftid = shiftid;
    }
}
