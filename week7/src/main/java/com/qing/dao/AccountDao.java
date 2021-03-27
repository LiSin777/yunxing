package com.qing.dao;



import com.qing.pojo.Account;

import java.util.List;


public interface AccountDao {

    List<Account> findAll();

    Integer deleteByPrimaryKey(String id);

    Integer insert(Account account);

    Account selectByPrimaryKey(String id);

    Integer updateByPrimaryKey(Account account);
}
