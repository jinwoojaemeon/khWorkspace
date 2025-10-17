package com.kh.mybatis.common;

import java.io.InputStream;
import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	public static SqlSession getSqlSession() {
		String resource = "/mybatis-config.xml";
		SqlSession session = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession(false);  // false : 수동 커밋
		} catch (IOException e) {
			e.printStackTrace();
		}

		return session;
	}
}
