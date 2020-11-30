package com.study.service;

import com.study.domain.Account;

import java.util.List;

public interface AccountService {

    /**
     * 查询所有account账户信息
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    public void save(Account account);
}
