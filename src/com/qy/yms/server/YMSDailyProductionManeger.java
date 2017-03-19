package com.qy.yms.server;

import com.qy.yms.dao.YMSUserDao;

public class YMSDailyProductionManeger {

	YMSUserDao dailyProduction;
	public YMSDailyProductionManeger() {
		// TODO 自动生成的构造函数存根
	}
	public void dailyProductionAdd(String[] list) {
		// TODO 自动生成的方法存根
		dailyProduction=new YMSUserDao();
		dailyProduction.addDailyProductionDao(list);

	}

}
