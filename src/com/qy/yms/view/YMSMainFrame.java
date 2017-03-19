package com.qy.yms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javafx.scene.image.Image;

public class YMSMainFrame extends javax.swing.JFrame implements ActionListener{

	/**
	 * 主界面,设定需要部件
	 * @throws HeadlessException
	 */
	JPanel jp1,jp2,jp22,jp3;
	JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	URL url;
	ImageIcon qiyao;
	String title;
	public YMSMainFrame(String name)  {
		// TODO 自动生成的构造函数存根
		/**
		 * 实现各个部件，由北至南
		 */
		//北部：公司图标及程序名称
		jp1=new JPanel(null);
		jp1.setPreferredSize(new Dimension(600, 150));
		jlb1=new JLabel();
		qiyao=new ImageIcon(YMSAddFrame.class.getResource("qiyao.png"));
		jlb1.setIcon(qiyao);
		jlb1.setBounds(0, 0, 115, 114);
		jlb2=new JLabel("产量管理系统");
		jlb2.setFont(new Font("宋体", Font.BOLD, 36));
		jlb2.setBounds(175, 35, 400, 50);
		jlb4=new JLabel("_____________________________________________________________________________________");
		jlb4.setForeground(Color.black);
		jlb4.setBounds(0, 100, 600, 20);
		jp1.add(jlb1);
		jp1.add(jlb2);
		jp1.add(jlb4);
		
		//中部：六大按钮
		jp22=new JPanel(new BorderLayout());
		jp2=new JPanel(new GridLayout(3, 2,100,100));
		jp2.setPreferredSize(new Dimension(450,500));
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
		
		jb1=new JButton("增改订单");
		jb1.setFont(new Font("宋体", Font.BOLD, 25));
		jb1.addActionListener(this);
		jb1.setActionCommand("add");

		jb2=new JButton("生产日报");
		jb2.setFont(new Font("宋体", Font.BOLD, 25));
		jb2.addActionListener(this);
		jb2.setActionCommand("meneger");
	
		jb3=new JButton("工人管理");
		jb3.setFont(new Font("宋体", Font.BOLD, 25));
		jb3.addActionListener(this);
		jb3.setActionCommand("worker");

		jb4=new JButton("查看订单");
		jb4.setFont(new Font("宋体", Font.BOLD, 25));
		jb4.addActionListener(this);
		jb4.setActionCommand("checkdone");

		jb5=new JButton("查看工资明细");
		jb5.setFont(new Font("宋体", Font.BOLD, 25));
		jb5.addActionListener(this);
		jb5.setActionCommand("checksalary");
	
		jb6=new JButton("帮助和说明");
		jb6.setFont(new Font("宋体", Font.BOLD, 25));
		jb6.addActionListener(this);
		jb6.setActionCommand("help");
		
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(jb6);
		jp22.add(jp2,BorderLayout.CENTER);
		jp22.add(new JLabel("         "),BorderLayout.WEST);
		jp22.add(new JLabel("         "),BorderLayout.EAST);
		
		//南部：作者信息，日期，电话
		jp3=new JPanel(new GridLayout(3, 1));
		jp3.setPreferredSize(new Dimension(600,150));
		jlb3=new JLabel("                     杭州琪瑶纺织有限公司");
		jlb3.setFont(new Font("宋体", Font.BOLD, 15));
	
		
		jlb5=new JLabel("___________________________________________________________________________________________________");
		jlb5.setForeground(Color.black);
	
		
		jlb6=new JLabel("             版权所有，违者必究      备案号@ICP20170228");
		jlb6.setFont(new Font("宋体", Font.BOLD, 15));

		
		jp3.add(jlb5);
	    jp3.add(jlb3);
	    jp3.add(jlb6);
		
	    title="产量管理系统"+name;
	    this.setTitle(title);
		this.setSize(600, 800);
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp22,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		switch (e.getActionCommand()) {
		case "add":
			//this.setVisible(false);
			YMSAddFrame addFrame=new YMSAddFrame();
			
			break;
        case "meneger":
			YMSMenegerFrame ymsMenegerFrame=new YMSMenegerFrame();
			break;
        case "worker":
        	YMSWorkerFrame ymsWorkerFrame=new YMSWorkerFrame();
	
	        break;
        case "checkdone":
        	YMSCheckdoneFrame ymsCheckdoneFrame=new YMSCheckdoneFrame();
	
	        break;
        case "checksalary":
        	YMSSalaryFrame ymsSalaryFrame=new YMSSalaryFrame();
	
	        break;
        case "help":
        	File dir=new File(".");
        	try {
				System.out.println(dir.getCanonicalPath());
			} catch (IOException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			}
        	try {
				Desktop.getDesktop().open(new File(dir.getCanonicalPath()+"/Information.docx"));
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
	        break;

		default:
			break;
		}
		
	}

}
