package com.baizhi.wyt.service;

import com.baizhi.wyt.dao.UserDao;
import com.baizhi.wyt.entity.User;
import com.baizhi.wyt.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> queryAll() {
        SqlSession session = null;
        try {
            session = MybatisUtil.openSession();
            UserDao dao = session.getMapper(UserDao.class);
            List<User> list = dao.queryAll();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("异常");
        }
    }

    @Override
    public User queryOne(int id) {
        SqlSession session = null;
        try {
            session = MybatisUtil.openSession();
            UserDao dao = session.getMapper(UserDao.class);
            User user = dao.queryOne(id);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("异常");
        }
    }

    @Override
    public void insert(User u) {
        SqlSession session = null;
        try {
            session = MybatisUtil.openSession();
            UserDao dao = session.getMapper(UserDao.class);
            dao.insert(u);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("异常");
        }
    }

    @Override
    public void update(User u) {
        SqlSession session = null;
        try {
            session = MybatisUtil.openSession();
            UserDao dao = session.getMapper(UserDao.class);
            dao.update(u);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("异常");
        }
    }

    @Override
    public void delete(int id) {
        SqlSession session = null;
        try {
            session = MybatisUtil.openSession();
            UserDao dao = session.getMapper(UserDao.class);
            dao.delete(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("异常");
        }
    }
}
