package com.qy.yms.dao;
/*
 * 对数据库操作的类
 * crud
 * 调用存储过程
 */

import java.util.*;
import java.sql.*;

/**
 * 数据库工具，增删改查
 * @author 邓诗祯
 * 时间：2016/5/19
 *
 */
public class SqlHelper {
	//定义需要的对象
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//192.168.2.72
	String dirverName="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://192.168.2.72:3306/yms?&useSSL=true";
	String user="qyroot";
	String passwd="qyroot";
	//构造函数
	public SqlHelper(){
		
		try {
			Class.forName(dirverName);
			ct=DriverManager.getConnection(url,user,passwd);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public ResultSet query(String sql,String []paras){
	try {
		ps=ct.prepareStatement(sql);
		//对sql的参数赋值
		for(int i=0;i<paras.length;i++){
			ps.setString(i+1, paras[i]);
		}
		rs=ps.executeQuery();
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return rs;
	
	}		
		
	public void query2(String sql,String []paras){
		try {
			ps=ct.prepareStatement(sql);
			//对sql的参数赋值
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		}
	public void close(){
		
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(ct!=null)ct.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}

}
