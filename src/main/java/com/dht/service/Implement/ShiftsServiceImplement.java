package com.dht.service.Implement;

import com.dht.pojo.Shift;
import com.dht.repository.IShiftsRepository;
import com.dht.service.IShiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftsServiceImplement implements IShiftsService {
    @Autowired
    private IShiftsRepository shiftsRepository;

    @Override
    public List<Shift> getAllShift() {
        return this.shiftsRepository.getAllShift();
    }

    @Override
    public Shift getShiftById(int id) {
        return this.shiftsRepository.getShiftById(id);
    }

    @Override
    public boolean deleteShift(int shiftId) {
        return this.shiftsRepository.deleteShift(shiftId);
    }

    @Override
    public boolean addShift(Shift shift) {
        return this.shiftsRepository.addShift(shift);
    }

    @Override
    public boolean updateShift(Shift shift) {
        return this.shiftsRepository.updateShift(shift);
    }
}
