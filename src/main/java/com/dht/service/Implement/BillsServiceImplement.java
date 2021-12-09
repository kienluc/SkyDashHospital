package com.dht.service.Implement;

import com.dht.pojo.Bills;
import com.dht.repository.IBillsRepository;
import com.dht.service.IBillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillsServiceImplement implements IBillsService {

    @Autowired
    private IBillsRepository billsRepository;

    @Override
    public List<Bills> getAllBills() {
        return this.billsRepository.getAllBills();
    }

    @Override
    public Bills getBillsById(String id) {
        return this.billsRepository.getBillsById(id);
    }

    @Override
    public boolean deleteBills(String billId) {
        return this.billsRepository.deleteBills(billId);
    }

    @Override
    public boolean addBills(Bills bill) {
        return this.billsRepository.addBills(bill);
    }

    @Override
    public boolean updateBills(Bills bill) {
        return this.billsRepository.updateBills(bill);
    }
}
