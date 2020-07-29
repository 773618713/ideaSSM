package com.springmvc.dao;

import com.springmvc.entity.ScoreUsers;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreUsersMapper {
    int deleteByPrimaryKey(String username);

    /**
     * 添加user数据
     * 通过Mapper接口
     * @return
     */
    int insert(ScoreUsers record);

    int insertSelective(ScoreUsers record);

    /**
     * 查询
     * 通过设置Mapper接口查询数据
     * @return
     */
    ScoreUsers selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(ScoreUsers record);

    int updateByPrimaryKey(ScoreUsers record);

    ScoreUsers findUserInfo(String username);
}