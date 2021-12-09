package com.dht.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "bills")
public class Bills implements Serializable {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "patientid")
    private Patient patientid;
    private Date date;
    private int total;

    @Transient
    private String ccid;
    @Transient
    private String str;

    @OneToMany(mappedBy = "bill")
    private Set<BillDetails> billDetail;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPatientid() {
        return patientid;
    }

    public void setPatientid(Patient patientid) {
        this.patientid = patientid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Set<BillDetails> getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(Set<BillDetails> billDetail) {
        this.billDetail = billDetail;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
