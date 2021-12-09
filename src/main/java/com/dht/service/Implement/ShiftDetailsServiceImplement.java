package com.dht.service.Implement;

import com.dht.pojo.ShiftDetail;
import com.dht.repository.IShiftDetailsRepository;
import com.dht.service.IShiftDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftDetailsServiceImplement implements IShiftDetailsService {

    @Autowired
    private IShiftDetailsRepository shiftDetailsRepository;

    @Override
    public List<ShiftDetail> getAllShiftDetail() {
        return this.shiftDetailsRepository.getAllShiftDetail();
    }

    @Override
    public ShiftDetail getShiftDetailById(String id) {
        return this.shiftDetailsRepository.getShiftDetailById(id);
    }

    @Override
    public boolean deleteShiftDetail(String shiftdetailId) {
        return this.shiftDetailsRepository.deleteShiftDetail(shiftdetailId);
    }

    @Override
    public boolean addShiftDetail(ShiftDetail shiftdetail) {
        return this.shiftDetailsRepository.addShiftDetail(shiftdetail);
    }

    @Override
    public boolean updateShiftDetail(ShiftDetail shiftdetail) {
        return this.shiftDetailsRepository.updateShiftDetail(shiftdetail);
    }
}
