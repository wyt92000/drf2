package com.baizhi.wyt.service;

import com.baizhi.wyt.entity.User;

import java.util.List;

public interface UserService {
    public List<User> queryAll();
    public User queryOne(int id);
    public void insert(User u);
    public void update(User u);
    public void delete(int id);
}
