package com.dht.service;

import com.dht.pojo.Appointment;

import java.util.List;

public interface IAppointmentsService {
    List<Appointment> getAllAppointment();
    Appointment getAppointmentById(String id);
    boolean deleteAppointment(int appoinmentId);
    boolean addAppointment(Appointment appoinment);
    boolean updateAppointment(Appointment appoinment);
}
