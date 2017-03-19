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
		// TODO �Զ����ɵĹ��캯�����
	}
	//�������
	public ArrayList<String> lookupCategory() {
		ArrayList<String> category=new ArrayList<>();
		lookupCateDao=new YMSUserDao();
		category=lookupCateDao.lookupCategoryDao();
		return category;
	}
	//���ҹ�����
		public ArrayList<String> lookupProName(String category) {
			ArrayList<String> proName=new ArrayList<>();
			lookupProNameDao=new YMSUserDao();
			proName=lookupProNameDao.lookupProcessNameDao(category);
			return proName;
		}
		//��ѯ�޸ĵ��۶�Ӧ����
		public ArrayList<String>  lookupUniquantity(String commoditynum,String processname) {
			lookupUniquantityDao=new YMSUserDao();
			return lookupUniquantityDao.lookupUniquantityDao(commoditynum, processname);
		}
		//���ҹ������������
				public ArrayList<String> lookupWorNumName() {
					ArrayList<String> workerNumName=new ArrayList<>();
					lookupProNameDao=new YMSUserDao();
					workerNumName=lookupProNameDao.lookupWorkerNameDao("1");
					return workerNumName;
				}
				//���ҹ��˱��
				public ArrayList<String> lookupWorNum() {
					ArrayList<String> workerNum=new ArrayList<>();
					lookupProNameDao=new YMSUserDao();
					workerNum=lookupProNameDao.lookupWorkerNameDao("2");
					return workerNum;
				}
				//���ҹ�������
				public ArrayList<String> lookupWorName() {
					ArrayList<String> workerName=new ArrayList<>();
					lookupProNameDao=new YMSUserDao();
					workerName=lookupProNameDao.lookupWorkerNameDao("3");
					return workerName;
				}
		//���Ҷ���
		public ArrayList<String> lookupOrder() {
			ArrayList<String> order=new ArrayList<>();
			lookupOrderDao=new YMSUserDao();
			order=lookupOrderDao.lookupOrderNumDao();
			return order;
		}
		//����Ʒ��
		public ArrayList<String> lookupCommodity(String order,String flag) {
			ArrayList<String> commodity=new ArrayList<>();
			lookupCommodityDao=new YMSUserDao();
			commodity=lookupCommodityDao.lookupCommodityDao(order,flag);
			return commodity;
		}
		//����Ʒ���¹��򼰵���
				public ArrayList<String> lookupComPro(String commodity,boolean flag) {
					ArrayList<String> process=new ArrayList<>();
					lookupCommodityDao=new YMSUserDao();
					process=lookupCommodityDao.lookupComProDao(commodity,flag);
					return process;
				}
		

}
