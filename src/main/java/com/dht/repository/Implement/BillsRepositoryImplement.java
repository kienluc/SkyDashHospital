package com.dht.repository.Implement;

import com.dht.pojo.Bills;
import com.dht.pojo.Doctor;
import com.dht.repository.IBillsRepository;
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
public class BillsRepositoryImplement implements IBillsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    private Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }

    @Override
    @Transactional
    public List<Bills> getAllBills() {
        Query q = currentSession().createQuery("From Bills ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public Bills getBillsById(String id) {
        return currentSession().get(Bills.class, id);
    }

    @Override
    @Transactional
    public boolean deleteBills(String billId) {
        try {
            Bills p = currentSession().get(Bills.class, billId);
            currentSession().delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addBills(Bills bill) {
        try {
            bill.setId(UUID.randomUUID().toString());;
            currentSession().save(bill);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateBills(Bills bill) {
        try {
            if(bill.getId() != null)
                currentSession().update(bill);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
