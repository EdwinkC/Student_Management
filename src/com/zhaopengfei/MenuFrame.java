package com.zhaopengfei;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import static com.zhaopengfei.Information.ID;

import com.chart.HomeplaceBarChart;
import com.chart.SexPieChart;
import com.hangshaotong.ChangePassword;
import com.hangshaotong.StuQuery;

public class MenuFrame extends JFrame implements ActionListener{

	private JMenuBar menubar;
	private JMenu menuSystem, menuStudent, menuSetting, menuStatistical, menuHelp;
	private JMenuItem itemExit, 
		itemShow, itemSearch, itemAdd, itemUpdate, itemDelete, itemClose, 
		itemShowUser, itemUpdatePassword, itemCloseUser,
		itemSex, itemHomeplace,
		itemAutor;
	private ImageIcon iconSystem, iconStudent, iconSetting, iconStatistical, iconHelp,
		iconExit, 
		iconShow, iconSearch, iconAdd, iconUpdate, iconDelete, iconClose, 
		iconShowUser, iconUpdatePassword, iconCloseUser,
		iconSex, iconHomeplace,
		iconAutor,
		iconBackground;	
	private JLabel lbl_bg;
	private JPanel jp;
	
	public MenuFrame(){
		
		menubar = new JMenuBar();
		menuSystem = new JMenu("系统");
		menuStudent = new JMenu("学生管理");
		menuSetting = new JMenu("系统设置");
		menuStatistical = new JMenu("统计分析");
		menuHelp = new JMenu("帮助");
		
		itemExit = new JMenuItem("<-退出系统->");
		itemShow = new JMenuItem("<-显示记录->");
		itemSearch = new JMenuItem("<-查询记录->");
		itemAdd = new JMenuItem("<-添加记录->");
		itemUpdate = new JMenuItem("<-修改记录->");
		itemDelete = new JMenuItem("<-删除记录->");
		//itemClose = new JMenuItem("<-关闭记录->");
		itemShowUser = new JMenuItem("<-显示用户信息->");
		itemUpdatePassword = new JMenuItem("<-修改用户密码->");
		itemCloseUser = new JMenuItem("<-关闭用户信息->");
		itemSex = new JMenuItem("<-性别统计->");
		itemHomeplace = new JMenuItem("<-地域统计->");
		itemAutor = new JMenuItem("<-关于作者->");
		
		iconBackground = new ImageIcon("icon/bg.png");
		iconSystem = new ImageIcon("icon/iconSystem.png");
		iconStudent = new ImageIcon("icon/iconStudent.png");
		iconSetting = new ImageIcon("icon/iconSetting.png");
		iconStatistical = new ImageIcon("icon/iconStatistical.png");
		iconHelp = new ImageIcon("icon/iconHelp.png");
		iconExit = new ImageIcon("icon/iconExit.png");
		iconShow = new ImageIcon("icon/iconShow.png");
		iconSearch = new ImageIcon("icon/iconSearch.png");
		iconAdd = new ImageIcon("icon/iconAdd.png");
		iconUpdate = new ImageIcon("icon/iconUpdate.png");
		iconDelete = new ImageIcon("icon/iconDelete.png");
		//iconClose = new ImageIcon("icon/iconClose.png");
		iconShowUser = new ImageIcon("icon/iconShowUser.png");
		iconUpdatePassword = new ImageIcon("icon/iconUpdatePassword.png");
		iconCloseUser = new ImageIcon("icon/iconCloseUser.png");
		iconSex = new ImageIcon("icon/iconSex.png"); 
		iconHomeplace = new ImageIcon("icon/iconHomeplace.png");		
		iconAutor = new ImageIcon("icon/iconAutor.png");
		
		menuSystem.setIcon(iconSystem);
		menuStudent.setIcon(iconStudent);
		menuSetting.setIcon(iconSetting);
		menuStatistical.setIcon(iconStatistical);
		menuHelp.setIcon(iconHelp);
		itemExit.setIcon(iconExit);
		itemShow.setIcon(iconShow);
		itemSearch.setIcon(iconSearch);
		itemAdd.setIcon(iconAdd);
		itemUpdate.setIcon(iconUpdate);
		itemDelete.setIcon(iconDelete);
		//itemClose.setIcon(iconClose);
		itemShowUser.setIcon(iconShowUser);
		itemUpdatePassword.setIcon(iconUpdatePassword);
		itemCloseUser.setIcon(iconCloseUser);
		itemSex.setIcon(iconSex);
		itemHomeplace.setIcon(iconHomeplace);
		itemAutor.setIcon(iconAutor);
		
		itemExit.addActionListener(this);
		itemShow.addActionListener(this);
		itemSearch.addActionListener(this);
		itemAdd.addActionListener(this);
		itemUpdate.addActionListener(this);
		itemDelete.addActionListener(this);
		//itemClose.addActionListener(this);
		itemShowUser.addActionListener(this);
		itemUpdatePassword.addActionListener(this);
		itemCloseUser.addActionListener(this);
		itemSex.addActionListener(this);
		itemHomeplace.addActionListener(this);
		itemAutor.addActionListener(this);
		
		menuSystem.add(itemExit);
		//menuStudent.add(itemShow);
		menuStudent.add(itemSearch);
		menuStudent.add(itemAdd);
		menuStudent.add(itemUpdate);
		menuStudent.add(itemDelete);
		//menuStudent.add(itemClose);	
		//menuSetting.add(itemShowUser);
		menuSetting.add(itemUpdatePassword);
		//menuSetting.add(itemCloseUser);
		menuStatistical.add(itemSex);
		menuStatistical.add(itemHomeplace);
		menuHelp.add(itemAutor);
		
		menubar.add(menuSystem);
		menubar.add(menuStudent);
		menubar.add(menuSetting);
		menubar.add(menuStatistical);
        menubar.add(menuHelp);  
		
        jp = (JPanel) getContentPane();
        lbl_bg = new JLabel(iconBackground);
        lbl_bg.setBounds(0, 0, iconBackground.getIconWidth(), iconBackground.getIconHeight());
        jp.add(lbl_bg);
        jp.setLayout(null);
        
		setJMenuBar(menubar);
		setBounds(200, 150, 800, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("学生管理系统"+"("+ID+")");
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == itemExit) {//退出
			int flag = JOptionPane.showConfirmDialog(this, "确定退出系统吗？", "退出系统", JOptionPane.YES_NO_OPTION);
			if(flag == 0)
				System.exit(0);
			
		}else if(e.getSource() == itemShow) {
			//
			
		}else if(e.getSource() == itemSearch) {
			new StuQuery();
			
		}else if(e.getSource() == itemAdd) {
			AddFrame addframe = new AddFrame();
			
		}else if(e.getSource() == itemUpdate) {
			UpdateFrame updateframe = new UpdateFrame();
			
		}else if(e.getSource() == itemDelete) {
			DeleteFrame deleteframe = new DeleteFrame();
			
		}else if(e.getSource() == itemClose) {
			//
		}else if(e.getSource() == itemShowUser) {
			//
		}else if(e.getSource() == itemUpdatePassword) {
			String type = "root";
			new ChangePassword(ID,type);
		}else if(e.getSource() == itemCloseUser) {
			//
		}else if(e.getSource() == itemAutor) {
			String information = "JAVA开发小组：\n\n201604301037    黄少童\n201694021015    赵鹏飞\n\n"
					+ "                          2018/8/21\n\n -*-版权所有 翻版必究-*-\n\n";
			JOptionPane.showMessageDialog(this, information, "关于作者", JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource() == itemSex) {
			try {
				new SexPieChart();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource() == itemHomeplace) {
			try {
				new HomeplaceBarChart();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
				
	}
		

}
