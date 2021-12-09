package com.dht.repository;

import com.dht.pojo.Doctor;

import java.util.List;

public interface IDoctorsRepository {
    List<Doctor> getAllDoctor();
    Doctor getDoctorById(String id);
    boolean deleteDoctor(String doctorId);
    boolean addDoctor(Doctor doctor);
    boolean updateDoctor(Doctor doctor);
}
