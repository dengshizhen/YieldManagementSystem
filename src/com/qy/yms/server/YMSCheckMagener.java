package com.qy.yms.server;

import java.util.ArrayList;

import com.qy.yms.dao.YMSUserDao;

public class YMSCheckMagener {

	YMSUserDao checkDao;
	public YMSCheckMagener() {
		// TODO 自动生成的构造函数存根
	}
	
	public ArrayList<ArrayList<String>> checkDone(boolean flag,String ordernum){
		return checkDao.checkDoneDao(flag, ordernum);
	}

}
