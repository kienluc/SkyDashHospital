package com.dht.repository.Implement;

import com.dht.pojo.Department;
import com.dht.pojo.Patient;
import com.dht.repository.IDepartmentsRepository;
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
public class DepartmentsRepositoryImplement implements IDepartmentsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    protected Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }

    @Override
    @Transactional
    public List<Department> getAllDepartments() {
        Query q = currentSession().createQuery("From Department ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public Department getDepartmentById(String id) {
        return currentSession().get(Department.class, id);
    }

    @Override
    @Transactional
    public boolean deleteDepartment(String departmentId) {
        try {
            Department d = currentSession().get(Department.class, departmentId);
            currentSession().delete(d);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public boolean addDepartment(Department department) {
        try {
            department.setId(UUID.randomUUID().toString());
            currentSession().save(department);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateDepartment(Department department) {
        try {
            if(department.getId() != null)
                currentSession().update(department);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
