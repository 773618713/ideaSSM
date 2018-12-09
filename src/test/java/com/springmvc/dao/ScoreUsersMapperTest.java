package com.springmvc.dao;

import com.springmvc.entity.ScoreUsers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Date;

import static org.junit.Assert.*;

public class ScoreUsersMapperTest {
    private ApplicationContext applicationContext;

    @Autowired
    private ScoreUsersMapper mapper;

    @Before
    public void setUp() throws Exception {
        // 加载spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        // 导入需要测试的
        mapper = applicationContext.getBean(ScoreUsersMapper.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        ScoreUsers scoreUser = new ScoreUsers();
       /* message.setCommand("吃饭");
        message.setContent("睡觉");
        message.setDescription("打豆豆");*/
        scoreUser.setUsername("test");
        scoreUser.setUsercaption("1");
        scoreUser.setServerVer("1");
        scoreUser.setUsertype("1");
        scoreUser.setLoginDate(new Date());
        scoreUser.setCreateDate(new Date());
        scoreUser.setOpen("1");
        scoreUser.setUserpwd("1");
        scoreUser.setIscurrent("1");
        scoreUser.setAccountcode("1");
        scoreUser.setFilepath("1");

        int result = mapper.insert(scoreUser);
        System.out.println(result);
        assert (result == 1);
    }
}