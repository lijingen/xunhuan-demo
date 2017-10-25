package com.yy.xunhuan.activity.demo.listener;

import com.rabbitmq.client.Channel;
import com.yy.cs.base.json.Json;
import com.yy.xunhuan.activity.demo.service.GameService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2017/10/24.
 */
@Service
public class GameInfoMessageListener implements ChannelAwareMessageListener {
    @Autowired
    private GameService gameService;
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
     String str=new String(message.getBody());
     Map dataMap= Json.strToObj(str,Map.class);
     System.out.println("-----------"+str);
     long gameId= Long.parseLong(dataMap.get("game_id").toString());
     gameService.updateGameStatus(gameId);
    }
}
