package com.hangshaotong;

import javax.swing.*;

import com.zhaopengfei.MenuFrame;
import static com.zhaopengfei.Information.ID;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener{
	JLabel lbl_name = new JLabel("用户名：");
	JLabel lbl_pwd = new JLabel ("密码：");
	JTextField txt_name  = new JTextField();
	JPasswordField txt_pwd = new JPasswordField();
	JButton btn_OK = new JButton("确定");
	JButton btn_Cancel = new JButton("取消");
	public Admin() {
		JPanel jp = (JPanel)this.getContentPane();
		
		jp.setLayout(new GridLayout(3,2));
		jp.add(lbl_name);jp.add(txt_name);
		jp.add(lbl_pwd); jp.add(txt_pwd);
		jp.add(btn_OK); jp.add(btn_Cancel);
		
		this.setTitle("用户登录");
		btn_OK.addActionListener(this);
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				txt_name.setText(null);
				txt_pwd.setText(null);
			}
		});
		
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "123456");
			Statement sta = con.createStatement();
			//ResultSet rs = sta.executeQuery("select * from login");
			
			ResultSet rs = sta.executeQuery("select position from login where userId='"+txt_name.getText()+"' and password = '"+txt_pwd.getText()+"' ");
			//��ȡְλ
			String pos = null;
			while(rs.next()) {
			//System.out.println(rs.getString(1));
			pos = rs.getString(1);
			}
			//System.out.println(pos);
			if(pos.equals("student")) {
				new StuQuery();
				//stuq.setVisible(true);
				//stuq.setSize(1000.1000);
			}
			else if(pos.equals("root")) {
				//StuQuery stuq = new StuQuery();
				ID = txt_name.getText().trim();
				new MenuFrame();
				this.setVisible(false);
				
				//stuq.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "出现错误", "账号或密码错误", JOptionPane.ERROR_MESSAGE);
			}
			rs.close();sta.close();con.close();
			
		}
		catch(SQLException e2) {System.out.println(".........");} 
		catch (ClassNotFoundException e1)
		{System.out.println("错误");}
		catch(NullPointerException e3) {JOptionPane.showMessageDialog(null, "出现错误", "账号或密码错误", JOptionPane.ERROR_MESSAGE);}
	}

}
