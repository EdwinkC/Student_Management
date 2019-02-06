package com.hangshaotong;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePassword extends JFrame{
	JLabel lbl_id = new JLabel("账号：");
	JLabel lbl_pwd = new JLabel ("密码：");
	JLabel lbl_pos = new JLabel("职位：");
	JLabel j1 = new JLabel("  ");JLabel j2 = new JLabel("  ");
	JLabel j3 = new JLabel("  ");JLabel j4 = new JLabel("  ");
	JLabel j5 = new JLabel("  ");JLabel j6 = new JLabel("  ");
	JTextField txt_id;
	JTextField txt_pwd  = new JTextField();
	JTextField txt_pos;
	JButton btn_OK = new JButton("修改");
	JButton btn_qc = new JButton("清除");
	JButton btn_Cancel = new JButton("取消");
	public ChangePassword(String user,String posi)
	{
		JFrame frame = new JFrame("修改密码信息");
		Container contentPane = frame.getContentPane();
		//设成三行五列
		contentPane.setLayout(new GridLayout(3,5));
		
		contentPane.add(lbl_id);
		
		JTextField txt_id  = new JTextField(user);
		txt_id.setEditable(false);
		contentPane.add(txt_id);
		
		contentPane.add(j1); 
		contentPane.add(lbl_pwd);
		contentPane.add(txt_pwd);
		contentPane.add(lbl_pos);
		
		JTextField txt_pos  = new JTextField(posi);
		txt_pos.setEditable(false);
		contentPane.add(txt_pos);
		
		contentPane.add(j2);
		contentPane.add(j3);
		contentPane.add(j4);
		contentPane.add(j5);
		contentPane.add(btn_OK);
		contentPane.add(btn_qc);
		contentPane.add(btn_Cancel);
		contentPane.add(j6);
		
		
		btn_qc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				txt_pwd.setText(null);
			}
		});
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				frame.setVisible(false);
			}
		});
		
		btn_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con;
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "123456");
					PreparedStatement ps;
					
					//使用带参数的SQL语句创建preparedStatement对象
					ps = con.prepareStatement("update login set password=? where userId=? and position=?");
					//ResultSet rs = sta.executeQuery("update login set password = '"+txt_pwd.getText()+"' where userId = '"+txt_id.getText()+"'and position ='"+txt_pos.getText()+"' ");
					//rs.close();sta.close();con.close();
				
					String a = txt_id.getText();
				
					ps.setString(1,txt_pwd.getText());
					ps.setString(2,txt_id.getText());
					ps.setString(3,txt_pos.getText());
				
					
					int count = ps.executeUpdate();
					
					if(count==1) {
						JOptionPane.showConfirmDialog(null, "已成功修改", "请确认后返回", JOptionPane.YES_OPTION);
					}
					else
						JOptionPane.showMessageDialog(null, "修改失败", "请确定后返回", JOptionPane.ERROR_MESSAGE);
					
					ps.close();con.close();
				}catch(SQLException e2) {System.out.println(".........");} 
				catch (ClassNotFoundException e1)
				{System.out.println("错误");}
				catch(NullPointerException e3) 
				{JOptionPane.showMessageDialog(null, "修改失败", "请确定后返回", JOptionPane.ERROR_MESSAGE);}
			}
		});
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}

}