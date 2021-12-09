package com.dht.service;

import com.dht.pojo.BillDetails;

import java.util.List;

public interface IBillDetailsService {
    List<BillDetails> getAllBillDetails();
    BillDetails getBillDetailsById(String id);
    boolean deleteBillDetails(String billdetailsId);
    boolean addBillDetails(BillDetails billdetails);
    boolean updateBillDetails(BillDetails billdetails);
}
