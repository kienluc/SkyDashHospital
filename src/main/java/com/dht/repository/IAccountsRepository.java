package com.dht.repository;

import com.dht.pojo.Account;

import java.util.List;

public interface IAccountsRepository {
    List<Account> getAllAccount();
    Account getAccountById(String id);
    Account getAccountByUsername(String username);
    boolean deleteAccount(String accountId);
    boolean addAccount(Account account);
    boolean updateAccount(Account account);
}
