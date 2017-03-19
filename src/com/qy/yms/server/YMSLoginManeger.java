package com.qy.yms.server;

import java.sql.SQLException;

import com.qy.yms.dao.YMSUserDao;

public class YMSLoginManeger {

	static YMSUserDao loginDao;
	public YMSLoginManeger() {
		// TODO 自动生成的构造函数存根
	}

	//用户登录
	public static boolean logoon(String name,String password){
		boolean b = false;
		loginDao=new YMSUserDao();
		b = loginDao.check(name,password);
		return b;
	}
	//更新数据库不返回任何数据
		public static void UpdateDB(String sql){
			if(sql.length()<=0){return;}
			loginDao=new YMSUserDao();
			 loginDao.update(sql);
		}
}
