package com.mkx.soa.dao;

import com.mkx.soa.entity.Administrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorDaoTest {
    @Autowired
    private AdministratorDao administratorDao;

    @Test
    public void administratorTest() {
        Administrator administrator=new Administrator();
        administrator.setName("test+");
        administrator.setBriefInfo("Hello World!");
        administrator.setUrl("www.massizhi.com");
        administrator.setPassword("test");//不能为空
        administrator.setId(2);

//        administratorDao.updateAdministrator(administrator);

        System.out.println(administratorDao.getPasswordByName("test"));
        System.out.println(administratorDao.getAdministratorById(1).getBriefInfo());
        System.out.println(administratorDao.getAdministratorByName("test").getUrl());
    }
}
