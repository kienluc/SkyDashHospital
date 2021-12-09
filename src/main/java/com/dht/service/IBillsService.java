package com.dht.service;

import com.dht.pojo.Bills;

import java.util.List;

public interface IBillsService {
    List<Bills> getAllBills();
    Bills getBillsById(String id);
    boolean deleteBills(String billId);
    boolean addBills(Bills bill);
    boolean updateBills(Bills bill);
}
