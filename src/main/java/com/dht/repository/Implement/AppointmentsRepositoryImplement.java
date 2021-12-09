package com.dht.repository.Implement;

import com.dht.pojo.Appointment;
import com.dht.repository.IAppointmentsRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class AppointmentsRepositoryImplement implements IAppointmentsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    private Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }

    @Override
    @Transactional
    public List<Appointment> getAllAppointment() {
        Query q = currentSession().createQuery("From Appointment ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public Appointment getAppointmentById(String id) {
        return currentSession().get(Appointment.class, id);
    }

    @Override
    @Transactional
    public boolean deleteAppointment(int appoinmentId) {
        try {
            Appointment p = currentSession().get(Appointment.class, appoinmentId);
            currentSession().delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addAppointment(Appointment appoinment) {
        try {
            currentSession().save(appoinment);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateAppointment(Appointment appoinment) {
        try {
            if(appoinment.getId() != 0)
                currentSession().update(appoinment);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
