package com.study.controller;

import com.study.domain.Account;
import com.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web层
 * @author Administrator
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String finAll(Model model){
        System.out.println("表现层：查询所有账户");
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts",accounts);
        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.save(account);
        System.out.println(request.getContextPath());
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }

}
