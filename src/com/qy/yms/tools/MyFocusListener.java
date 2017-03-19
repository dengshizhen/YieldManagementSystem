package com.qy.yms.tools;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

	public class MyFocusListener implements FocusListener{

		String info;
		JTextField jtf;
		public  MyFocusListener(String info,JTextField jtf) {
			// TODO �Զ����ɵĹ��캯�����
			this.info=info;
			this.jtf=jtf;
		}
		@Override
		public void focusGained(FocusEvent e) {//��ý����ʱ��,�����ʾ����
			// TODO �Զ����ɵķ������
			String temp = jtf.getText();
	        if(temp.equals(info)){
	            jtf.setText("");
	        }
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO �Զ����ɵķ������
			//ʧȥ�����ʱ��,�ж����Ϊ��,����ʾ��ʾ����
	        String temp = jtf.getText();
	        if(temp.equals("")){
	            jtf.setText(info);
	        }else{
	        	jtf.setForeground(Color.black);
	        }
		}
		
	}


