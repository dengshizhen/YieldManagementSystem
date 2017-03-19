package com.qy.yms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import com.qy.yms.server.YMSLookupInfo;
import com.qy.yms.server.YMSWorkerManeger;

public class YMSWorkerFrame extends JFrame implements ActionListener {

	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlb8,jlb9,jlb10,jlb11;
	JTextField jt1,jt2;
	JComboBox<String> jcb;
	JButton jb1,jb2;
	YMSLookupInfo ymsLookupInfo;
	YMSWorkerManeger ymsWorkerManeger;
	ImageIcon qiyao;
	public YMSWorkerFrame() {
		/**
		 * 实现各个部件，由北至南
		 */
		//北部：公司图标及单元名称
		jp1=new JPanel(null);
		jp1.setPreferredSize(new Dimension(600, 120));
		jlb1=new JLabel();
		qiyao=new ImageIcon(YMSAddFrame.class.getResource("qiyao.png"));
		jlb1.setIcon(qiyao);
		jlb1.setBounds(0, 0, 115, 114);
		jlb2=new JLabel("工人管理");
		jlb2.setFont(new Font("宋体", Font.BOLD, 36));
		jlb2.setBounds(225, 35, 400, 50);
		jlb3=new JLabel("___________________________________________________________________________________________________");
		jlb3.setForeground(Color.black);
		jlb3.setBounds(0, 100, 600, 20);
		jp1.add(jlb1);
		jp1.add(jlb2);
		jp1.add(jlb3);
		
		//中部：各个选项
		jp2=new JPanel(null);
		jp2.setPreferredSize(new Dimension(450,130));
		jlb4=new JLabel("添加");
		jlb5=new JLabel("工人工号");
		jlb6=new JLabel("   姓名");
		jt1=new JTextField();
		jt2=new JTextField();
		jb1=new JButton("确认添加");
		jb1.addActionListener(this);
		jb1.setActionCommand("确认添加");
		jlb4.setBounds(20, 10, 100, 30);
		jlb5.setBounds(20, 50, 100, 30);
		jlb6.setBounds(220, 50, 100, 30);
		jt1.setBounds(120, 50, 100, 30);
		jt2.setBounds(320, 50, 100, 30);
		jb1.setBounds(450, 50, 120, 30);
		jlb4.setFont(new Font("宋体", Font.BOLD, 20));
		jlb5.setFont(new Font("宋体", Font.BOLD, 20));
		jlb6.setFont(new Font("宋体", Font.BOLD, 20));
		jt1.setFont(new Font("宋体", Font.BOLD, 20));
		jt2.setFont(new Font("宋体", Font.BOLD, 20));
		jb1.setFont(new Font("宋体", Font.BOLD, 20));
		jp2.add(jlb4);
		jp2.add(jlb5);
		jp2.add(jlb6);
		jp2.add(jt1);
		jp2.add(jt2);
		jp2.add(jb1);
		
		//南部：各个选项
		jp3=new JPanel(null);
		jp3.setPreferredSize(new Dimension(450,150));
		jlb11=new JLabel("___________________________________________________________________________________________________");
		jlb11.setForeground(Color.black);
		jlb11.setBounds(0, 0, 600, 20);
		jlb7=new JLabel("删除");
		jlb8=new JLabel("工人工号");
		jlb9=new JLabel("姓名");
		jlb10=new JLabel("     ");
		jlb10.setBorder(new BevelBorder(BevelBorder.LOWERED));
		jcb=new JComboBox<>();
	/*	jcb.setEditable(true);*/
		jcb.addActionListener(this);
		jcb.setActionCommand("工人工号");
		addBoxItem(jcb);
		jb2=new JButton("确认删除");
		jb2.addActionListener(this);
		jb2.setActionCommand("确认删除");
		jlb7.setBounds(20, 30, 130, 30);
		jlb8.setBounds(20, 70, 130, 30);
		jlb9.setBounds(280, 70, 130, 30);
		jcb.setBounds(110, 70, 160, 30);
		jlb10.setBounds(320, 70, 60, 30);
		jb2.setBounds(400, 70, 120, 30);
		jlb7.setFont(new Font("宋体", Font.BOLD, 20));
		jlb8.setFont(new Font("宋体", Font.BOLD, 20));
		jlb9.setFont(new Font("宋体", Font.BOLD, 20));
		jcb.setFont(new Font("宋体", Font.BOLD, 20));
		jlb10.setFont(new Font("宋体", Font.BOLD, 20));
		jb2.setFont(new Font("宋体", Font.BOLD, 20));
		jp3.add(jlb7);
		jp3.add(jlb8);
		/*jp3.add(jlb9);*/
		jp3.add(jcb);
		/*jp3.add(jlb10);*/
		jp3.add(jb2);
		jp3.add(jlb11);
		
		this.setSize(600,400);
		this.setLocation(0, 170);
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);
	}
	
	private void addBoxItem(JComboBox<String> jcb) {
		// TODO 自动生成的方法存根
		ArrayList<String> category=null;
        ymsLookupInfo=new YMSLookupInfo();
        category=ymsLookupInfo.lookupWorNumName();
        for(int i=0;i<category.size();i++){
        	jcb.addItem(category.get(i));
        }
		
	}

	private void refreshFrame() {
		// TODO 自动生成的方法存根
		YMSWorkerFrame ymsWorkerFrame=new YMSWorkerFrame();
		this.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String jobnum="";
		String name="";
		switch (e.getActionCommand()) {
		case "工人工号":
			ymsLookupInfo=new YMSLookupInfo();
			jlb10.setText(ymsLookupInfo.lookupWorName().get(jcb.getSelectedIndex()));
			break;
		case "确认添加":
			if(jt1.getText().equals("")||
					jt2.equals("")){
				WrongFrame wrongFrame=new WrongFrame(this, true);
			}else {
				MakeSureFrame makeSureFrame=new MakeSureFrame(this,true);
				if(makeSureFrame.flag){
				jobnum =jt1.getText();
				name=jt2.getText();
				ymsWorkerManeger=new YMSWorkerManeger();
				ymsWorkerManeger.addWorker(jobnum, name);
				refreshFrame();
				SuccessFrame successFrame1=new SuccessFrame(this, true);
				}
	
			}
			
			break;
		case "确认删除":
		if(jcb.getSelectedItem().toString().equals("")){
			
		WrongFrame wrongFrame=new WrongFrame(this, true);
		}else {
			MakeSureFrame makeSureFrame2=new MakeSureFrame(this,true);
			if(makeSureFrame2.flag){
            ymsLookupInfo=new YMSLookupInfo();
            ymsWorkerManeger=new YMSWorkerManeger();
            jobnum=ymsLookupInfo.lookupWorNum().get(jcb.getSelectedIndex());;
            ymsWorkerManeger.deletWorker(jobnum);
			
			refreshFrame();
			SuccessFrame successFrame2=new SuccessFrame(this, true);
			}
		}
			break;

		default:
			break;
		}

	}

}
