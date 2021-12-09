package com.dht.repository;

import com.dht.pojo.Patient;

import java.util.List;

public interface IPatientsRepository {
    List<Patient> getAllPatient();
    Patient getPatientById(String id);
    boolean deletePatient(String patientId);
    boolean addPatient(Patient patient);
    boolean updatePatient(Patient patient);
    Patient getPatientByCCID(String ccid);
}
