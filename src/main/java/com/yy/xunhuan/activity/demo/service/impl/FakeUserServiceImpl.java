package com.yy.xunhuan.activity.demo.service.impl;

import com.yy.xunhuan.activity.demo.dao.gen.mapper.XhFakeUserMapper;
import com.yy.xunhuan.activity.demo.dao.gen.model.XhFakeUserExample;
import com.yy.xunhuan.activity.demo.service.FakeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 */
@Service("fakeUserService")
public class FakeUserServiceImpl implements FakeUserService {

    @Autowired
    private XhFakeUserMapper fakeUserMapper;


    @Override
    public List fakeUserList() {
        System.out.println("list----------");
        return fakeUserMapper.selectByExample(new XhFakeUserExample());
    }



}
