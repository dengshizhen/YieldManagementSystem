package com.qy.yms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.qy.yms.dao.*;
import com.qy.yms.server.YMSLookupInfo;
import com.qy.yms.server.YMSOrderManeger;
import com.qy.yms.tools.MyFocusListener;
public class YMSAddFrame extends JFrame implements ActionListener {
	/**
	 * ��������
	 * ȷ������
	 */
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2,jlb3,jlb3_1,jlb3_2,jlb3_3,jlb3_4,jlb4,jlb5,jlb6,jlb7,jlb8,jlb9,jlb10,jlb11,jlb0;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
	JComboBox<String> jcb1,jcb2;
	YMSOrderManeger ymsOrderManeger;
	YMSLookupInfo ymsLookupInfo;
	String info1,info2,info3,info4,info5,info6,info7;
	ArrayList<String > quantity;
	ImageIcon qiyao;
	public YMSAddFrame() throws HeadlessException {
		// TODO �Զ����ɵĹ��캯�����
		
		/**
		 * ʵ�ָ����������ɱ�����
		 */
		//��������˾ͼ�꼰��Ԫ����
		jp1=new JPanel(null);
		jp1.setPreferredSize(new Dimension(600, 150));
		jlb1=new JLabel();
		qiyao=new ImageIcon(YMSAddFrame.class.getResource("qiyao.png"));
		jlb1.setIcon(qiyao);
		jlb1.setBounds(0, 0, 115, 114);
		jlb2=new JLabel("���Ķ���");
		jlb2.setFont(new Font("����", Font.BOLD, 36));
		jlb2.setBounds(200, 35, 400, 50);
		jlb3=new JLabel("___________________________________________________________________________________________________");;
		jlb3.setForeground(Color.black);
		jlb3.setBounds(0, 100, 600, 20);
		jp1.add(jlb1);
		jp1.add(jlb2);
		jp1.add(jlb3);
		
		//�в������Ʒ��
		jp2=new JPanel(null);
		jp2.setPreferredSize(new Dimension(600,150));
		jlb4=new JLabel("������");
		jlb0=new JLabel("��Ʒ���");
		jlb5=new JLabel("Ʒ��");
		jlb6=new JLabel("���");
		jlb7=new JLabel("��ɫ");
		jlb8=new JLabel("�ƻ�����");
		jlb3_1=new JLabel("___________________________________________________________________________________________________");;
		jlb3_1.setForeground(Color.black);
		jlb3_1.setBounds(0, 160, 600, 20);
		
		jlb4.setBounds(20, 00, 100, 30);
		jlb0.setBounds(320, 00, 100, 30);
		jlb5.setBounds(20, 45, 60, 30);
		jlb6.setBounds(20, 95, 60, 30);
		jlb7.setBounds(320, 95, 60, 30);
		jlb8.setBounds(0, 140, 100, 30);
		jlb4.setFont(new Font("����", Font.BOLD, 20));
		jlb0.setFont(new Font("����", Font.BOLD, 20));
		jlb5.setFont(new Font("����", Font.BOLD, 20));
		jlb6.setFont(new Font("����", Font.BOLD, 20));
		jlb7.setFont(new Font("����", Font.BOLD, 20));
		jlb8.setFont(new Font("����", Font.BOLD, 20));
		
		
		jt1=new JTextField("���붩��������");
		jt2=new JTextField("�����Ʒ���");
		jt3=new JTextField("����Ʒ��");
		jt4=new JTextField("������50*50");
		jt5=new JTextField("������ɫ");
		jt6=new JTextField("���붩������");
		 info1="���붩��������";
		 info2="�����Ʒ���";
		 info3="����Ʒ��";
	     info4="������50*50";
		 info5="������ɫ";
		 info6="���붩������";
		jt1.addFocusListener(new MyFocusListener(info1,jt1));
		jt2.addFocusListener(new MyFocusListener(info2,jt2));
		jt3.addFocusListener(new MyFocusListener(info3,jt3));
		jt4.addFocusListener(new MyFocusListener(info4,jt4));
		jt5.addFocusListener(new MyFocusListener(info5,jt5));
		jt6.addFocusListener(new MyFocusListener(info6,jt6));
		jt1.setBounds(100, 0, 150, 30);
		jt2.setBounds(420, 0, 150, 30);
		jt3.setBounds(100, 45, 470, 30);
		jt4.setBounds(420, 95, 150, 30);
		jt5.setBounds(100, 95, 150, 30);
		jt6.setBounds(100, 140, 150, 30);
		jt1.setFont(new Font("����", Font.BOLD, 20));
		jt2.setFont(new Font("����", Font.BOLD, 20));
		jt3.setFont(new Font("����", Font.BOLD, 20));
		jt4.setFont(new Font("����", Font.BOLD, 20));
		jt5.setFont(new Font("����", Font.BOLD, 20));
		jt6.setFont(new Font("����", Font.BOLD, 20));
		
		jt1.setForeground(Color.gray);
		jt2.setForeground(Color.gray);
		jt3.setForeground(Color.gray);
		jt4.setForeground(Color.gray);
		jt5.setForeground(Color.gray);
		jt6.setForeground(Color.gray);

		jp2.add(jlb4);
		jp2.add(jlb0);
		jp2.add(jlb5);
		jp2.add(jlb6);
		jp2.add(jlb7);
		jp2.add(jlb8);
		jp2.add(jt1);
		jp2.add(jt2);
		jp2.add(jt3);
		jp2.add(jt4);
		jp2.add(jt5);
		jp2.add(jt6);
		jp2.add(jlb3_1);
		
		
		
		
		//�ϲ�����ӹ���
		jp3=new JPanel(null);
		jp3.setPreferredSize(new Dimension(600,420));
		jlb3_2=new JLabel("___________________________________________________________________________________________________");
		jlb3_2.setForeground(Color.black);
		jlb3_2.setBounds(0, 110, 600, 20);
		jlb3_3=new JLabel("___________________________________________________________________________________________________");
		jlb3_3.setForeground(Color.black);
		jlb3_3.setBounds(0, 170, 600, 20);
		jlb3_4=new JLabel("___________________________________________________________________________________________________");
		jlb3_4.setForeground(Color.black);
		jlb3_4.setBounds(0, 230, 600, 20);
		jt7=new JTextField("���뵥��");
		info7="���뵥��";
		jt7.addFocusListener(new MyFocusListener(info7, jt7));
		jt7.setForeground(Color.gray);
		jlb9=new JLabel("������");
		jlb10=new JLabel("���");
		jlb11=new JLabel("����");
		jb1=new JButton("���Ʒ��+");
		jb2=new JButton("��ӹ���+");
		jb3=new JButton("����");
		jb4=new JButton("�ύ");
		jb5=new JButton("�޸ĵ���");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb1.setActionCommand("���Ʒ��");
		jb2.setActionCommand("��ӹ���");
		jb3.setActionCommand("����");
		jb4.setActionCommand("�ύ");
		jb5.setActionCommand("�޸ĵ���");
		jcb1=new JComboBox<>();
		jcb2=new JComboBox<>();
		jcb1.setForeground(Color.GRAY);
		jcb2.setForeground(Color.GRAY);
        addCategory(jcb1); 
        addProcess(jcb2, jcb1.getItemAt(0));

		
		
		jcb1.addActionListener(this);
		jcb1.setActionCommand("���");
		/*jcb1.setEditable(true);*/
		jcb2.setEditable(true);
		jcb1.setBounds(100, 0, 150, 30);
		jcb2.setBounds(420, 0, 150, 30);
		jb1.setBounds(20,200,200,30);		
		jlb9.setBounds(320, 0, 100, 30);
		jlb10.setBounds(20, 0, 60, 30);
		jlb11.setBounds(20, 80, 60, 30);
		jb2.setBounds(20, 140, 200, 30);
		jb3.setBounds(50, 280, 200, 30);
		jb4.setBounds(350, 280, 200, 30);
		jb5.setBounds(350, 140, 200, 30);
		jt7.setBounds(100, 80, 100, 30);
		jt7.setFont(new Font("����", Font.BOLD, 20));
		jlb9.setFont(new Font("����", Font.BOLD, 20));
		jlb10.setFont(new Font("����", Font.BOLD, 20));
		jlb11.setFont(new Font("����", Font.BOLD, 20));
		jb1.setFont(new Font("����", Font.BOLD, 20));
		jb2.setFont(new Font("����", Font.BOLD, 20));
		jb3.setFont(new Font("����", Font.BOLD, 20));
		jb4.setFont(new Font("����", Font.BOLD, 20));
		jb5.setFont(new Font("����", Font.BOLD, 20));
		jcb1.setFont(new Font("����", Font.BOLD, 20));
		jcb2.setFont(new Font("����", Font.BOLD, 20));
		jp3.add(jlb9);
		jp3.add(jlb10);
		jp3.add(jlb11);
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		jp3.add(jb5);
		jp3.add(jlb3_2);
		jp3.add(jlb3_3);
		jp3.add(jlb3_4);
		jp3.add(jcb1);
		jp3.add(jcb2);
		jp3.add(jt7);
		
		
		this.setSize(600, 800);
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
	}

	private void addCategory(JComboBox<String> jcb) {
		// TODO �Զ����ɵķ������
		ArrayList<String> category=null;
        ymsLookupInfo=new YMSLookupInfo();
        category=ymsLookupInfo.lookupCategory();
        for(int i=0;i<category.size();i++){
        	jcb.addItem(category.get(i));
        }
		
	}
	private void addProcess(JComboBox<String> jcb,String category) {
		// TODO �Զ����ɵķ������
		ArrayList<String> processName=null;
        ymsLookupInfo=new YMSLookupInfo();
        processName=ymsLookupInfo.lookupProName(category);
        for(int i=0;i<processName.size();i++){
        	jcb.addItem(processName.get(i));
        }
		
	}
	private boolean checkProName(String category,String proName) {
		// TODO �Զ����ɵķ������
		ArrayList<String> processName=null;
        ymsLookupInfo=new YMSLookupInfo();
        processName=ymsLookupInfo.lookupProName(category);
        for(int i=0;i<processName.size();i++){
        	if(proName.equals(processName.get(i))){
        		return true;
        	};
        }
        return false;
		
	}

	 boolean checkDone() {
		// TODO �Զ����ɵķ������
		if(jt1.getText().equals("���붩��������")||jt1.getText().equals("")||
				jt2.getText().equals("�����Ʒ���")||jt1.getText().equals("")||
				jt3.getText().equals("����Ʒ��")||jt2.getText().equals("")||
				jt4.getText().equals("������50*50")||jt3.getText().equals("")||
				jt5.getText().equals("������ɫ")||jt4.getText().equals("")||
				jt6.getText().equals("���붩������")||jt5.getText().equals("")||
				jt7.getText().equals("���뵥��")||jt6.getText().equals("")){
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		
		ymsOrderManeger=new YMSOrderManeger();
		switch (e.getActionCommand()) {
		case "���":
			jcb2.removeAllItems();
			System.out.println(jcb1.getSelectedItem().toString());
			addProcess(jcb2, jcb1.getSelectedItem().toString());
		break;
		case "��ӹ���":
			
			if(!checkDone()){
				WrongFrame wrongFrame=new WrongFrame(this, true);
			}else{
				String []addPro={jt2.getText(),jcb2.getSelectedItem().toString(),jcb1.getSelectedItem().toString(),jt7.getText()};
				String []addCom={jt1.getText(),jt2.getText(),jt3.getText(),
						jt4.getText(),jt5.getText(),jt6.getText(),};
				String []addDaily={"base",
						jt1.getText(),
						jt2.getText(),
						jt3.getText(),
						jcb2.getSelectedItem().toString(),jt7.getText(),
						"0",
						"0",
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
						"��"};
			MakeSureFrame makeSureFrame=new MakeSureFrame(this,true);
			if(makeSureFrame.flag){
				ymsOrderManeger.addProcess(addPro,addCom);
				ymsOrderManeger.addDailyBase(addDaily);
				System.out.println("�µ�"+jcb2.getSelectedItem().toString());
				if(!checkProName(jcb1.getSelectedItem().toString(), jcb2.getSelectedItem().toString())){
					ymsOrderManeger.addProcessName(jcb1.getSelectedItem().toString(), jcb2.getSelectedItem().toString());;
				}
			SuccessFrame successFrame1=new SuccessFrame(this, true);
			}
			jcb1.setSelectedIndex(0);
			jcb2.removeAllItems();
			jt7.setText("");
			}
			break;
		case "���Ʒ��":		
			jt2.setText("");
			jt3.setText("");
			jt4.setText("");
			jt5.setText("");
			jt6.setText("");
			jt7.setText("");
			jcb1.setSelectedIndex(0);
			jcb2.removeAllItems();
			
			break;
		case "����":
			this.dispose();
			break;
		case "�ύ"://�����ع��ã�Ϊ�˽�ʡʱ�䣬��һ�汾��ʱδ��ӻع����ܣ�����ȡ�����������ݲ��ύ���ص���������ǰ
			if(!checkDone()){
				WrongFrame wrongFrame=new WrongFrame(this, true);
			}else{
			MakeSureFrame makeSureFrame3=new MakeSureFrame(this,true);
			SuccessFrame successFrame3=new SuccessFrame(this, true);
			}
			break;
		case "�޸ĵ���":
		MakeSureFrame makeSureFrame3=new MakeSureFrame(this,true);
		System.out.println(jt2.getText()+"�޸�"+jcb2.getSelectedItem().toString());
		ymsLookupInfo=new YMSLookupInfo();
		quantity=ymsLookupInfo.lookupUniquantity(jt2.getText(), jcb2.getSelectedItem().toString());
		for(int i=0;i<quantity.size();i++){
		String total=String.valueOf(Integer.valueOf(quantity.get(i))*Double.valueOf(jt7.getText()));
		ymsOrderManeger.updateUni(jt2.getText(), jcb2.getSelectedItem().toString(),jt7.getText(),total,quantity.get(i));
		}
		SuccessFrame successFrame3=new SuccessFrame(this, true);
		default:
			break;
		}
		
	}

	

}
