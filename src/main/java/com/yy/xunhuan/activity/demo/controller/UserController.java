package com.yy.xunhuan.activity.demo.controller;

import com.yy.xunhuan.activity.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/23.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/isNewUser")
    @ResponseBody
    public Map isNewUser(Long uid){
        Map nyyData=new HashMap();
        boolean result=userService.isNewUser(uid);
        nyyData.put("result",result);
        return nyyData;
    }

}
