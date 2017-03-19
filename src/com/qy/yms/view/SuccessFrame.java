package com.qy.yms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SuccessFrame extends JDialog implements ActionListener{

	JPanel jp1;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	JDialog jDialog;
	public SuccessFrame(JFrame owner,boolean modal) throws HeadlessException {
		// TODO 自动生成的构造函数存根
		jDialog=new JDialog(owner, "check", modal);
		jp1=new JPanel(null);
		jlb1=new JLabel("您的提交已成功");
		jlb2=new JLabel("若需修改，请重新添加");
		jb1=new JButton("返回");
		jb1.addActionListener(this);
		jb1.setActionCommand("返回");
		jb2=new JButton("确认");
		jb2.addActionListener(this);
		jb2.setActionCommand("确认");
		jlb1.setBounds(0, 0, 300, 30);
		jlb2.setBounds(0, 30, 300, 30);
		jb1.setBounds(20, 180, 100, 30);
		jb2.setBounds(220, 180, 100, 30);
		jlb1.setFont(new Font("宋体", Font.BOLD, 20));
		jlb2.setFont(new Font("宋体", Font.BOLD, 20));
		jb1.setFont(new Font("宋体", Font.BOLD, 20));
		jb2.setFont(new Font("宋体", Font.BOLD, 20));
		jlb1.setForeground(Color.black);
		jlb2.setForeground(Color.black);
		jp1.add(jlb1);
		jp1.add(jlb2);
		jp1.add(jb1);
		jp1.add(jb2);
		
		jDialog.setSize(320, 150);
		jDialog.setLocation(120, 500);
		jDialog.add(jp1);
		jDialog.setVisible(true);
		jDialog.setAlwaysOnTop(true);
		jDialog.setModal(true);
		jDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
       if("返回".equals(e.getActionCommand())){
    	   jDialog.dispose();
		}
		if("确认".equals(e.getActionCommand())){
			
		}
		
	}

}
