package com.dht.pojo;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BillDetailKey implements Serializable {
    private String billId;
    private int drugId;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }
}
