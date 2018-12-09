package com.springmvc.controller;

import com.springmvc.dao.UserDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserConroller {

    @Resource
    UserDaoImpl userDaoImpl;

    @RequestMapping("/user")
    @ResponseBody
    public String getUserInfo(){
        System.out.print("user================");
        userDaoImpl.insert();
        return "user==";
    }
}
