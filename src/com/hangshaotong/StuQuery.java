package com.hangshaotong;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class StuQuery extends JFrame implements ActionListener{
	JLabel jp1 = new JLabel("请输入学生姓名："); JLabel jp2 = new JLabel("");
	JTextField jtf = new JTextField("");//文本输入
	JButton jb1 = new JButton("查询->");
	JButton jb2 = new JButton("清除");
	JButton jb3 = new JButton("显示所有记录");
	DefaultTableModel model;
	JTable table;
	
	public StuQuery() 
	{
		Vector columnNames = new Vector();//设置列名
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("专业");
		columnNames.add("班号");
		columnNames.add("总学分");
		Vector rowData = new Vector();
		Vector ve = new Vector();
		ve.add("");
		ve.add("");
		ve.add("");
		ve.add("");
		ve.add("");
		ve.add("");
		ve.add("");
		ve.add("");
		rowData.add(ve);
		
		JFrame frame= new JFrame("学生查询");
		Container contentPane = frame.getContentPane();
		//创建水平方向上的实例
		Box jh = Box.createHorizontalBox();
		//JPanel jv = new JPanel();
		jh.add(jp1);
		jh.add(jtf);
		jh.add(jb1);
		jh.add(jb2);
		jh.add(jb3);
		contentPane.add(jh, BorderLayout.NORTH);//将jh添加到窗格北部

		//创建垂直方向
		Box jv = Box.createVerticalBox();
		//*******************************************************
	
		Event();	
		model = new DefaultTableModel(rowData,columnNames);  //创建一个表格模型
		table = new JTable(model);
		JScrollPane jsp = new JScrollPane(table);
			
		jv.add(jsp);
		
		contentPane.add(jv,BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(800,500);
		frame.setLocationRelativeTo(null);
	
	}
	public void Event() {
		jb3.addActionListener(new ActionListener()//显示所有记录
				{
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent arg0)
					{
						
						Vector columnNames = new Vector();//设置列名
						
						columnNames.add("学号");
						columnNames.add("姓名");
						columnNames.add("性别");
						columnNames.add("年龄");
						columnNames.add("籍贯");
						columnNames.add("专业");
						columnNames.add("班号");
						columnNames.add("总学分");
						
						Vector rowData = new Vector();
						
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con;
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "123456");
							Statement sta = con.createStatement();
							ResultSet rs = sta.executeQuery("select * from student");
							//String pos = null;
							
							while(rs.next()) {
								Vector ve = new Vector();
								
								ve.add(rs.getString(1));
								ve.add(rs.getString(2));
								ve.add(rs.getString(3));
								ve.add(rs.getString(4));
								ve.add(rs.getString(5));
								ve.add(rs.getString(6));
								ve.add(rs.getString(7));
								ve.add(rs.getString(8));
								
								//加入到rowdata
								rowData.add(ve);								
		
							}
							rs.close();sta.close();con.close();
						}catch(Exception e) {e.printStackTrace();}
							//初始化jtale
					model.setDataVector(rowData, columnNames);
						
					}
				}
				);
		jb1.addActionListener(new ActionListener()
				{
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent arg0)
					{
						//************************
						Vector columnNames = new Vector();//设置列名
						
						columnNames.add("学号");
						columnNames.add("姓名");
						columnNames.add("性别");
						columnNames.add("年龄");
						columnNames.add("籍贯");
						columnNames.add("专业");
						columnNames.add("班号");
						columnNames.add("总学分");
						
						Vector rowData = new Vector();
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							
							Connection con;
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "123456");
							Statement sta = con.createStatement();
							//ResultSet rs = sta.executeQuery("select * from login");
							ResultSet rs = sta.executeQuery("select stuId,stuName,stuSex,stuAge,stuJg,stuZy,classId,stuSourse from student where stuName='"+jtf.getText()+"'");
							//提取职位
							
							while(rs.next()) {
								
							Vector ve = new Vector();
							ve.add(rs.getString(1));
							ve.add(rs.getString(2));
							ve.add(rs.getString(3));
							ve.add(rs.getString(4));
							ve.add(rs.getString(5));
							ve.add(rs.getString(6));
							ve.add(rs.getString(7));
							ve.add(rs.getString(8));
							//加入到rowdata
							rowData.add(ve);
							
							}
							rs.close();sta.close();con.close();
						}catch(Exception e) {e.printStackTrace();}
							//初始化jtale
				
						model.setDataVector(rowData, columnNames);
											
					}
				});
		jb2.addActionListener(new ActionListener()
		{
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0)
			{
			Vector rowData =null;
			Vector columnNames = null;
			model.setDataVector(rowData, columnNames);
			}
		});
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
