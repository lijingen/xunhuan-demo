package com.yy.xunhuan.activity.demo.service;

/**
 * Created by Administrator on 2017/10/24.
 */
public interface GameService {

     int getGameStatus(Long uid);

     void updateGameStatus(Long uid);
}
