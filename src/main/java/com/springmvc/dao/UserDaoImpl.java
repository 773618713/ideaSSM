package com.springmvc.dao;

import com.springmvc.entity.ScoreUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class UserDaoImpl {

    @Autowired
    private ScoreUsersMapper mapper;

    public void insert() {
        ScoreUsers scoreUser = new ScoreUsers();
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
