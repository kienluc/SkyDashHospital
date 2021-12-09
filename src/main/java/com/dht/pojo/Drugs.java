package com.dht.pojo;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "drugs")
public class Drugs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal price;
    private String unit;
    private String decription;

    @OneToMany(mappedBy = "drug")
    private Set<BillDetails> billDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BillDetails> getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(Set<BillDetails> billDetail) {
        this.billDetail = billDetail;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
