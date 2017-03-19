package com.qy.yms.server;

import com.qy.yms.dao.YMSUserDao;

public class YMSWorkerManeger {

	YMSUserDao addWorkerDao;
	YMSUserDao deleteWorkerDao;
	public YMSWorkerManeger() {
		// TODO 自动生成的构造函数存根
	}
	
	public void addWorker(String jobnum,String name){
		addWorkerDao=new YMSUserDao();
		addWorkerDao.addWorkerInfo(jobnum, name);
	}
	
	public void deletWorker(String jobnum){
		deleteWorkerDao=new YMSUserDao();
		deleteWorkerDao.deleteWorkerInfo(jobnum);
	}

}
