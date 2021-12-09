package com.dht.service;

import com.dht.pojo.Shift;

import java.util.List;

public interface IShiftsService {
    List<Shift> getAllShift();
    Shift getShiftById(int id);
    boolean deleteShift(int shiftId);
    boolean addShift(Shift shift);
    boolean updateShift(Shift shift);
}
