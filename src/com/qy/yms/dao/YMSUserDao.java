package com.qy.yms.dao;

import java.awt.List;
import java.awt.geom.Line2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class YMSUserDao {

	public YMSUserDao() {
		// TODO 自动生成的构造函数存根
	}
	public static boolean check(String user,String pwd)//登陆验证
	{
		boolean flag=false;
		  
			String sql="select password from user where user_name=?";
			String paras[]={user};
		    SqlHelper sp=new SqlHelper();
			ResultSet rs=sp.query(sql,paras);
			try
			{ 
				rs.next();
			String spwd=rs.getString(1);//得到密码
			if(spwd.equals(pwd))
			{
				flag=true;//密码匹配，登陆成功
			}			
		}
		catch(Exception e)
		{	
			flag=false;//有任何异常发生，登陆失败
		}finally {
			sp.close();
		}
	
		return flag;
	}
	//查看品名是否已经存在，若存在，则将不进行添加
	public static String checkCommodityExistDao(String commodityNum){
		String commoditynum="";
		String sql="select commoditynum from commodity where commoditynum=?";
		String paras[]={commodityNum};
		SqlHelper sp=new SqlHelper();
		ResultSet rs=sp.query(sql, paras);
		try {
			if(rs.next()){
				commoditynum=rs.getString("commoditynum");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			sp.close();
		}
		 return commoditynum;
	}
	
	//添加新的品名
	public static void addCommodityDao(String [] addCom){
		String sql="insert into commodity values (null,?,?,?,?,?,?) ";
		String paras[]=addCom;
		SqlHelper sp=new SqlHelper();
		sp.query2(sql, paras);
	}
	//查看工序名是否已经存在，若存在，则将不进行添加
		public static boolean checkProExistDao(String []pro){
			boolean exits=true;
			String sql="select commoditynum from comprocess where commoditynum=? and processname=? and category=?and univalent=?";
			String paras[]={pro[0],pro[1],pro[2],pro[3]};
			SqlHelper sp=new SqlHelper();
			ResultSet rs=sp.query(sql, paras);
			try {
				if(rs.next()){
					exits=(rs.getString("commoditynum")).equals("");
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				sp.close();
			}
			 return exits;
		}
	//添加新的工序
	public static void addProcessDao(String [] addPro){
			String sql="insert into comprocess values (null,?,?,?,?) ";
			String paras[]=addPro;
			SqlHelper sp=new SqlHelper();
			sp.query2(sql, paras);
		}
	//查找修改单价对应数量
	public ArrayList<String> lookupUniquantityDao(String commoditynum,String processname){
		String sql="select quantity from daily_production where commoditynum=? and processname=? ";
		String paras[]={commoditynum,processname};
        ArrayList<String> result = new ArrayList<>();
		SqlHelper sp=new SqlHelper();
		ResultSet rs=sp.query(sql, paras);
try {
			
			while(rs.next()){
				
				System.out.println("总数是"+rs.getString(1).toString());
				result.add(rs.getString(1).toString());
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			sp.close();
		}
		return result;
	}
	//修改工序单价及总价
	public void updateUniDao(String commoditynum,String processname,String uni,String total,String quantity){
		String sql="UPDATE daily_production SET univalent=? ,total=? WHERE commoditynum=? AND processname=? And quantity=? ;";
				String paras[]={uni,total,commoditynum,processname,quantity};
		SqlHelper sp=new SqlHelper();
		sp.query2(sql, paras);
		System.out.println("done");
		String sql2="UPDATE comprocess SET univalent=? where commoditynum=? and processname=?";
		String paras2[]={uni,commoditynum,processname};
		SqlHelper sp2=new SqlHelper();
		sp2.query2(sql2, paras2);
		System.out.println("done");
	}
	//查找类别
	public ArrayList<String> lookupCategoryDao(){
		String category="category";
		String sql="select distinct category from processnames";
		String paras[]={};
		ArrayList<String> result = new ArrayList<>();
		
		SqlHelper sp=new SqlHelper();
		ResultSet rs=sp.query(sql, paras);
		try {
			
			while(rs.next()){
				
				System.out.println(rs.getString(1).toString());
				result.add(rs.getString(1).toString());
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			sp.close();
		}
		return result;
		
	}
	//添加工序名
	public void addProNameDao(String category,String proName){
		String sql="insert into processnames values (null,?,?)";
		String paras[]={proName,category};
		SqlHelper sp=new SqlHelper();
		sp.query2(sql, paras);
	}
	//查找工序
		public ArrayList<String> lookupProcessNameDao(String category){
			String processname="processname";
			String sql="select processname from processnames where category=?";
			String paras[]={category};
			ArrayList<String> result=new ArrayList<>();
			SqlHelper sp=new SqlHelper();
			ResultSet rs=sp.query(sql, paras);
			try {
				
				while(rs.next()){
					result.add(rs.getString(processname));
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				sp.close();
			}
			return result;
			
		}
		//添加工人
		public void addWorkerInfo(String jobnum,String name){
			String sql="insert into worker values (null,?,?)";
			String paras[]={jobnum,name};
			SqlHelper sp=new SqlHelper();
			sp.query2(sql, paras);
		}
		//删除工人
				public void deleteWorkerInfo(String jobnum){
					String sql="delete from worker where jobnum=?";
					String paras[]={jobnum};
					SqlHelper sp=new SqlHelper();
					sp.query2(sql, paras);
				}
		//查找工人姓名
		public ArrayList<String> lookupWorkerNameDao(String flag) {
			// TODO 自动生成的方法存根
			String workername="workername";
			String jobnum="jobnum";
			String sql="select * from worker";
			String paras[]={};
			ArrayList<String> result1=new ArrayList<>();
			ArrayList<String> result2=new ArrayList<>();
			ArrayList<String> result3=new ArrayList<>();
			int count=0;
			SqlHelper sp=new SqlHelper();
			ResultSet rs=sp.query(sql, paras);
			try {
				
				while(rs.next()){
					result1.add(rs.getString(3)+"("+rs.getString(2)+")");
					result2.add(rs.getString(2));
					result3.add(rs.getString(3));
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				sp.close();
			}
			if(flag.equals("1")){
			return result1;
			}else if(flag.equals("2")){
				return result2;
			}else{
				return result3;
			}
		}
	//查找订单
		public ArrayList<String> lookupOrderNumDao(){
			String ordernum="ordernum";
			String sql="select distinct ordernum from commodity";
			String paras[]={};
			ArrayList<String> result=new ArrayList<>();
			int count=0;
			SqlHelper sp=new SqlHelper();
			ResultSet rs=sp.query(sql, paras);
			try {
				
				while(rs.next()){
					result.add(rs.getString(ordernum));
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				sp.close();
			}
			return result;
			
		}
		//查找产品编号和品名
				public ArrayList<String> lookupCommodityDao(String order,String flag){
					String commodityname="commodityname";
					String commoditynum="commoditynum";
					String sql="select distinct commodityname ,  commoditynum,size,color from commodity where ordernum=?";
					String paras[]={order};
					ArrayList<String> result1=new ArrayList<>();
					ArrayList<String> result2=new ArrayList<>();
					int count=0;
					SqlHelper sp=new SqlHelper();
					ResultSet rs=sp.query(sql, paras);
					try {
						
						while(rs.next()){
							System.out.println(rs.getString(2)+rs.getString(1)+rs.getString(3)+rs.getString(4));
							result1.add(rs.getString(2)+rs.getString(1)+rs.getString(3)+rs.getString(4));
							result2.add(rs.getString(1));
						}
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}finally {
						sp.close();
					}
					if(flag.equals("1")){
					return result1;
					}else{
						return result2;
					}
					
				}
				//查找工序名
				public ArrayList<String> lookupComProDao(String commodity,boolean flag){
					String processname="processname";
					String univalent="univalent";
					String sql="select processname , univalent from comprocess where commoditynum=?";
					String paras[]={commodity};
					ArrayList<String> result1=new ArrayList<>();
					ArrayList<String> result2=new ArrayList<>();
					SqlHelper sp=new SqlHelper();
					ResultSet rs=sp.query(sql, paras);
					try {
						
						while(rs.next()){
							result1.add(rs.getString(processname));
							result2.add(rs.getString(univalent));
						}
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}finally {
						sp.close();
					}
					if(flag){
					return result1;
					}else{
						return result2;
					}
					
				}
				//添加生产日报
				public static void addDailyProductionDao(String [] addDaily){
					String sql="insert into daily_production values (null,?,?,?,?,?,?,?,?,?,?) ";
					String paras[]=addDaily;
					SqlHelper sp=new SqlHelper();
					sp.query2(sql, paras);
				}
				
				//查看订单
				public static ArrayList<ArrayList<String>> checkDoneDao(Boolean flag,String ordernum){
					String sql1;
					
					if(flag){
						if(ordernum.equals("")){
							System.out.println("这个1"+ordernum);
							System.out.println("这个1"+flag);
							sql1="SELECT DISTINCT c.ordernum,c.commoditynum,d.commodityname,d.size,d.color,d.quantity,c.category,c.processname,c.totaldone FROM( "+
									"SELECT daily_production.`ordernum`,daily_production.`commoditynum`,comprocess.`category`,daily_production.`processname`,SUM(quantity) AS totaldone "+
									"FROM daily_production,comprocess "+
									"WHERE daily_production.`commoditynum`=comprocess.`commoditynum` "+
									"AND daily_production.`processname`=comprocess.`processname` "+
									"GROUP BY ordernum,commoditynum ,daily_production.`processname` "+
									")AS c "+
									"LEFT JOIN commodity AS d "+
									"ON c.commoditynum=d.commoditynum;";
							
						}else{
							System.out.println("这个1"+ordernum);
							System.out.println("这个1"+flag);
							sql1="SELECT DISTINCT c.ordernum,c.commoditynum,d.commodityname,d.size,d.color,d.quantity,c.category,c.processname,c.totaldone FROM( "+
									"SELECT daily_production.`ordernum`,daily_production.`commoditynum`,comprocess.`category`,daily_production.`processname`,SUM(quantity) AS totaldone "+
									"FROM daily_production,comprocess "+
									"WHERE daily_production.`commoditynum`=comprocess.`commoditynum` "+
							        "and daily_production.ordernum=? "+
									"AND daily_production.`processname`=comprocess.`processname` "+
									"GROUP BY ordernum,commoditynum ,daily_production.`processname` "+
									")AS c "+
									"LEFT JOIN commodity AS d "+
									"ON c.commoditynum=d.commoditynum;";
							

						}
					}else if(ordernum.equals("")){
						sql1=	"SELECT DISTINCT e.ordernum,e.commoditynum,e.commodityname,e.size,e.color,e.quantity,e.category,e.processname,e.totaldone FROM "+
								"("+
								"SELECT DISTINCT c.ordernum,c.commoditynum,d.commodityname,d.size,d.color,d.quantity,c.category,c.processname,c.totaldone FROM("+
								"SELECT daily_production.`ordernum`,daily_production.`commoditynum`,comprocess.`category`,daily_production.`processname`,SUM(quantity) AS totaldone	"+
								"FROM daily_production,comprocess "+
								"WHERE daily_production.`commoditynum`=comprocess.`commoditynum` "+
								"AND daily_production.`processname`=comprocess.`processname` "+
								"GROUP BY ordernum,commoditynum ,daily_production.`processname` "+
								")AS c "+
								"LEFT JOIN commodity AS d "+
								"ON c.commoditynum=d.commoditynum )AS e "+
								 "WHERE e.ordernum NOT IN (SELECT DISTINCT i.ordernum FROM ( "+
								"SELECT DISTINCT h.ordernum,h.commoditynum,h.commodityname,h.size,h.color,h.quantity,h.category,h.processname,h.totaldone FROM "+ 
								"("+
								"SELECT DISTINCT f.ordernum,f.commoditynum,g.commodityname,g.size,g.color,g.quantity,f.category,f.processname,f.totaldone FROM( "+
								"SELECT daily_production.`ordernum`,daily_production.`commoditynum`,comprocess.`category`,daily_production.`processname`,SUM(quantity) AS totaldone "+	
								"FROM daily_production,comprocess "+
								"WHERE daily_production.`commoditynum`=comprocess.`commoditynum` "+
								"AND daily_production.`processname`=comprocess.`processname` "+
								"GROUP BY ordernum,commoditynum ,daily_production.`processname` "+
								")AS f "+
								"LEFT JOIN commodity AS g "+
								"ON f.commoditynum=g.commoditynum )AS h "+
								 "WHERE h.totaldone<h.quantity) AS i "+
								")";
						
                      
						}else{
							sql1=	"SELECT DISTINCT e.ordernum,e.commoditynum,e.commodityname,e.size,e.color,e.quantity,e.category,e.processname,e.totaldone FROM "+
									"("+
									"SELECT DISTINCT c.ordernum,c.commoditynum,d.commodityname,d.size,d.color,d.quantity,c.category,c.processname,c.totaldone FROM("+
									"SELECT daily_production.`ordernum`,daily_production.`commoditynum`,comprocess.`category`,daily_production.`processname`,SUM(quantity) AS totaldone	"+
									"FROM daily_production,comprocess "+
									"WHERE daily_production.`commoditynum`=comprocess.`commoditynum` "+
									"AND daily_production.`processname`=comprocess.`processname` "
									+ " and daily_production.`ordernum`=?"+
									"GROUP BY ordernum,commoditynum ,daily_production.`processname` "+
									")AS c "+
									"LEFT JOIN commodity AS d "+
									"ON c.commoditynum=d.commoditynum )AS e "+
									 "WHERE e.ordernum NOT IN (SELECT DISTINCT i.ordernum FROM ( "+
									"SELECT DISTINCT h.ordernum,h.commoditynum,h.commodityname,h.size,h.color,h.quantity,h.category,h.processname,h.totaldone FROM "+ 
									"("+
									"SELECT DISTINCT f.ordernum,f.commoditynum,g.commodityname,g.size,g.color,g.quantity,f.category,f.processname,f.totaldone FROM( "+
									"SELECT daily_production.`ordernum`,daily_production.`commoditynum`,comprocess.`category`,daily_production.`processname`,SUM(quantity) AS totaldone "+	
									"FROM daily_production,comprocess "+
									"WHERE daily_production.`commoditynum`=comprocess.`commoditynum` "+
									"AND daily_production.`processname`=comprocess.`processname` "+
									"GROUP BY ordernum,commoditynum ,daily_production.`processname` "+
									")AS f "+
									"LEFT JOIN commodity AS g "+
									"ON f.commoditynum=g.commoditynum )AS h "+
									 "WHERE h.totaldone<h.quantity) AS i "+
									")";
							
					}
					String paras1[]={};
					String paras2[]={ordernum};
					SqlHelper sp=new SqlHelper();
					ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
					ArrayList<String> line;
					ResultSet rs;
					if(ordernum.equals("")){
						rs=sp.query(sql1, paras1);
					}else {
						rs=sp.query(sql1, paras2);
					}			

					try {
						
						while(rs.next()){
							line=new ArrayList<>();
							line.add(rs.getString(1));
							line.add(rs.getString(2));
							line.add(rs.getString(3));
							line.add(rs.getString(4));
							line.add(rs.getString(5));
							line.add(rs.getString(6));
							line.add(rs.getString(7));
							line.add(rs.getString(8));
							line.add(rs.getString(9));
							
							result.add(line);
						}
						System.out.println("result"+result.get(0));
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}finally {
						sp.close();
					}
					return result;
					
				}
				public ArrayList<ArrayList<String>> checkSalary(String jobnum,String date){
					String sql;
					String paras1[]={};
					String paras2[]={jobnum};
					String paras3[]={date+"%"};
					String paras4[]={jobnum,date+"%"};
					SqlHelper sp=new SqlHelper();
					ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
					ArrayList<String> line;
					ResultSet rs;
					System.out.println(jobnum+date);
					if(jobnum.equals("")&&date.equals("")){
						System.out.println("paras1");
					sql="SELECT a.`time`,b.`workername`,a.`ordernum`,a.`commoditynum`,a.`commodityname`, "
							+ "d.`size`,d.`color`,c.`category`,a.`processname`,a.`univalent`,a.`quantity`,a.`total`,a .`remarks` "
							+ "FROM daily_production AS a,worker AS "
							+ "b,processnames AS c,commodity AS d "
							+ "WHERE a.`jobnum`=b.`jobnum` AND a.`commoditynum`=d.`commoditynum` "
							+ "AND a.`processname`=c.`processname`;";
					rs=sp.query(sql, paras1);
					}else if(date.equals("")){
						sql="SELECT a.`time`,b.`workername`,a.`ordernum`,a.`commoditynum`,a.`commodityname`, "
								+ "d.`size`,d.`color`,c.`category`,a.`processname`,a.`univalent`,a.`quantity`,a.`total`,a .`remarks` "
								+ "FROM daily_production AS a,worker AS "
								+ "b,processnames AS c,commodity AS d "
								+ "WHERE a.`jobnum`=b.`jobnum` AND a.`commoditynum`=d.`commoditynum` "
								+ "AND a.`processname`=c.`processname`"
								+ "AND a.`jobnum`=?;";
						rs=sp.query(sql, paras2);
					}else if(jobnum.equals("")){
						sql="SELECT a.`time`,b.`workername`,a.`ordernum`,a.`commoditynum`,a.`commodityname`, "
								+ "d.`size`,d.`color`,c.`category`,a.`processname`,a.`univalent`,a.`quantity`,a.`total`,a .`remarks` "
								+ "FROM daily_production AS a,worker AS "
								+ "b,processnames AS c,commodity AS d "
								+ "WHERE a.`jobnum`=b.`jobnum` AND a.`commoditynum`=d.`commoditynum` "
								+ "AND a.`processname`=c.`processname`"
								+ "AND a.`time` like  ? ;";
						rs=sp.query(sql, paras3);
					}else{
						sql="SELECT a.`time`,b.`workername`,a.`ordernum`,a.`commoditynum`,a.`commodityname`, "
								+ "d.`size`,d.`color`,c.`category`,a.`processname`,a.`univalent`,a.`quantity`,a.`total`,a .`remarks` "
								+ "FROM daily_production AS a,worker AS "
								+ "b,processnames AS c,commodity AS d "
								+ "WHERE a.`jobnum`=b.`jobnum` AND a.`commoditynum`=d.`commoditynum` "
								+ "AND a.`processname`=c.`processname`"
								+ "AND a.`jobnum`=?"
								+ "AND a.`time` like  ? ;";
						rs=sp.query(sql, paras4);
					}
                     try {
						
						while(rs.next()){
							line=new ArrayList<>();
							line.add(rs.getString(1));
							line.add(rs.getString(2));
							line.add(rs.getString(3));
							line.add(rs.getString(4));
							line.add(rs.getString(5));
							line.add(rs.getString(6));
							line.add(rs.getString(7));
							line.add(rs.getString(8));
							line.add(rs.getString(9));
							line.add(rs.getString(10));
							line.add(rs.getString(11));
							line.add(rs.getString(12));
							line.add(rs.getString(13));
							result.add(line);
						}
						//System.out.println(result.get(0));
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}finally {
						sp.close();
					}
					return result;
				}
				public ArrayList<ArrayList<String>> checkSalary(String ordernum){
					String sql;
					String paras[]={ordernum};

					SqlHelper sp=new SqlHelper();
					ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
					ArrayList<String> line;
					ResultSet rs;
	

					sql="SELECT a.`time`,b.`workername`,a.`ordernum`,a.`commoditynum`,a.`commodityname`, "
							+ "d.`size`,d.`color`,c.`category`,a.`processname`,a.`univalent`,a.`quantity`,a.`total`,a .`remarks` "
							+ "FROM daily_production AS a,worker AS "
							+ "b,processnames AS c,commodity AS d "
							+ "WHERE a.`jobnum`=b.`jobnum` AND a.`commoditynum`=d.`commoditynum` "
							+ "AND a.`processname`=c.`processname`"
							+ "AND a.`ordernum`=?;";
					rs=sp.query(sql, paras);
					
                     try {
						
						while(rs.next()){
							line=new ArrayList<>();
							line.add(rs.getString(1));
							line.add(rs.getString(2));
							line.add(rs.getString(3));
							line.add(rs.getString(4));
							line.add(rs.getString(5));
							line.add(rs.getString(6));
							line.add(rs.getString(7));
							line.add(rs.getString(8));
							line.add(rs.getString(9));
							line.add(rs.getString(10));
							line.add(rs.getString(11));
							line.add(rs.getString(12));
							line.add(rs.getString(13));
							result.add(line);
						}
						//System.out.println(result.get(0));
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}finally {
						sp.close();
					}
					return result;
				}
				public  void update(String sql) {
				String paras[]={};
				SqlHelper sp=new SqlHelper();
				sp.query2(sql, paras);
			
					
				
				}
				
				

			

}
