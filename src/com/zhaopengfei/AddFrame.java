package com.zhaopengfei;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.zhaopengfei.Information.Student;

import static com.zhaopengfei.Information.*;

public class AddFrame extends JFrame implements ActionListener{
	private JLabel lbl_no;
    private JLabel lbl_name;
    private JLabel lbl_sex;
    private JLabel lbl_homeplace;
    private JLabel lbl_major;
    private JLabel lbl_class;
    private JLabel lbl_age;
    private JLabel lbl_sourse;
    
    private JTextField txt_no;
    private JTextField txt_name;
    private JTextField txt_sex;
    private JTextField txt_homeplace;
    private JTextField txt_major;
    private JTextField txt_class;
    private JTextField txt_age;
    private JTextField txt_sourse;
    
    private JButton btn_add;
    private JButton btn_clear;
    private JButton btn_cancel;
    private JPanel jp;

    public AddFrame(){
        jp = (JPanel)getContentPane();
        //jp.setBackground(Color.lightGray);
        jp.setBorder(new EmptyBorder(5, 5, 5, 5));
        jp.setLayout(null);
        
        lbl_no = new JLabel("学 号：");
        lbl_no.setFont(new Font("宋体", Font.BOLD, 15));
        lbl_no.setBounds(10, 20, 60, 30);
        jp.add(lbl_no);

        txt_no = new JTextField();
        txt_no.setFont(new Font("宋体", Font.BOLD, 15));
        txt_no.setBounds(70, 20, 150, 30);
        jp.add(txt_no);

        lbl_name = new JLabel("姓 名：");
        lbl_name.setFont(new Font("宋体", Font.BOLD, 15));
        lbl_name.setBounds(250, 20, 70, 30);
        jp.add(lbl_name);

        txt_name = new JTextField();
        txt_name.setFont(new Font("宋体", Font.BOLD, 15));
        txt_name.setBounds(310, 20, 150, 30);
        jp.add(txt_name);

        lbl_sex = new JLabel("性 别：");
        lbl_sex.setFont(new Font("宋体", Font.BOLD, 15));
        lbl_sex.setBounds(10, 70, 70, 30);
        jp.add(lbl_sex);

        txt_sex = new JTextField();
        txt_sex.setFont(new Font("宋体", Font.BOLD, 15));
        txt_sex.setBounds(70, 70, 150, 30);
        jp.add(txt_sex);

        lbl_homeplace = new JLabel("出生地：");
        lbl_homeplace.setFont(new Font("宋体", Font.BOLD, 15));
        lbl_homeplace.setBounds(10, 120, 70, 30);
        jp.add(lbl_homeplace);

        txt_homeplace = new JTextField();
        txt_homeplace.setFont(new Font("宋体", Font.BOLD, 15));
        txt_homeplace.setBounds(70, 120, 150, 30);
        jp.add(txt_homeplace);

        lbl_age = new JLabel("年 龄：");
        lbl_age.setFont(new Font("宋体", Font.BOLD, 15));
        lbl_age.setBounds(250, 120, 70, 30);
        jp.add(lbl_age);

        txt_age = new JTextField();
        txt_age.setFont(new Font("宋体", Font.BOLD, 15));
        txt_age.setBounds(310, 120, 150, 30);
        jp.add(txt_age);

        lbl_major = new JLabel("专 业：");
        lbl_major.setFont(new Font("宋体", Font.BOLD, 15));
        lbl_major.setBounds(10, 170, 70, 30);
        jp.add(lbl_major);

        txt_major = new JTextField();
        txt_major.setFont(new Font("宋体", Font.BOLD, 15));
        txt_major.setBounds(70, 170, 150, 30);
        jp.add(txt_major);
        
        lbl_class = new JLabel("班 级：");
        lbl_class.setFont(new Font("宋体", Font.BOLD, 15));
        lbl_class.setBounds(10, 220, 70, 30);
        jp.add(lbl_class);

        txt_class = new JTextField();
        txt_class.setFont(new Font("宋体", Font.BOLD, 15));
        txt_class.setBounds(70, 220, 150, 30);
        jp.add(txt_class);
        
        lbl_sourse = new JLabel("成 绩：");
        lbl_sourse.setFont(new Font("宋体", Font.BOLD, 15));
        lbl_sourse.setBounds(250, 220, 70, 30);
        jp.add(lbl_sourse);

        txt_sourse = new JTextField();
        txt_sourse.setFont(new Font("宋体", Font.BOLD, 15));
        txt_sourse.setBounds(310, 220, 150, 30);
        jp.add(txt_sourse);

        btn_add = new JButton("添加");
        btn_add.setFont(new Font("宋体", Font.BOLD, 20));
        btn_add.setBounds(50, 300, 100, 25);
        jp.add(btn_add);
        btn_add.addActionListener(this);
        
        btn_clear = new JButton("清除");
        btn_clear.setFont(new Font("宋体", Font.BOLD, 20));
        btn_clear.setBounds(200, 300, 100, 25);
        jp.add(btn_clear);
        btn_clear.addActionListener(this);
        
        btn_cancel = new JButton("取消");
        btn_cancel.setFont(new Font("宋体", Font.BOLD, 20));
        btn_cancel.setBounds(350, 300, 100, 25);
        jp.add(btn_cancel);
        btn_cancel.addActionListener(this);

        setTitle("添加学生信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(400,170,500,380);
        setResizable(false);
        setVisible(true);

    }

    public void actionPerformed (ActionEvent e){
    	
    	if(e.getSource() == btn_add) {
    		if(txt_no.getText().equals("")||txt_name.getText().equals("")||txt_sex.getText().equals("")||
    	        	txt_age.getText().equals("")||txt_homeplace.getText().equals("")||
    	        	txt_major.getText().equals("")||txt_class.getText().equals("")||txt_sourse.getText().equals("")){
    	            JOptionPane.showMessageDialog(this, "编辑框不能为空！");
    	    } 
    	    else{
    	        	Student stu = new Student();
    	            stu.id = txt_no.getText().trim();
    	            stu.name = txt_name.getText().trim();
    	            stu.sex = txt_sex.getText().trim();
    	            stu.age = Integer.parseInt(txt_age.getText().trim());
    	            stu.homeplace = txt_homeplace.getText().trim();
    	            stu.major = txt_major.getText().trim();
    	            stu.classes = txt_class.getText().trim();
    	            stu.sourse = Float.parseFloat(txt_sourse.getText().trim());
    	            
    	            if(addRecord(stu)){
    	                JOptionPane.showMessageDialog(this, "添加成功！");
    	            } else {
    	            	JOptionPane.showMessageDialog(this, "添加失败！");
    	            }
    	            
    	        }
    	}
    	else if(e.getSource() == btn_clear) {
    		txt_no.setText("");
    	    txt_name.setText("");
    	    txt_sex.setText("");
    	    txt_homeplace.setText("");
    	    txt_major.setText("");
    	    txt_class.setText("");
    	    txt_age.setText("");
    	    txt_sourse.setText("");
    	}
    	else if(e.getSource() == btn_cancel) {
    		this.dispose();
    	}

    }
 
    /**
     *insert a new record
     * @param stu
     * @return insert success return true
     */
    public boolean addRecord(Student stu) {
    	 try {
             Class.forName(DRIVER_NAME);
             Connection con = DriverManager.getConnection(DB_URL, USER_NAME, DB_PASSWD);
             String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
             PreparedStatement ps = con.prepareStatement(sql);
             
             ps.setString(1, stu.id);
             ps.setString(2, stu.name);
             ps.setString(3, stu.sex);
             ps.setInt(4, stu.age);
             ps.setString(5, stu.homeplace);
             ps.setString(6, stu.major);
             ps.setString(7, stu.classes);
             ps.setFloat(8, (float)stu.sourse);            

             int c = ps.executeUpdate();
             if(c == 1){
                 ps.close();
                 con.close();
                 return true;
             }
             ps.close();
             con.close();
         } catch (ClassNotFoundException cnfe) {
             cnfe.printStackTrace();
         } catch (SQLException sqle) {
             sqle.printStackTrace();
         }
    	 return false;
    }

}
