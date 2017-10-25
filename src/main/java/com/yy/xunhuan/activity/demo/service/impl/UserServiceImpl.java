package com.yy.xunhuan.activity.demo.service.impl;

import com.yy.cs.center.ReferenceFactory;
import com.yy.xunhuan.activity.demo.service.UserService;
import com.yy.xunhuan.activity.demo.swift.XHRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/24.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private ReferenceFactory<XHRecordService> xhRecordServiceFactory;
    @Override
    public boolean isNewUser(Long uid) {
        try {
            long time=xhRecordServiceFactory.getClient().QueryIsNewUser(uid);
            return time<=0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
