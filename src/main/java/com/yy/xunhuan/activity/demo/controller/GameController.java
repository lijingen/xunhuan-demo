package com.yy.xunhuan.activity.demo.controller;

import com.yy.xunhuan.activity.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/24.
 */
@Controller
public class GameController {
    @Autowired
    private GameService gameService;
    @RequestMapping("/getGameStatus")
    @ResponseBody
    public Map getGameStatus(Long gameId){
        Map nyyData=new HashMap();
        Integer status=gameService.getGameStatus(gameId);
        nyyData.put("status",status);
        return nyyData;
    }
}
