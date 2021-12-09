package com.dht.service.Implement;

import com.dht.pojo.BillDetails;
import com.dht.repository.IBillDetailsRepository;
import com.dht.service.IBillDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailsServiceImplement implements IBillDetailsService {

    @Autowired
    private IBillDetailsRepository billDetailsRepository;

    @Override
    public List<BillDetails> getAllBillDetails() {
        return this.billDetailsRepository.getAllBillDetails();
    }

    @Override
    public BillDetails getBillDetailsById(String id) {
        return this.billDetailsRepository.getBillDetailsById(id);
    }

    @Override
    public boolean deleteBillDetails(String billdetailsId) {
        return this.billDetailsRepository.deleteBillDetails(billdetailsId);
    }

    @Override
    public boolean addBillDetails(BillDetails billdetails) {
        return this.billDetailsRepository.addBillDetails(billdetails);
    }

    @Override
    public boolean updateBillDetails(BillDetails billdetails) {
        return this.billDetailsRepository.updateBillDetails(billdetails);
    }
}
