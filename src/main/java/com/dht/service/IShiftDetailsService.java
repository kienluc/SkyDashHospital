package com.dht.service;

import com.dht.pojo.ShiftDetail;

import java.util.List;

public interface IShiftDetailsService {
    List<ShiftDetail> getAllShiftDetail();
    ShiftDetail getShiftDetailById(String id);
    boolean deleteShiftDetail(String shiftdetailId);
    boolean addShiftDetail(ShiftDetail shiftdetail);
    boolean updateShiftDetail(ShiftDetail shiftdetail);
}
