package com.baizhi.wyt.test;

import com.baizhi.wyt.entity.User;
import com.baizhi.wyt.service.UserService;
import com.baizhi.wyt.service.UserServiceImpl;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class Test_user {
    @Test
    public void test(){
        //生成uuid
        System.out.println(UUID.randomUUID().toString());
    }
    @Test
    public void test1(){
        UserService us = new UserServiceImpl();
        List<User> list = us.queryAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void test2(){
        UserService us = new UserServiceImpl();
        User user = us.queryOne(1);
        System.out.println(user);
    }
}
