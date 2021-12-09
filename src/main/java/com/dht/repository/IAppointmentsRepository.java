package com.dht.repository;

import com.dht.pojo.Appointment;

import java.util.List;

public interface IAppointmentsRepository {
    List<Appointment> getAllAppointment();
    Appointment getAppointmentById(String id);
    boolean deleteAppointment(int appoinmentId);
    boolean addAppointment(Appointment appoinment);
    boolean updateAppointment(Appointment appoinment);
}
