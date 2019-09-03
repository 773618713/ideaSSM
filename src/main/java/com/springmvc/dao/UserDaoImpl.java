package com.springmvc.dao;

import com.springmvc.entity.ScoreUsers;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public class UserDaoImpl {

    @Autowired
    private ScoreUsersMapper mapper;

    @Autowired
    SqlSessionTemplate sqlSession;

    Logger logger = Logger.getLogger(UserDaoImpl.class);

    public void insert() {
        ScoreUsers scoreUser = new ScoreUsers();
        scoreUser.setUsername(UUID.randomUUID().toString());
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
        logger.info(scoreUser);
        logger.info("123456");
        assert (result == 1);
    }

    /**
     * 查询
     * @param username
     * @return
     */
    public ScoreUsers selectByPrimaryKey(String username){
        return mapper.selectByPrimaryKey(username);
    }


    public ScoreUsers selectByPrimaryKey2(String username){
        return sqlSession.selectOne("findUserInfo",username);
    }

}
