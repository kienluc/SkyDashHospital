package com.dht.repository.Implement;

import com.dht.pojo.Account;
import com.dht.repository.IAccountsRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AccountsRepositoryImplement implements IAccountsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;


    private Session currentSession() {
        return sessionFactory.getObject().getCurrentSession();
    }


    @Override
    @Transactional
    public List<Account> getAllAccount() {
        Query q = currentSession().createQuery("From Account order by username asc ");

        return q.getResultList();
    }

    @Override
    @Transactional
    public Account getAccountById(String id) {
        return currentSession().get(Account.class, id);
    }

    @Override
    public Account getAccountByUsername(String s) {
        Query q = currentSession().createQuery("From Account where username =:s")
                .setParameter("s", s);
        return (Account) q.getResultList().get(0);
    }

    @Override
    @Transactional
    public boolean deleteAccount(String accountId) {
        try {
            Account p = currentSession().get(Account.class, accountId);
            currentSession().delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addAccount(Account account) {
        try {
            currentSession().save(account);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateAccount(Account account) {
        try {
            currentSession().update(account);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
