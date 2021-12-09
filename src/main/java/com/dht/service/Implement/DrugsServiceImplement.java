package com.dht.service.Implement;

import com.dht.pojo.Drugs;
import com.dht.repository.IDrugsRepository;
import com.dht.service.IDrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugsServiceImplement implements IDrugsService {

    @Autowired
    private IDrugsRepository drugsRepository;

    @Override
    public List<Drugs> getAllDrugs() {
        return this.drugsRepository.getAllDrugs();
    }

    @Override
    public Drugs getDrugsById(int id) {
        return this.drugsRepository.getDrugsById(id);
    }

    @Override
    public boolean deleteDrugs(int drugId) {
        return this.drugsRepository.deleteDrugs(drugId);
    }

    @Override
    public boolean addDrugs(Drugs drug) {
        return this.drugsRepository.addDrugs(drug);
    }

    @Override
    public boolean updateDrugs(Drugs drug) {
        return this.drugsRepository.updateDrugs(drug);
    }
}
