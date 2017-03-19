package com.qy.yms.view;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import com.qy.yms.server.YMSDailyProductionManeger;
import com.qy.yms.server.YMSLookupInfo;
import com.qy.yms.test.MyComboBoxUI;
import com.qy.yms.tools.MyKeyListener;
import java.awt.Robot;
public class YMSMenegerFrame extends JFrame implements ActionListener {

	JPanel jp1,jp2,jp22,jp3;
	JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlb8,jlb9,jlb10,jlb11,jlb12,jlb13,jlb14;
	JComboBox<String> jcb1,jcb2,jcb3,jcb4;
	JTextField jtf,jtf2;
	JButton jb1,jb2;
	YMSLookupInfo ymsLookupInfo;
	YMSDailyProductionManeger ymsDailyProductionManeger;
	MyKeyListener myKeyListener;
	Robot robot;
	static double uni=0;
	ImageIcon qiyao;
	public YMSMenegerFrame() throws HeadlessException {
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
		jlb2=new JLabel("生产日报");
		jlb2.setFont(new Font("宋体", Font.BOLD, 36));
		jlb2.setBounds(225, 35, 400, 50);
		jlb3=new JLabel("___________________________________________________________________________________________________");
		jlb3.setForeground(Color.black);
		jlb3.setBounds(0, 100, 600, 20);
		jp1.add(jlb1);
		jp1.add(jlb2);
		jp1.add(jlb3);
		
		//中部：各个选项
		jp22=new JPanel(new BorderLayout());
		jp2=new JPanel(null);
		jp2.setPreferredSize(new Dimension(450,350));
		jlb4=new JLabel("工人姓名");
		jlb5=new JLabel("订单号");
		jlb6=new JLabel("品名");
		jlb7=new JLabel("工序名");
		jlb8=new JLabel("单价");
		jlb9=new JLabel("     ");
		jlb9.setBorder(new BevelBorder(BevelBorder.LOWERED));
		jlb10=new JLabel("数量");
		jlb11=new JLabel("总价");
		jlb12=new JLabel("     ");
		jlb12.setBorder(new BevelBorder(BevelBorder.LOWERED));
		jlb14=new JLabel("备注");
		jcb1=new JComboBox() {
			public void updateUI() {
				setUI(new MyComboBoxUI());
				}
				};
		addWorker(jcb1);
		jcb2=new JComboBox<>();
		jcb3=new JComboBox() {
			public void updateUI() {
				setUI(new MyComboBoxUI());
				}
				};
		jcb4=new JComboBox<>();
	/*	jcb1.setEditable(true);
		jcb2.setEditable(true);
		jcb3.setEditable(true);
		jcb4.setEditable(true);*/
		jtf=new JTextField();
		jtf2=new JTextField("无");
		myKeyListener=new MyKeyListener(uni,jlb12);
		jtf.addKeyListener(myKeyListener);
		jtf.addActionListener(this);
		jtf.setActionCommand("数量");
		jcb1.addActionListener(this);
		jcb2.addActionListener(this);
		jcb3.addActionListener(this);
		jcb4.addActionListener(this);
		jcb1.setActionCommand("工人姓名");
		jcb2.setActionCommand("订单号");
		jcb3.setActionCommand("品名");
		jcb4.setActionCommand("工序名");
		
		jlb4.setBounds(20, 0, 150, 30);
		jlb5.setBounds(20, 50, 150, 30);
		jlb6.setBounds(20, 100, 150, 30);
		jlb7.setBounds(20, 150, 150, 30);
		jlb8.setBounds(20, 200, 150, 30);
		jlb10.setBounds(20, 250, 150, 30);
		jlb11.setBounds(20, 300, 150, 30);
		jlb14.setBounds(20, 350, 150, 30);
		jcb1.setBounds(130, 0, 380, 30);
		jcb2.setBounds(130, 50, 380, 30);
		jcb3.setBounds(130, 100, 380, 30);
		jcb4.setBounds(130, 150, 380, 30);
		jlb9.setBounds(130, 200, 380, 30);
		jtf.setBounds(130, 250, 380, 30);
		jlb12.setBounds(130, 300, 380, 30);
		jtf2.setBounds(130, 350, 380, 30);
		jp2.add(jlb4);
		jp2.add(jcb1);
		jp2.add(jlb5);
		jp2.add(jcb2);
		jp2.add(jlb6);
		jp2.add(jcb3);
		jp2.add(jlb7);
		jp2.add(jcb4);
		jp2.add(jlb8);
		jp2.add(jlb9);
		jp2.add(jlb10);
		jp2.add(jtf);
		jp2.add(jlb11);
		jp2.add(jlb12);
		jp2.add(jlb14);
		jp2.add(jtf2);
		jp22.add(jp2,BorderLayout.CENTER);
		jp22.add(new JLabel("    "),BorderLayout.NORTH);
		jp22.add(new JLabel("    "),BorderLayout.EAST);
		jp22.add(new JLabel("    "),BorderLayout.WEST);
		jlb4.setFont(new Font("宋体", Font.BOLD, 20));
		jlb5.setFont(new Font("宋体", Font.BOLD, 20));
		jlb6.setFont(new Font("宋体", Font.BOLD, 20));
		jlb7.setFont(new Font("宋体", Font.BOLD, 20));
		jlb8.setFont(new Font("宋体", Font.BOLD, 20));
		jlb9.setFont(new Font("宋体", Font.BOLD, 20));
		jlb10.setFont(new Font("宋体", Font.BOLD, 20));
		jlb11.setFont(new Font("宋体", Font.BOLD, 20));
		jlb12.setFont(new Font("宋体", Font.BOLD, 20));
		jlb14.setFont(new Font("宋体", Font.BOLD, 20));
		jcb1.setFont(new Font("宋体", Font.BOLD, 20));
		jcb2.setFont(new Font("宋体", Font.BOLD, 20));
		jcb3.setFont(new Font("宋体", Font.BOLD, 20));
		jcb4.setFont(new Font("宋体", Font.BOLD, 20));
		jtf.setFont(new Font("宋体", Font.BOLD, 20));
		jtf2.setFont(new Font("宋体", Font.BOLD, 20));

		
		
		
	
	
		
		//南部：确认
		jp3=new JPanel(null);
		jp3.setPreferredSize(new Dimension(600,100));
		jlb13=new JLabel("___________________________________________________________________________________________________");
		jlb13.setForeground(Color.black);
		jlb13.setBounds(0, 20, 600, 20);
		jb1=new JButton("返回");
		jb2=new JButton("确认");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb1.setActionCommand("返回");
		jb2.setActionCommand("确认");
		jb1.setBounds(100, 50, 100, 30);
		jb2.setBounds(400, 50, 100, 30);
		jp3.add(jlb13);
		jp3.add(jb1);
		jp3.add(jb2);
		jb1.setFont(new Font("宋体", Font.BOLD, 20));
		jb2.setFont(new Font("宋体", Font.BOLD, 20));
		this.setSize(600, 600);
		this.setLocation(0, 50);
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp22,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
	//添加品名下拉框
		public void addCommodity(JComboBox<String> jcb,String order) {
			// TODO 自动生成的方法存根
			ArrayList<String> commodity=null;
			 ymsLookupInfo=new YMSLookupInfo();
			 commodity=ymsLookupInfo.lookupCommodity(order,"1");
		        for(int i=0;i<commodity.size();i++){
		        	jcb.addItem(commodity.get(i));
		        }
			
		}
		//添加工序下拉框
				public void addProcess(JComboBox<String> jcb,String commodity) {
					// TODO 自动生成的方法存根
					ArrayList<String> process=null;
					 ymsLookupInfo=new YMSLookupInfo();
					 process=ymsLookupInfo.lookupComPro(commodity,true);
				        for(int i=0;i<process.size();i++){
				        	jcb.addItem(process.get(i));
				        }
					
				}
				//添加工序下拉框
				public String univalent(String prouni) {
					// TODO 自动生成的方法存根
					char[] b = prouni.toCharArray();
			        String result = "";
			        for (int i = 0; i < b.length; i++)
			        {
			            if (("0123456789.").indexOf(b[i] + "") != -1)
			            {
			                result += b[i];
			            }
			        }
					return result;
					
				}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		switch (e.getActionCommand()) {
		case "工人姓名":
			if(jcb1.getSelectedItem()!=null){
				System.out.println("jcb1");
			jcb2.removeAllItems();
			addOrder(jcb2);
			}
			break;
		case "订单号":
			
			if(jcb2.getSelectedItem()!=null){
			jcb3.removeAllItems();	
			addCommodity(jcb3, jcb2.getSelectedItem().toString());
			System.out.println(jcb2.getSelectedItem().toString());
			}
			break;
		case "品名":
			if(jcb3.getSelectedItem()!=null){
			jcb4.removeAllItems();
			addProcess(jcb4, jcb3.getSelectedItem().toString().substring(0, 6));
			System.out.println(jcb3.getSelectedItem().toString().substring(0, 6));
			}
			break;
		case "工序名":
			if(jcb4.getSelectedItem()!=null){
			
			uni=Double.valueOf( new YMSLookupInfo().lookupComPro(jcb3.getSelectedItem().toString().substring(0, 6),false).get(jcb4.getSelectedIndex()));
			System.out.println(uni);
			jlb9.setText(String.valueOf(uni));
			jtf.addKeyListener(new MyKeyListener(uni, jlb12));
			}
		
			
			break;
		case "数量":
			if(jtf.getText().equals("")){
				myKeyListener.setTemp("");
			}
			break;
		case "返回":
			this.setVisible(false);
			break;
		case "确认":
			if(jtf.getText().equals("")||
					jtf.getText().equals(null)){
				WrongFrame wrongFrame=new WrongFrame(this, true);
			}else {
				 ymsLookupInfo=new YMSLookupInfo();
				String list[]={new YMSLookupInfo().lookupWorNum().get(jcb1.getSelectedIndex()),
						jcb2.getSelectedItem().toString(),
						jcb3.getSelectedItem().toString().substring(0,6),
						ymsLookupInfo.lookupCommodity(jcb2.getSelectedItem().toString(), "2").get(jcb3.getSelectedIndex()),
						jcb4.getSelectedItem().toString(),
						jlb9.getText(),
						jtf.getText(),
						jlb12.getText(),
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
						jtf2.getText()};
				MakeSureFrame makeSureFrame=new MakeSureFrame(this,true);
				if(makeSureFrame.flag){
				ymsDailyProductionManeger=new YMSDailyProductionManeger();
				ymsDailyProductionManeger.dailyProductionAdd(list);
				SuccessFrame successFrame1=new SuccessFrame(this, true);
				jtf.setText("");
				}
				try {
					robot=new Robot();
				} catch (AWTException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				jtf.requestFocus();
				for(int i=0;i<10;i++){
				robot.keyPress(KeyEvent.VK_DELETE);
				robot.keyRelease(KeyEvent.VK_DELETE);
				}
				jtf.setText("");
				System.out.println("tempChange"+myKeyListener.getTemp());
			}
			break;

		default:
			break;
		}
		
	}

	

}
