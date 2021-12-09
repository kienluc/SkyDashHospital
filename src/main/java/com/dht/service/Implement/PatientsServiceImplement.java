package com.dht.service.Implement;

import com.dht.pojo.Patient;
import com.dht.repository.IPatientsRepository;
import com.dht.repository.Implement.PatientsRepositoryImplement;
import com.dht.service.IPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientsServiceImplement implements IPatientsService {

    @Autowired
    private IPatientsRepository patientsRepository;

    @Override
    public List<Patient> getAllPatient() {
        return this.patientsRepository.getAllPatient();
    }

    @Override
    public Patient getPatientById(String id) {
        return this.patientsRepository.getPatientById(id);
    }

    @Override
    public boolean deletePatient(String patientId) {
        return this.patientsRepository.deletePatient(patientId);
    }

    @Override
    public boolean addPatient(Patient patient) {
        return this.patientsRepository.addPatient(patient);
    }

    @Override
    public boolean updatePatient(Patient patient) {
        return this.patientsRepository.updatePatient(patient);
    }

    @Override
    public Patient getPatientByCCID(String ccid) {
        return this.patientsRepository.getPatientByCCID(ccid);
    }
}
