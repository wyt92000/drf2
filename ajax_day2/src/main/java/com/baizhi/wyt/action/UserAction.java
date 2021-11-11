package com.baizhi.wyt.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.wyt.entity.User;
import com.baizhi.wyt.service.UserService;
import com.baizhi.wyt.service.UserServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class UserAction {
    private Integer id;
    private List<User> users;
    private User user;
    private UserService us = new UserServiceImpl();
    public String queryAll(){
        try {
            //调用业务
            users = us.queryAll();
            for (User u : users) {
                System.out.println(u);
            }
            System.out.println(users.size()+"**********");
            String json = JSON.toJSONStringWithDateFormat(users,"yyyy-MM-dd");
            HttpServletResponse response = ServletActionContext.getResponse();
            //设置响应乱码
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            response.getWriter().println(json);
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    public String queryOne(){
        try {
            //调用业务
            user = us.queryOne(id);
            String json = JSON.toJSONStringWithDateFormat(user,"yyyy-MM-dd");
            HttpServletResponse response = ServletActionContext.getResponse();
            //设置响应乱码
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            response.getWriter().println(json);
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
