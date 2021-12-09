package com.dht.service;

import com.dht.pojo.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountsService extends UserDetailsService {
    List<Account> getAllAccount();
    Account getAccountById(String id);
    Account getAccountByUsername(String username);
    boolean deleteAccount(String accountId);
    boolean addAccount(Account account);
    boolean updateAccount(Account account);
    boolean isAdminAccount(String doctorId);
}
