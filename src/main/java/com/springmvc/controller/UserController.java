package com.springmvc.controller;

import com.alibaba.fastjson.JSONObject;
import com.springmvc.entity.ScoreUsers;
import com.springmvc.service.UserService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 访问路径 例如：http://localhost/getUserInfoBySqlId
 * 这里演示了 SSM 项目的基本用法。
 *
 */
@Controller
public class UserController {
    //这个是log4j
    private static Logger logger = Logger.getLogger(UserController.class);
    //这个是slf4j
    private static final org.slf4j.Logger logger_slf4j = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;


    /**
     * 请求数据
     * @return
     */
    @RequestMapping("/getInfo")
    @ResponseBody
    public String getInfo() {
        logger.info("getInfo");
        logger_slf4j.info("getinfo");
        return "getInfo";
    }

    /**
     * 添加user数据
     * 通过Mapper接口
     * @return
     */
    @RequestMapping("/addUserInfoByMapper")
    @ResponseBody
    public String addUserInfoByMapper() {
        System.out.print("=================addUserInfoByMapper================");
        userService.addUserInfoByMapper();
        return "success";
    }

    /**
     * 查询
     * 通过设置sqlId来查询数据
     * @return
     */
    @RequestMapping("/getUserInfoBySqlId")
    @ResponseBody
    public String getUserInfoBySqlId() {
        try {
            logger.info("user信息查询");
            ScoreUsers scoreUsers = userService.getUserInfoBySqlId("K0117                                   ");
            logger.info(scoreUsers);
            String outStr = JSONObject.toJSONString(scoreUsers);
            return outStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

    /**
     * 查询
     * 通过设置Mapper接口查询数据
     * @return
     */
    @RequestMapping("/getUserInfoByMapper")
    @ResponseBody
    public String getUserInfoByMapper() {
        try {
            logger.info("user信息查询");
            ScoreUsers scoreUsers = userService.getUserInfoByMapper("K0117                                   ");
            logger.info(scoreUsers);
            String outStr = JSONObject.toJSONString(scoreUsers);
            return outStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }

}
