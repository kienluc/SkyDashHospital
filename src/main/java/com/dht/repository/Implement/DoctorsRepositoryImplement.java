package com.dht.repository.Implement;

import com.dht.pojo.Doctor;
import com.dht.repository.IDoctorsRepository;
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
public class DoctorsRepositoryImplement implements IDoctorsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    private Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }

    @Override
    @Transactional
    public List<Doctor> getAllDoctor() {
        Query q = currentSession().createQuery("From Doctor order by name asc ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public Doctor getDoctorById(String id) {
        return currentSession().get(Doctor.class, id);
    }

    @Override
    @Transactional
    public boolean deleteDoctor(String doctorId) {
        try {
            Doctor p = currentSession().get(Doctor.class, doctorId);
            currentSession().delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addDoctor(Doctor doctor) {
        try {
            doctor.setId(UUID.randomUUID().toString());;
            currentSession().save(doctor);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateDoctor(Doctor doctor) {
        try {
//            if(doctor.getId() != null)
                currentSession().update(doctor);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
