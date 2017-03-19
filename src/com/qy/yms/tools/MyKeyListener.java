package com.qy.yms.tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class MyKeyListener implements KeyListener {

	double univalent;
	 String temp="";
	 double s=1;
     boolean flag=false;
	 public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	double total;

	JLabel jLabel;
	public MyKeyListener(Double univalent,JLabel jLabel) {
		// TODO 自动生成的构造函数存根
		this.univalent=univalent;
		
		this.jLabel=jLabel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		if(flag){
			temp="";
			System.out.println("flagwork");
		}
		if(e.getKeyChar()=='-'){
			s=-1;
		}
		if(
				e.getKeyChar()=='1'||
				e.getKeyChar()=='2'||
				e.getKeyChar()=='3'||
				e.getKeyChar()=='4'||
				e.getKeyChar()=='5'||
				e.getKeyChar()=='6'||
				e.getKeyChar()=='7'||
				e.getKeyChar()=='8'||
				e.getKeyChar()=='9'||
				e.getKeyChar()=='0'
				){
			temp+=e.getKeyChar();
	}else if(temp.equals("")||temp.equals(null)){
	}else{
		temp=temp.substring(0, temp.length()-1);
	}
		System.out.println("temp"+temp);
		System.out.println("univalent"+univalent);
		
		if(!(temp.equals("")||temp.equals(null)))
			{
			total=s*univalent*Integer.valueOf(temp);
			BigDecimal   b   =   new   BigDecimal(total); 
			double   f1   =   b.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println("f1"+f1);
			jLabel.setText(String.valueOf(f1));
			}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

}
