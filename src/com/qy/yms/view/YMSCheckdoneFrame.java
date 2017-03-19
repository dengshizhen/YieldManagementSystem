package com.qy.yms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.qy.yms.server.YMSCheckMagener;
import com.qy.yms.server.YMSLookupInfo;
import com.qy.yms.tools.ExportExcel;

public class YMSCheckdoneFrame extends JFrame implements ActionListener {
	JPanel jp1,jp2,jp3;
	JScrollPane jsp;
	JLabel jlb1,jlb2,jlb3,jlb4,jlb5;
	JComboBox<String> jcb;
	JButton jb1,jb2;
	ButtonGroup buttonGroup;
	JRadioButton jrb1,jrb2,jrb3;
	JTable jTable;
	DefaultTableModel dm;
	String[] items={"������","��Ʒ���","Ʒ��","�ߴ�","��ɫ","�ƻ�����","����","����","�����"};
	YMSLookupInfo ymsLookupInfo;
	YMSCheckMagener ymsCheckMagener;
	ExportExcel exp;
	ImageIcon qiyao;
	public YMSCheckdoneFrame() {
		// TODO �Զ����ɵĹ��캯�����
		/**
		 * ʵ�ָ����������ɱ�����
		 */
		//��������˾ͼ�꼰��Ԫ����
		jp1=new JPanel(null);
		jp1.setPreferredSize(new Dimension(600, 120));
		jlb1=new JLabel();
		qiyao=new ImageIcon(YMSAddFrame.class.getResource("qiyao.png"));
		jlb1.setIcon(qiyao);
		jlb1.setBounds(0, 0, 115, 114);
		jlb2=new JLabel("�鿴����");
		jlb2.setFont(new Font("����", Font.BOLD, 36));
		jlb2.setBounds(605, 35, 400, 50);
		jlb3=new JLabel("_______________________________________________________________________"
				+ "_________________________________________________________________________________________________"
				+ "__________________________________________________________________________________________________");
		jlb3.setForeground(Color.black);
		jlb3.setBounds(0, 100, 1600, 20);
		jp1.add(jlb1);
		jp1.add(jlb2);
		jp1.add(jlb3);
		
		//�в�������ѡ��
		jp2=new JPanel(null);
		jp2.setPreferredSize(new Dimension(600,80));
		jrb1=new JRadioButton("ȫ��");
		jrb2=new JRadioButton("���");
		jrb3=new JRadioButton("����");
		jrb1.addActionListener(this);
		jrb2.addActionListener(this);
		jrb3.addActionListener(this);
		jrb1.setActionCommand("ȫ��");
		jrb2.setActionCommand("���");
		jrb3.setActionCommand("����");
		buttonGroup=new ButtonGroup();
		buttonGroup.add(jrb1);
		buttonGroup.add(jrb2);
		buttonGroup.add(jrb3);
		jlb4=new JLabel("������");
		jcb=new JComboBox<>();
		/*jcb.setEditable(true);*/
		jcb.addActionListener(this);
		jcb.setActionCommand("������");
		jcb.addItem("");
		jb1=new JButton("�鿴");
		jb1.addActionListener(this);
		jb1.setActionCommand("�鿴");
		jrb1.setBounds(400,0,  100, 30);
		jrb2.setBounds(500,0,  100, 30);
		jrb3.setBounds(600,0,  100, 30);
		jlb4.setBounds(700, 0, 100, 30);
		jcb.setBounds(770,0,  100, 30);
		jb1.setBounds( 880,0,100, 30);
		jrb1.setFont(new Font("����", Font.BOLD, 20));
		jrb2.setFont(new Font("����", Font.BOLD, 20));
		jrb3.setFont(new Font("����", Font.BOLD, 20));
		jlb4.setFont(new Font("����", Font.BOLD, 20));
		jb1.setFont(new Font("����", Font.BOLD, 20));
		jp2.add(jrb1);
		jp2.add(jrb2);
		jp2.add(jrb3);
		jp2.add(jlb4);
		jp2.add(jcb);
		jp2.add(jb1);
		
		
		//�ϲ������
		jp3=new JPanel(new BorderLayout());
		jlb5=new JLabel("____________________________________________________________________________"
				+ "________________________________________________________________________________________________"
				+ "_____________________________________________________________________________________________");
		jlb5.setForeground(Color.BLACK);
		jlb5.setBounds(0, 0, 1600, 20);
		jb2=new JButton("���ΪExcel");
		jb2.setFont(new Font("����", Font.BOLD, 20));
		jb2.addActionListener(this);
		jb2.setActionCommand("���");
		jsp=new JScrollPane();
		jsp.setPreferredSize(new Dimension(1600, 560));
		dm=new DefaultTableModel(null, items);
		jTable=new JTable(dm);
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();     
        r.setHorizontalAlignment(JLabel.CENTER);     
        jTable.setDefaultRenderer(Object.class, r);  
        jsp.setViewportView(jTable); 
		jp3.add(jlb5,BorderLayout.NORTH);
		jp3.add(jsp,BorderLayout.CENTER);
		jp3.add(jb2,BorderLayout.SOUTH);
		this.setSize(1600, 800);
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		switch (e.getActionCommand()) {
		case "�鿴":
			ymsCheckMagener=new YMSCheckMagener();
			addTable(ymsCheckMagener.checkDone(true, jcb.getSelectedItem().toString()));
			jcb.removeAllItems();
			jcb.addItem("");
			buttonGroup.clearSelection();
			break;
		case "���":
			  try {
                  exp = new ExportExcel();
                  exp.exportTable(jTable, new File("order"
                  +new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��").format(new Date())
                  +".xls"));
              } catch (IOException ex) {
                  System.out.println(ex.getMessage());
                  ex.printStackTrace();
              }
			  SuccessFrame successFrame1=new SuccessFrame(this, true);
			break;
		case "ȫ��":
			ymsCheckMagener=new YMSCheckMagener();
			System.out.println("���"+jcb.getSelectedItem().toString());
			System.out.println("���"+jrb1.isSelected());
		addTable(ymsCheckMagener.checkDone(jrb1.isSelected(), jcb.getSelectedItem().toString()));
			break;
		case "���":
			ymsCheckMagener=new YMSCheckMagener();
			addTable(ymsCheckMagener.checkDone(jrb1.isSelected(), jcb.getSelectedItem().toString()));
			break;
		case "����":
			jcb.removeAllItems();
			addorder(jcb);
			break;
			
		default:
		
			break;
		}
		
	}
	private void addTable(ArrayList<ArrayList<String>> checkDone) {
		// TODO �Զ����ɵķ������
		if(checkDone.size()==0){
			
		}
		 Object [][] data=new Object[checkDone.size()][checkDone.get(0).size()];
	        jsp.setViewportView(jTable); 
			for(int i=0;i<checkDone.size();i++){
				for(int j=0;j<checkDone.get(i).size();j++){
					data[i][j]=(checkDone.get(i).get(j));
				}
				
			}
		jTable=new JTable(data,items);
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();     
        r.setHorizontalAlignment(JLabel.CENTER);     
        jTable.setDefaultRenderer(Object.class, r);  
        jsp.setViewportView(jTable); 
		
	}
	private void addorder(JComboBox<String> jcb) {
		// TODO �Զ����ɵķ������
		ArrayList<String> order=null;
		 ymsLookupInfo=new YMSLookupInfo();
		 order=ymsLookupInfo.lookupOrder();
	        for(int i=0;i<order.size();i++){
	        	jcb.addItem(order.get(i));
	        }
	    	
	}

}
