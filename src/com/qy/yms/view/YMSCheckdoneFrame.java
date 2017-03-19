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
	String[] items={"订单号","产品编号","品名","尺寸","颜色","计划产量","分类","工序","完成数"};
	YMSLookupInfo ymsLookupInfo;
	YMSCheckMagener ymsCheckMagener;
	ExportExcel exp;
	ImageIcon qiyao;
	public YMSCheckdoneFrame() {
		// TODO 自动生成的构造函数存根
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
		jlb2=new JLabel("查看订单");
		jlb2.setFont(new Font("宋体", Font.BOLD, 36));
		jlb2.setBounds(605, 35, 400, 50);
		jlb3=new JLabel("_______________________________________________________________________"
				+ "_________________________________________________________________________________________________"
				+ "__________________________________________________________________________________________________");
		jlb3.setForeground(Color.black);
		jlb3.setBounds(0, 100, 1600, 20);
		jp1.add(jlb1);
		jp1.add(jlb2);
		jp1.add(jlb3);
		
		//中部：各个选项
		jp2=new JPanel(null);
		jp2.setPreferredSize(new Dimension(600,80));
		jrb1=new JRadioButton("全部");
		jrb2=new JRadioButton("完结");
		jrb3=new JRadioButton("单个");
		jrb1.addActionListener(this);
		jrb2.addActionListener(this);
		jrb3.addActionListener(this);
		jrb1.setActionCommand("全部");
		jrb2.setActionCommand("完结");
		jrb3.setActionCommand("单个");
		buttonGroup=new ButtonGroup();
		buttonGroup.add(jrb1);
		buttonGroup.add(jrb2);
		buttonGroup.add(jrb3);
		jlb4=new JLabel("订单号");
		jcb=new JComboBox<>();
		/*jcb.setEditable(true);*/
		jcb.addActionListener(this);
		jcb.setActionCommand("订单号");
		jcb.addItem("");
		jb1=new JButton("查看");
		jb1.addActionListener(this);
		jb1.setActionCommand("查看");
		jrb1.setBounds(400,0,  100, 30);
		jrb2.setBounds(500,0,  100, 30);
		jrb3.setBounds(600,0,  100, 30);
		jlb4.setBounds(700, 0, 100, 30);
		jcb.setBounds(770,0,  100, 30);
		jb1.setBounds( 880,0,100, 30);
		jrb1.setFont(new Font("宋体", Font.BOLD, 20));
		jrb2.setFont(new Font("宋体", Font.BOLD, 20));
		jrb3.setFont(new Font("宋体", Font.BOLD, 20));
		jlb4.setFont(new Font("宋体", Font.BOLD, 20));
		jb1.setFont(new Font("宋体", Font.BOLD, 20));
		jp2.add(jrb1);
		jp2.add(jrb2);
		jp2.add(jrb3);
		jp2.add(jlb4);
		jp2.add(jcb);
		jp2.add(jb1);
		
		
		//南部：表格
		jp3=new JPanel(new BorderLayout());
		jlb5=new JLabel("____________________________________________________________________________"
				+ "________________________________________________________________________________________________"
				+ "_____________________________________________________________________________________________");
		jlb5.setForeground(Color.BLACK);
		jlb5.setBounds(0, 0, 1600, 20);
		jb2=new JButton("输出为Excel");
		jb2.setFont(new Font("宋体", Font.BOLD, 20));
		jb2.addActionListener(this);
		jb2.setActionCommand("输出");
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
		// TODO 自动生成的方法存根
		switch (e.getActionCommand()) {
		case "查看":
			ymsCheckMagener=new YMSCheckMagener();
			addTable(ymsCheckMagener.checkDone(true, jcb.getSelectedItem().toString()));
			jcb.removeAllItems();
			jcb.addItem("");
			buttonGroup.clearSelection();
			break;
		case "输出":
			  try {
                  exp = new ExportExcel();
                  exp.exportTable(jTable, new File("order"
                  +new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date())
                  +".xls"));
              } catch (IOException ex) {
                  System.out.println(ex.getMessage());
                  ex.printStackTrace();
              }
			  SuccessFrame successFrame1=new SuccessFrame(this, true);
			break;
		case "全部":
			ymsCheckMagener=new YMSCheckMagener();
			System.out.println("这个"+jcb.getSelectedItem().toString());
			System.out.println("这个"+jrb1.isSelected());
		addTable(ymsCheckMagener.checkDone(jrb1.isSelected(), jcb.getSelectedItem().toString()));
			break;
		case "完结":
			ymsCheckMagener=new YMSCheckMagener();
			addTable(ymsCheckMagener.checkDone(jrb1.isSelected(), jcb.getSelectedItem().toString()));
			break;
		case "单个":
			jcb.removeAllItems();
			addorder(jcb);
			break;
			
		default:
		
			break;
		}
		
	}
	private void addTable(ArrayList<ArrayList<String>> checkDone) {
		// TODO 自动生成的方法存根
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
		// TODO 自动生成的方法存根
		ArrayList<String> order=null;
		 ymsLookupInfo=new YMSLookupInfo();
		 order=ymsLookupInfo.lookupOrder();
	        for(int i=0;i<order.size();i++){
	        	jcb.addItem(order.get(i));
	        }
	    	
	}

}
