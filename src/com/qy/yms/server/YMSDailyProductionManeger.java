package com.qy.yms.server;

import com.qy.yms.dao.YMSUserDao;

public class YMSDailyProductionManeger {

	YMSUserDao dailyProduction;
	public YMSDailyProductionManeger() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public void dailyProductionAdd(String[] list) {
		// TODO �Զ����ɵķ������
		dailyProduction=new YMSUserDao();
		dailyProduction.addDailyProductionDao(list);

	}

}
