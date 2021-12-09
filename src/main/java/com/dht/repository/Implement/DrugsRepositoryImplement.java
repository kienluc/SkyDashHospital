package com.dht.repository.Implement;

import com.dht.pojo.Drugs;
import com.dht.repository.IDrugsRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;


@Repository
public class DrugsRepositoryImplement implements IDrugsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    private Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }

    @Override
    @Transactional
    public List<Drugs> getAllDrugs() {
        Query q = currentSession().createQuery("From Drugs ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public Drugs getDrugsById(int id) {
        return currentSession().get(Drugs.class, id);
    }

    @Override
    @Transactional
    public boolean deleteDrugs(int drugId) {
        try {
            Drugs p = currentSession().get(Drugs.class, drugId);
            currentSession().delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addDrugs(Drugs drug) {
        try {
            currentSession().save(drug);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateDrugs(Drugs drug) {
        try {
            if(drug.getId() != 0)
                currentSession().update(drug);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
