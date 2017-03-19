package com.qy.yms.server;

import java.util.ArrayList;

import com.qy.yms.dao.YMSUserDao;

public class YMSSalaryManeger {

	YMSUserDao salaryDao;
	public YMSSalaryManeger() {
		// TODO 自动生成的构造函数存根
	}
	public ArrayList<ArrayList<String>> salaryCheck(String jobnum,String date){
		salaryDao=new YMSUserDao();
		System.out.println(jobnum+"a"+date);
		return salaryDao.checkSalary(jobnum, date);
		
	}
	public ArrayList<ArrayList<String>> salaryCheck(String ordernum){
		salaryDao=new YMSUserDao();
	
		return salaryDao.checkSalary(ordernum);
		
	}

}
