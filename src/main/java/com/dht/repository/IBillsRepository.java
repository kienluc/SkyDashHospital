package com.dht.repository;

import com.dht.pojo.Bills;
import com.dht.pojo.Doctor;

import java.util.List;

public interface IBillsRepository {
    List<Bills> getAllBills();
    Bills getBillsById(String id);
    boolean deleteBills(String billId);
    boolean addBills(Bills bill);
    boolean updateBills(Bills bill);
}
