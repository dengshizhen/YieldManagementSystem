package com.qy.yms.server;

import java.util.ArrayList;

import com.qy.yms.dao.YMSUserDao;

public class YMSCheckMagener {

	YMSUserDao checkDao;
	public YMSCheckMagener() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public ArrayList<ArrayList<String>> checkDone(boolean flag,String ordernum){
		return checkDao.checkDoneDao(flag, ordernum);
	}

}
