package com.study.service.Impl;

import com.study.dao.AccountDao;
import com.study.domain.Account;
import com.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层查询所有的信息");
        return accountDao.findAll();
    }

    @Override
    public void save(Account account) {
        System.out.println("业务层保存又有的方法");
        accountDao.save(account);
    }
}
