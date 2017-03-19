package com.qy.yms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.jar.Attributes.Name;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.qy.yms.server.YMSLookupInfo;
import com.qy.yms.server.YMSSalaryManeger;
import com.qy.yms.tools.ExportExcel;

public class YMSSalaryFrame extends JFrame implements ActionListener {

	JPanel jp1,jp2,jp3;
	JScrollPane jsp;
	JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7;
	JComboBox<String> jcb,jcb2,jcb3;
	JButton jb1,jb2;
	JTable jTable;
	DefaultTableModel dm;
	String[] items={"日期","工人姓名","订单号","产品编号","品名","尺寸","颜色","分类","工序","单价","数量","总价","备注"};

	YMSLookupInfo ymsLookupInfo;
	YMSSalaryManeger ymsSalaryManeger;
	ExportExcel exp;
	ImageIcon qiyao;
	public YMSSalaryFrame() throws HeadlessException {
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
		jlb2=new JLabel("查看工资明细");
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
		jlb6=new JLabel("工人姓名");
		jcb2=new JComboBox<>();
		/*jcb2.setEditable(true);*/
		jcb2.addActionListener(this);
		jcb2.setActionCommand("工人姓名");
		jcb2.addItem("");
		addWorker(jcb2);
		jlb4=new JLabel("月份");
		jcb=new JComboBox<>();
		/*jcb.setEditable(true);*/
		jcb.addActionListener(this);
		jcb.setActionCommand("月份");
		jcb.addItem("");
		jcb.addItem("01");
		jcb.addItem("02");
		jcb.addItem("03");
		jcb.addItem("04");
		jcb.addItem("05");
		jcb.addItem("06");
		jcb.addItem("07");
		jcb.addItem("08");
		jcb.addItem("09");
		jcb.addItem("10");
		jcb.addItem("11");
		jcb.addItem("12");
		jlb7=new JLabel("订单号");
		jcb3=new JComboBox<>();
		jcb3.addItem("");
		addOrder(jcb3);
		jb1=new JButton("查看");
		jb1.addActionListener(this);
		jb1.setActionCommand("查看");
		jlb6.setBounds(400,0,  100, 30);
		jcb2.setBounds(500,0,  100, 30);
		jlb4.setBounds(620, 0, 100, 30);
		jcb.setBounds(670,0,  100, 30);
		jlb7.setBounds(780, 0, 100, 30);
		jcb3.setBounds(850,0,  100, 30);
		jb1.setBounds( 1200,0,100, 30);
		jlb6.setFont(new Font("宋体", Font.BOLD, 20));
		jcb2.setFont(new Font("宋体", Font.BOLD, 20));
		jlb7.setFont(new Font("宋体", Font.BOLD, 20));
		jcb3.setFont(new Font("宋体", Font.BOLD, 20));
		jlb4.setFont(new Font("宋体", Font.BOLD, 20));
		jb1.setFont(new Font("宋体", Font.BOLD, 20));
		jp2.add(jlb6);
		jp2.add(jcb2);
		jp2.add(jlb4);
		jp2.add(jcb);
		jp2.add(jlb7);
		jp2.add(jcb3);
		jp2.add(jb1);
		
		
		//南部：表格
		jp3=new JPanel(new BorderLayout());
		jlb5=new JLabel("_______________________________________________________________________"
				+ "_____________________________________________________________________________________________"
				+ "_____________________________________________________________________________________________________");
		jlb5.setForeground(Color.black);
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
	//添加工人姓名下拉框
		public void addWorker(JComboBox<String> jcb){
			ArrayList<String> worker=null;
			 ymsLookupInfo=new YMSLookupInfo();
			 worker=ymsLookupInfo.lookupWorNumName();
		        for(int i=0;i<worker.size();i++){
		        	jcb.addItem(worker.get(i));
		        }
		}
		//添加订单号下拉框
		public void addOrder(JComboBox<String> jcb) {
			// TODO 自动生成的方法存根
			ArrayList<String> order=null;
			 ymsLookupInfo=new YMSLookupInfo();
			 order=ymsLookupInfo.lookupOrder();
		        for(int i=0;i<order.size();i++){
		        	jcb.addItem(order.get(i));
		        }
			
		}
		private void addTable(ArrayList<ArrayList<String>> checkDone) {
			// TODO 自动生成的方法存根
			 Object [][] data;
			 double total=0;
			if(checkDone.size()==0){
				data=new Object[1][12];
				data[0][6]="无记录";
				data[0][0]="";data[0][1]="";data[0][2]="";data[0][3]="";data[0][4]="";data[0][5]="";data[0][6]="";data[0][7]="";
				data[0][8]="";data[0][9]="";data[0][10]="";data[0][11]="";
				
			}
			else{data=new Object[checkDone.size()+1][checkDone.get(0).size()];
		        jsp.setViewportView(jTable); 
				for(int i=0;i<checkDone.size();i++){
					for(int j=0;j<checkDone.get(i).size();j++){
						data[i][j]=(checkDone.get(i).get(j));
						if(j==11)total+=Double.valueOf(checkDone.get(i).get(j));
					}
					
				}
				BigDecimal   b   =   new   BigDecimal(total); 
				double   d1   =   b.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();
				data[checkDone.size()][0]="总和";
				data[checkDone.size()][11]=String.valueOf(d1);
				data[checkDone.size()][1]="";data[checkDone.size()][2]="";data[checkDone.size()][3]="";data[checkDone.size()][4]="";
				data[checkDone.size()][5]="";data[checkDone.size()][6]="";data[checkDone.size()][7]="";data[checkDone.size()][8]="";
				data[checkDone.size()][9]="";data[checkDone.size()][10]="";data[checkDone.size()][12]="";
			}
			jTable=new JTable(data,items);
			DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();     
	        r.setHorizontalAlignment(JLabel.CENTER);     
	        jTable.setDefaultRenderer(Object.class, r);  
	        jsp.setViewportView(jTable); 
			
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		switch (e.getActionCommand()) {
		case "查看":
			String jobnum;
			String time;
			String ordernum;
			System.out.println(jcb2.getSelectedIndex());
			if(jcb2.getSelectedIndex()==0){
				jobnum="";
			}else{
				jobnum=ymsLookupInfo.lookupWorNum().get(jcb2.getSelectedIndex()-1);
			}
			if(jcb.getSelectedIndex()==0){
				time="";
			}else{
				time=new SimpleDateFormat("yyyy").format(new Date())+"-"+jcb.getSelectedItem().toString();
			}
			if(jcb3.getSelectedIndex()==0){
				ordernum="";
			}else{
				ordernum=ymsLookupInfo.lookupOrder().get(jcb3.getSelectedIndex()-1);
			}
			System.out.println(jobnum+"名字");
			System.out.println(new SimpleDateFormat("yyyy").format(new Date())+"-"+jcb.getSelectedItem().toString());
			ymsLookupInfo=new YMSLookupInfo();
			ymsSalaryManeger=new YMSSalaryManeger();
			if(ordernum.equals("")){
			addTable(ymsSalaryManeger.salaryCheck(jobnum,time));
			}else{
				addTable(ymsSalaryManeger.salaryCheck(ordernum));
			}
			break;
		case "输出":
			try {
                exp = new ExportExcel();
                exp.exportTable(jTable, new File("salary"
                +new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date())
                +".xls"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
			  SuccessFrame successFrame1=new SuccessFrame(this, true);
			break;
		default:
			break;
		}
		
	}

}
