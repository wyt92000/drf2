package com.baizhi.wyt.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisUtil {
	private static SqlSessionFactory factory = null;
	private static final ThreadLocal<SqlSession> tl = new ThreadLocal<>();
	static{
		try{
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");	
			//获取factory-》sqlsessionFactory工厂
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(reader);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	//获取sqlSession
	public static SqlSession openSession(){
		SqlSession session = tl.get();
		if(session == null){
			session = factory.openSession();
			tl.set(session);
		}
		return session;
	}
	//释放资源
	public static void close(SqlSession session){
		if(session!=null){
			session.close();
			tl.remove();
		}
	}
}
