package com.qy.yms.server;

import java.sql.SQLException;

import com.qy.yms.dao.YMSUserDao;

public class YMSLoginManeger {

	static YMSUserDao loginDao;
	public YMSLoginManeger() {
		// TODO �Զ����ɵĹ��캯�����
	}

	//�û���¼
	public static boolean logoon(String name,String password){
		boolean b = false;
		loginDao=new YMSUserDao();
		b = loginDao.check(name,password);
		return b;
	}
	//�������ݿⲻ�����κ�����
		public static void UpdateDB(String sql){
			if(sql.length()<=0){return;}
			loginDao=new YMSUserDao();
			 loginDao.update(sql);
		}
}
