package com.qy.yms.dao;
/*
 * �����ݿ��������
 * crud
 * ���ô洢����
 */

import java.util.*;
import java.sql.*;

/**
 * ���ݿ⹤�ߣ���ɾ�Ĳ�
 * @author ��ʫ��
 * ʱ�䣺2016/5/19
 *
 */
public class SqlHelper {
	//������Ҫ�Ķ���
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//192.168.2.72
	String dirverName="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://192.168.2.72:3306/yms?&useSSL=true";
	String user="qyroot";
	String passwd="qyroot";
	//���캯��
	public SqlHelper(){
		
		try {
			Class.forName(dirverName);
			ct=DriverManager.getConnection(url,user,passwd);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	public ResultSet query(String sql,String []paras){
	try {
		ps=ct.prepareStatement(sql);
		//��sql�Ĳ�����ֵ
		for(int i=0;i<paras.length;i++){
			ps.setString(i+1, paras[i]);
		}
		rs=ps.executeQuery();
	} catch (Exception e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	return rs;
	
	}		
		
	public void query2(String sql,String []paras){
		try {
			ps=ct.prepareStatement(sql);
			//��sql�Ĳ�����ֵ
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		}
	public void close(){
		
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(ct!=null)ct.close();
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	}

}
