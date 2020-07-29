package com.springmvc.dao;

import com.springmvc.entity.ScoreUsers;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * dao层
 */
@Repository
public class UserDaoImpl implements UserDao{
    Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    SqlSessionTemplate sqlSession;

    /**
     * 查询
     * 通过设置sqlId来查询数据
     * @return
     */
    @Override
    public ScoreUsers getUserInfoBySqlId(String username) {
        return sqlSession.selectOne("findUserInfo", username);
    }
}
