package com.dht.service;

import com.dht.pojo.Doctor;

import java.util.List;

public interface IDoctorsService {
    List<Doctor> getAllDoctor();
    Doctor getDoctorById(String id);
    boolean deleteDoctor(String doctorId);
    boolean addDoctor(Doctor doctor);
    boolean updateDoctor(Doctor doctor);
    boolean isAdmin(String doctorId);
}
