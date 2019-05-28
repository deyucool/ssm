package com.deyu.dao;

import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionSource {
	String resource = "conf.xml";
    InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
    SqlSession session = sessionFactory.openSession();
    StringBuffer statement =new StringBuffer("com.deyu.dao.");
    
    public SqlSession getSession() {
    	 return session;
    }
    
    public Object executeQueryResult(String sta,String condition) {
    	statement = statement.append(sta);
   	 	return session.selectOne(statement.toString(), condition);
    }
    
    public Object executeQueryResult(String sta) {
    	statement = statement.append(sta);
   	 	return session.selectMap(statement.toString(), "1==1");
    }
}
