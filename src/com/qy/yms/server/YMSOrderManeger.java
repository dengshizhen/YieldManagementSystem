package com.qy.yms.server;

import java.util.ArrayList;

import com.qy.yms.dao.YMSUserDao;
import com.qy.yms.view.WrongFrame;

public class YMSOrderManeger {
	YMSUserDao addProDao;//����
	YMSUserDao addProNameDao;//����������
	YMSUserDao updateUni;//�޸ĵ���
	YMSUserDao addComDao;//Ʒ��
	YMSUserDao addDailyDao;//�����ձ�����
	YMSLookupInfo ymsLookupInfo;
	public static boolean flagCom;
	String commodityNum;
	public YMSOrderManeger() {
		// TODO �Զ����ɵĹ��캯�����
	}
	//��ӹ�����
	public void addProcessName(String category,String proName){
		addProNameDao=new YMSUserDao();
		addProNameDao.addProNameDao(category, proName);
	}
	//��ӹ���
	public void addProcess(String [] addPro,String []addCom) {
		// TODO �Զ����ɵķ������
		addProDao=new YMSUserDao();
		commodityNum=addProDao.checkCommodityExistDao(addCom[1]);
		System.out.println("��ѯ"+addCom[1]+"��ʾ"+commodityNum);
		if(commodityNum.equals("")||commodityNum.equals(null)){
			addProDao.addCommodityDao(addCom);
			System.out.println("���Ʒ��");
			addProDao.addProcessDao(addPro);
			System.out.println("��ӹ���1");
		}else{
			if(addProDao.checkProExistDao(addPro)){
			addProDao.addProcessDao(addPro);
			System.out.println("��ӹ���2");
			}
			
		};
	}

	//�޸ĵ���
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
