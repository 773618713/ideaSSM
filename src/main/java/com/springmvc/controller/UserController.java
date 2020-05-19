package com.springmvc.controller;

import com.alibaba.fastjson.JSONObject;
import com.springmvc.dao.UserDaoImpl;
import com.springmvc.entity.ScoreUsers;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 访问路径 例如：http://localhost/getUserInfo
 */
@Controller
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    //Logger logger = Logger.getLogger(UserConroller.class);

    @Resource
    UserDaoImpl userDaoImpl;

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser() {
        System.out.print("user================");
        userDaoImpl.insert();
        return "user==";
    }

    /**
     * 查询
     *
     * @return
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo() {
        try {
            logger.info("user信息查询");
            ScoreUsers scoreUsers = userDaoImpl.selectByPrimaryKey2("K0117                                   ");
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
     *
     * @return
     */
    @RequestMapping("/getInfo")
    @ResponseBody
    public String getInfo() {
        logger.info("getInfo");
        return "getInfo";
    }
}
