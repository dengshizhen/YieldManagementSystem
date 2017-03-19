package com.qy.yms.server;

import java.util.ArrayList;

import com.qy.yms.dao.YMSUserDao;
import com.qy.yms.view.WrongFrame;

public class YMSOrderManeger {
	YMSUserDao addProDao;//工序
	YMSUserDao addProNameDao;//新增工序名
	YMSUserDao updateUni;//修改单价
	YMSUserDao addComDao;//品名
	YMSUserDao addDailyDao;//生产日报基础
	YMSLookupInfo ymsLookupInfo;
	public static boolean flagCom;
	String commodityNum;
	public YMSOrderManeger() {
		// TODO 自动生成的构造函数存根
	}
	//添加工序名
	public void addProcessName(String category,String proName){
		addProNameDao=new YMSUserDao();
		addProNameDao.addProNameDao(category, proName);
	}
	//添加工序
	public void addProcess(String [] addPro,String []addCom) {
		// TODO 自动生成的方法存根
		addProDao=new YMSUserDao();
		commodityNum=addProDao.checkCommodityExistDao(addCom[1]);
		System.out.println("查询"+addCom[1]+"显示"+commodityNum);
		if(commodityNum.equals("")||commodityNum.equals(null)){
			addProDao.addCommodityDao(addCom);
			System.out.println("添加品名");
			addProDao.addProcessDao(addPro);
			System.out.println("添加工序1");
		}else{
			if(addProDao.checkProExistDao(addPro)){
			addProDao.addProcessDao(addPro);
			System.out.println("添加工序2");
			}
			
		};
	}

	//修改单价
	public void updateUni(String commoditynum,String processname,String uni,String total,String quantity){
		updateUni=new YMSUserDao();
		updateUni.updateUniDao(commoditynum, processname, uni,total,quantity);
		
	}
	public void addCommodity(String []addCom){
		addComDao=new YMSUserDao();
		commodityNum=addComDao.checkCommodityExistDao(addCom[1]);
		if(commodityNum.equals("")||commodityNum.equals(null)){
				flagCom=true;
			addComDao.addCommodityDao(addCom);
		}else{
		flagCom=false;
		}
	}
	public void addDailyBase(String []addDaily){
		addDailyDao=new YMSUserDao();
		addDailyDao.addDailyProductionDao(addDaily);
	}
}
