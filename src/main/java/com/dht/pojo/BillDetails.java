package com.dht.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "billdetails")
public class BillDetails implements Serializable {
    @EmbeddedId
    private BillDetailKey id;

    @ManyToOne
    @MapsId("drugId")
    @JoinColumn(name = "drugid")
    private Drugs drug;

    @ManyToOne
    @MapsId("billId")
    @JoinColumn(name = "billid")
    private Bills bill;

    private int amount;

    public Drugs getDrug() {
        return drug;
    }

    public void setDrug(Drugs drug) {
        this.drug = drug;
    }

    public Bills getBill() {
        return bill;
    }

    public void setBill(Bills bill) {
        this.bill = bill;
    }

    public BillDetailKey getId() {
        return id;
    }

    public void setId(BillDetailKey id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
