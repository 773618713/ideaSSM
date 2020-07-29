package com.springmvc.dao;

import com.springmvc.entity.ScoreUsers;

public interface UserDao {
    /**
     * 查询
     * 通过设置sqlId来查询数据
     * @return
     */
    public ScoreUsers getUserInfoBySqlId(String username);
}
