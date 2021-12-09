package com.dht.service;

import com.dht.pojo.Drugs;

import java.util.List;

public interface IDrugsService {
    List<Drugs> getAllDrugs();
    Drugs getDrugsById(int id);
    boolean deleteDrugs(int drugId);
    boolean addDrugs(Drugs drug);
    boolean updateDrugs(Drugs drug);
}
