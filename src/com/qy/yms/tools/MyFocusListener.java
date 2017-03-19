package com.qy.yms.tools;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

	public class MyFocusListener implements FocusListener{

		String info;
		JTextField jtf;
		public  MyFocusListener(String info,JTextField jtf) {
			// TODO 自动生成的构造函数存根
			this.info=info;
			this.jtf=jtf;
		}
		@Override
		public void focusGained(FocusEvent e) {//获得焦点的时候,清空提示文字
			// TODO 自动生成的方法存根
			String temp = jtf.getText();
	        if(temp.equals(info)){
	            jtf.setText("");
	        }
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO 自动生成的方法存根
			//失去焦点的时候,判断如果为空,就显示提示文字
	        String temp = jtf.getText();
	        if(temp.equals("")){
	            jtf.setText(info);
	        }else{
	        	jtf.setForeground(Color.black);
	        }
		}
		
	}


