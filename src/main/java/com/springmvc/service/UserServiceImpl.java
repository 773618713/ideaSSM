package com.springmvc.service;

import com.springmvc.dao.ScoreUsersMapper;
import com.springmvc.dao.UserDao;
import com.springmvc.dao.UserDaoImpl;
import com.springmvc.entity.ScoreUsers;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * user 业务处理
 */
@Service
public class UserServiceImpl implements UserService{
    Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private ScoreUsersMapper mapper;

    @Autowired
    private UserDao userDao;

    /**
     * 添加user数据
     * 通过Mapper接口
     * @return
     */
    @Override
    public void addUserInfoByMapper() {
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
        assert (result == 1);
    }

    /**
     * 查询
     * 通过设置sqlId来查询数据
     * @return
     */
    @Override
    public ScoreUsers getUserInfoBySqlId(String username) {
        return userDao.getUserInfoBySqlId(username);
    }

    /**
     * 查询
     * 通过设置Mapper接口查询数据
     * @return
     */
    @Override
    public ScoreUsers getUserInfoByMapper(String username) {
        return mapper.selectByPrimaryKey(username);
    }


}
