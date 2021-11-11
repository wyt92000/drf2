package com.baizhi.wyt.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class Test_conn {
    public static void main(String[] args) throws Exception {
        //读取mybatis-congin.xml配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //获取factory-》sqlsessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);
        //最终获取Sqlsession
        SqlSession session = factory.openSession();
        System.out.println(session.getConnection());

    }
}