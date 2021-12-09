package com.dht.service.Implement;

import com.dht.pojo.Appointment;
import com.dht.repository.IAppointmentsRepository;
import com.dht.service.IAppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsServiceImplement implements IAppointmentsService {

    @Autowired
    private IAppointmentsRepository appointmentsRepository;

    @Override
    public List<Appointment> getAllAppointment() {
        return this.appointmentsRepository.getAllAppointment();
    }

    @Override
    public Appointment getAppointmentById(String id) {
        return this.appointmentsRepository.getAppointmentById(id);
    }

    @Override
    public boolean deleteAppointment(int appoinmentId) {
        return this.appointmentsRepository.deleteAppointment(appoinmentId);
    }

    @Override
    public boolean addAppointment(Appointment appoinment) {
        return this.appointmentsRepository.addAppointment(appoinment);
    }

    @Override
    public boolean updateAppointment(Appointment appoinment) {
        return this.appointmentsRepository.updateAppointment(appoinment);
    }
}
