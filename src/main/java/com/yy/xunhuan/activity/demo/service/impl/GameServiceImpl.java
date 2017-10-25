package com.yy.xunhuan.activity.demo.service.impl;

import com.yy.xunhuan.activity.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/10/24.
 */
@Service("gameService")
public class GameServiceImpl implements GameService {
    @Autowired
    private Jedis myJedis;
    @Override
    public void updateGameStatus(Long uid) {;
        String userStatueKey="GAME_STATUS_"+uid;
        myJedis.expire(userStatueKey,1000);
        myJedis.set(userStatueKey,"1");
    }
    @Override
    public int getGameStatus(Long uid) {
        String userStatueKey="GAME_STATUS_"+uid;
        String status=myJedis.get(userStatueKey);
        return status==null?0:Integer.parseInt(status);
    }
}
