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
	 * ������,�趨��Ҫ����
	 * @throws HeadlessException
	 */
	JPanel jp1,jp2,jp22,jp3;
	JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	URL url;
	ImageIcon qiyao;
	String title;
	public YMSMainFrame(String name)  {
		// TODO �Զ����ɵĹ��캯�����
		/**
		 * ʵ�ָ����������ɱ�����
		 */
		//��������˾ͼ�꼰��������
		jp1=new JPanel(null);
		jp1.setPreferredSize(new Dimension(600, 150));
		jlb1=new JLabel();
		qiyao=new ImageIcon(YMSAddFrame.class.getResource("qiyao.png"));
		jlb1.setIcon(qiyao);
		jlb1.setBounds(0, 0, 115, 114);
		jlb2=new JLabel("��������ϵͳ");
		jlb2.setFont(new Font("����", Font.BOLD, 36));
		jlb2.setBounds(175, 35, 400, 50);
		jlb4=new JLabel("_____________________________________________________________________________________");
		jlb4.setForeground(Color.black);
		jlb4.setBounds(0, 100, 600, 20);
		jp1.add(jlb1);
		jp1.add(jlb2);
		jp1.add(jlb4);
		
		//�в�������ť
		jp22=new JPanel(new BorderLayout());
		jp2=new JPanel(new GridLayout(3, 2,100,100));
		jp2.setPreferredSize(new Dimension(450,500));
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} 
		
		jb1=new JButton("���Ķ���");
		jb1.setFont(new Font("����", Font.BOLD, 25));
		jb1.addActionListener(this);
		jb1.setActionCommand("add");

		jb2=new JButton("�����ձ�");
		jb2.setFont(new Font("����", Font.BOLD, 25));
		jb2.addActionListener(this);
		jb2.setActionCommand("meneger");
	
		jb3=new JButton("���˹���");
		jb3.setFont(new Font("����", Font.BOLD, 25));
		jb3.addActionListener(this);
		jb3.setActionCommand("worker");

		jb4=new JButton("�鿴����");
		jb4.setFont(new Font("����", Font.BOLD, 25));
		jb4.addActionListener(this);
		jb4.setActionCommand("checkdone");

		jb5=new JButton("�鿴������ϸ");
		jb5.setFont(new Font("����", Font.BOLD, 25));
		jb5.addActionListener(this);
		jb5.setActionCommand("checksalary");
	
		jb6=new JButton("������˵��");
		jb6.setFont(new Font("����", Font.BOLD, 25));
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
		
		//�ϲ���������Ϣ�����ڣ��绰
		jp3=new JPanel(new GridLayout(3, 1));
		jp3.setPreferredSize(new Dimension(600,150));
		jlb3=new JLabel("                     ����������֯���޹�˾");
		jlb3.setFont(new Font("����", Font.BOLD, 15));
	
		
		jlb5=new JLabel("___________________________________________________________________________________________________");
		jlb5.setForeground(Color.black);
	
		
		jlb6=new JLabel("             ��Ȩ���У�Υ�߱ؾ�      ������@ICP20170228");
		jlb6.setFont(new Font("����", Font.BOLD, 15));

		
		jp3.add(jlb5);
	    jp3.add(jlb3);
	    jp3.add(jlb6);
		
	    title="��������ϵͳ"+name;
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
		// TODO �Զ����ɵķ������
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
				// TODO �Զ����ɵ� catch ��
				e2.printStackTrace();
			}
        	try {
				Desktop.getDesktop().open(new File(dir.getCanonicalPath()+"/Information.docx"));
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
	        break;

		default:
			break;
		}
		
	}

}
