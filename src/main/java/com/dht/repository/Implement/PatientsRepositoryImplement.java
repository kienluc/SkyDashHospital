package com.dht.repository.Implement;

import com.dht.pojo.Patient;
import com.dht.repository.IPatientsRepository;
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
public class PatientsRepositoryImplement implements IPatientsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    private Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }

    @Override
    @Transactional
    public List<Patient> getAllPatient() {
        Query q = currentSession().createQuery("From Patient ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public Patient getPatientById(String id) {
        return currentSession().get(Patient.class, id);
    }

    @Override
    @Transactional
    public boolean deletePatient(String patientId) {
        try {
            Patient p = currentSession().get(Patient.class, patientId);
            currentSession().delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public boolean updatePatient(Patient patient) {
        try {
                if(patient.getId() != null)
                    currentSession().update(patient);
                return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Patient getPatientByCCID(String ccid) {
        return currentSession().get(Patient.class, ccid);
    }

    @Override
    @Transactional
    public boolean addPatient(Patient patient) {
        try {
                patient.setId(UUID.randomUUID().toString());
                currentSession().save(patient);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
