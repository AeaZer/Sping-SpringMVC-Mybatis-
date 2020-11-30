package com.study.TestSpring;

import com.study.dao.AccountDao;
import com.study.domain.Account;
import com.study.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {


    @org.junit.Test
    public void Test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();
    }

    @org.junit.Test
    public void TestMybatis() throws IOException {
        /**
         * 加载sqlMapConfiguration配置文件
         */
        InputStream in = Resources.getResourceAsStream("SqlMapConfiguration.xml");
        /**
         * 创建sqlSessionFactory的对象
         */
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        /**
         * create sqlSession Object
         */
        SqlSession sqlSession = factory.openSession();
        /**
         * get Agency of accountDao object
         */
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.findAll();
        for (Account ac: accounts){
            System.out.println(ac);
        }
        sqlSession.close();
        in.close();
    }
}
