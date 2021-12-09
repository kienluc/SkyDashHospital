package com.dht.repository.Implement;

import com.dht.pojo.Role;
import com.dht.repository.IRolesRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RolesImplementRepository implements IRolesRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    private Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }

    @Override
    @Transactional
    public List<Role> getAllRole() {
        Query q = currentSession().createQuery("From Role ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public Role getRoleById(String id) {
        return currentSession().get(Role.class, id);
    }

    @Override
    @Transactional
    public boolean deleteRole(String roleId) {
        try {
            Role p = currentSession().get(Role.class, roleId);
            currentSession().delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addRole(Role role) {
        try {
            currentSession().save(role);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateRole(Role role) {
        try {
            if(role.getId() != 0)
                currentSession().update(role);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
