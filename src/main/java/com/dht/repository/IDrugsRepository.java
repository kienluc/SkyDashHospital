package com.dht.repository;

import com.dht.pojo.Drugs;

import java.util.List;

public interface IDrugsRepository {
    List<Drugs> getAllDrugs();
    Drugs getDrugsById(int id);
    boolean deleteDrugs(int drugId);
    boolean addDrugs(Drugs drug);
    boolean updateDrugs(Drugs drug);
}
