package com.dht.repository.Implement;

import com.dht.pojo.Role;
import com.dht.pojo.ShiftDetail;
import com.dht.repository.IShiftDetailsRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ShiftDetailsRepositoryImplement implements IShiftDetailsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    private Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }

    @Override
    @Transactional
    public List<ShiftDetail> getAllShiftDetail() {
        Query q = currentSession().createQuery("From ShiftDetail ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public ShiftDetail getShiftDetailById(String id) {
        return currentSession().get(ShiftDetail.class, id);
    }

    @Override
    @Transactional
    public boolean deleteShiftDetail(String shiftdetailId) {
        try {
            ShiftDetail p = currentSession().get(ShiftDetail.class, shiftdetailId);
            currentSession().delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addShiftDetail(ShiftDetail shiftdetail) {
        try {
            currentSession().save(shiftdetail);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateShiftDetail(ShiftDetail shiftdetail) {
        try {
            if(shiftdetail.getId() != null)
                currentSession().update(shiftdetail);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
