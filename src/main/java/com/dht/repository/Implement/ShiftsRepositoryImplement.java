package com.dht.repository.Implement;

import com.dht.pojo.Role;
import com.dht.pojo.Shift;
import com.dht.repository.IShiftsRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ShiftsRepositoryImplement implements IShiftsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    private Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }

    @Override
    @Transactional
    public List<Shift> getAllShift() {
        Query q = currentSession().createQuery("From Shift ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public Shift getShiftById(int id) {
        return currentSession().get(Shift.class, id);
    }

    @Override
    @Transactional
    public boolean deleteShift(int shiftId) {
        try {
            Shift p = currentSession().get(Shift.class, shiftId);
            currentSession().delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addShift(Shift shift) {
        try {
            currentSession().save(shift);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateShift(Shift shift) {
        try {
            if(shift.getId() != 0)
                currentSession().update(shift);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
