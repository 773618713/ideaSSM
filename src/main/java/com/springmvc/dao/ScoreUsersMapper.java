package com.springmvc.dao;

import com.springmvc.entity.ScoreUsers;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreUsersMapper {
    int deleteByPrimaryKey(String username);

    int insert(ScoreUsers record);

    int insertSelective(ScoreUsers record);

    ScoreUsers selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(ScoreUsers record);

    int updateByPrimaryKey(ScoreUsers record);
}