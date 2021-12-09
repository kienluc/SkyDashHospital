package com.dht.repository.Implement;

import com.dht.pojo.BillDetails;
import com.dht.pojo.Bills;
import com.dht.pojo.Doctor;
import com.dht.repository.IBillDetailsRepository;
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
public class BillDetailsRepositoryImplement implements IBillDetailsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    private Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }

    @Override
    @Transactional
    public List<BillDetails> getAllBillDetails() {
        Query q = currentSession().createQuery("From BillDetails ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public BillDetails getBillDetailsById(String id) {
        return currentSession().get(BillDetails.class, id);
    }

    @Override
    @Transactional
    public boolean deleteBillDetails(String billdetailsId) {
        try {
            BillDetails p = currentSession().get(BillDetails.class, billdetailsId);
            currentSession().delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addBillDetails(BillDetails billdetails) {
        try {
            currentSession().save(billdetails);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateBillDetails(BillDetails billdetails) {
        try {
            if(billdetails.getId() != null)
                currentSession().update(billdetails);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
