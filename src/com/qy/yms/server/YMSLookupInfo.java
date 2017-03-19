package com.qy.yms.server;

import java.util.ArrayList;

import com.qy.yms.dao.YMSUserDao;

public class YMSLookupInfo {

	YMSUserDao lookupCateDao;
	YMSUserDao lookupProNameDao;
	YMSUserDao lookupOrderDao;
	YMSUserDao lookupCommodityDao;
	YMSUserDao lookupProUniDao;
	YMSUserDao lookupUniquantityDao;
	public YMSLookupInfo() {
		// TODO 自动生成的构造函数存根
	}
	//查找类别
	public ArrayList<String> lookupCategory() {
		ArrayList<String> category=new ArrayList<>();
		lookupCateDao=new YMSUserDao();
		category=lookupCateDao.lookupCategoryDao();
		return category;
	}
	//查找工序名
		public ArrayList<String> lookupProName(String category) {
			ArrayList<String> proName=new ArrayList<>();
			lookupProNameDao=new YMSUserDao();
			proName=lookupProNameDao.lookupProcessNameDao(category);
			return proName;
		}
		//查询修改单价对应数量
		public ArrayList<String>  lookupUniquantity(String commoditynum,String processname) {
			lookupUniquantityDao=new YMSUserDao();
			return lookupUniquantityDao.lookupUniquantityDao(commoditynum, processname);
		}
		//查找工人姓名及编号
				public ArrayList<String> lookupWorNumName() {
					ArrayList<String> workerNumName=new ArrayList<>();
					lookupProNameDao=new YMSUserDao();
					workerNumName=lookupProNameDao.lookupWorkerNameDao("1");
					return workerNumName;
				}
				//查找工人编号
				public ArrayList<String> lookupWorNum() {
					ArrayList<String> workerNum=new ArrayList<>();
					lookupProNameDao=new YMSUserDao();
					workerNum=lookupProNameDao.lookupWorkerNameDao("2");
					return workerNum;
				}
				//查找工人姓名
				public ArrayList<String> lookupWorName() {
					ArrayList<String> workerName=new ArrayList<>();
					lookupProNameDao=new YMSUserDao();
					workerName=lookupProNameDao.lookupWorkerNameDao("3");
					return workerName;
				}
		//查找订单
		public ArrayList<String> lookupOrder() {
			ArrayList<String> order=new ArrayList<>();
			lookupOrderDao=new YMSUserDao();
			order=lookupOrderDao.lookupOrderNumDao();
			return order;
		}
		//查找品名
		public ArrayList<String> lookupCommodity(String order,String flag) {
			ArrayList<String> commodity=new ArrayList<>();
			lookupCommodityDao=new YMSUserDao();
			commodity=lookupCommodityDao.lookupCommodityDao(order,flag);
			return commodity;
		}
		//查找品名下工序及单价
				public ArrayList<String> lookupComPro(String commodity,boolean flag) {
					ArrayList<String> process=new ArrayList<>();
					lookupCommodityDao=new YMSUserDao();
					process=lookupCommodityDao.lookupComProDao(commodity,flag);
					return process;
				}
		

}
