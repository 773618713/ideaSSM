package com.springmvc.service;

import com.springmvc.entity.ScoreUsers;

/**
 * user 业务处理
 */
public interface UserService {
    /**
     * 添加user数据
     * 通过Mapper接口
     * @return
     */
    public void addUserInfoByMapper();

    /**
     * 查询
     * 通过设置sqlId来查询数据
     * @return
     */
    public ScoreUsers getUserInfoBySqlId(String username);

    /**
     * 查询
     * 通过设置Mapper接口查询数据
     * @return
     */
    public ScoreUsers getUserInfoByMapper(String username);
}
