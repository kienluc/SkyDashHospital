package com.dht.repository;

import com.dht.pojo.ShiftDetail;

import java.util.List;

public interface IShiftDetailsRepository {
    List<ShiftDetail> getAllShiftDetail();
    ShiftDetail getShiftDetailById(String id);
    boolean deleteShiftDetail(String shiftdetailId);
    boolean addShiftDetail(ShiftDetail shiftdetail);
    boolean updateShiftDetail(ShiftDetail shiftdetail);
}
