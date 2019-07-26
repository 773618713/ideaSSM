package com.springmvc.controller;

import com.alibaba.fastjson.JSONObject;
import com.springmvc.dao.UserDaoImpl;
import com.springmvc.entity.ScoreUsers;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserConroller {
    //private static Logger logger = Logger.getLogger(UserConroller.class);
    Logger logger = Logger.getLogger(UserConroller.class);

    @Resource
    UserDaoImpl userDaoImpl;

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(){
        System.out.print("user================");
        userDaoImpl.insert();
        Map map = new HashMap();
        map.put("张三","1");
        map.put("李四","2");
        map.put("王二","3");
        logger.info(map);
        logger.info("=========logger========");
        return "user==";
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo() {
        logger.info("user信息查询");
        ScoreUsers scoreUsers = userDaoImpl.selectByPrimaryKey("K0117                                   ");
        logger.info(scoreUsers);
        String outStr = JSONObject.toJSONString(scoreUsers);
        return outStr;
    }
}
