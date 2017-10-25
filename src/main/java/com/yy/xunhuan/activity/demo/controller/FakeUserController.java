package com.yy.xunhuan.activity.demo.controller;

import com.yy.xunhuan.activity.demo.service.FakeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/23.
 */
@Controller
public class FakeUserController {
    @Autowired
    private FakeUserService fakeUserService;
    @RequestMapping("/findFakeUserList")
    @ResponseBody
    public Map getFakeUserList(){
        Map nyyData=new HashMap();
        List list=fakeUserService.fakeUserList();
        nyyData.put("list",list);
        return nyyData;
    }
}
