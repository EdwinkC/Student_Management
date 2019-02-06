package com.zhaopengfei;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import com.zhaopengfei.Information.Student;

import static com.zhaopengfei.Information.*;

public class DeleteFrame extends JFrame implements ActionListener{
	
	private JButton btn_stuOut;
    private JPanel jp;
    private JScrollPane jsp_table;
    private JTable table;
    private ArrayList<String> selected_stu = new ArrayList<>();
    private ArrayList<Student> stu_arraylist = new ArrayList<>();

    public DeleteFrame(){
        jp = (JPanel)getContentPane();
        setTitle("删除记录");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(400,170,550,420);
        setResizable(false);
        setVisible(true);
        jp.setBorder(new EmptyBorder(5, 5, 5, 5));
        jp.setLayout(null);

        btn_stuOut = new JButton("删除");
        btn_stuOut.setFont(new Font("宋体", Font.BOLD, 20));
        btn_stuOut.setBounds(220, 350, 100, 25);
        jp.add(btn_stuOut);
        btn_stuOut.addActionListener(this);

        class MyTableModel extends AbstractTableModel{

            String[] column_name = {"学号", "姓名", "性别", "年龄", "籍贯", "专业", "班级号", "成绩", "选择"};;
            Object[][] obj;

            public MyTableModel(){
                stuAll();
                obj = new Object[stu_arraylist.size()][column_name.length];
                for(int i=0;i<stu_arraylist.size();i++){
                    obj[i][0] = stu_arraylist.get(i).id;
                    obj[i][1] = stu_arraylist.get(i).name;
                    obj[i][2] = stu_arraylist.get(i).sex;
                    obj[i][3] = stu_arraylist.get(i).age;
                    obj[i][4] = stu_arraylist.get(i).homeplace;
                    obj[i][5] = stu_arraylist.get(i).major;
                    obj[i][6] = stu_arraylist.get(i).classes;
                    obj[i][7] = stu_arraylist.get(i).sourse;
                    obj[i][8] = new Boolean(false);
                    
                }
            }

            

			//定义每列的数据类型
            Class[] typeArray = { Object.class, Object.class, Object.class, Object.class,
                    Object.class, Object.class, Object.class, Object.class, Boolean.class };

            /**
             * 获得表格的列名称
             */
            @Override

            public String getColumnName(int column) {

                return column_name[column];

            }
            /**
             * 重写方法，得到表格列数
             */
            @Override
            public int getColumnCount()
            {
                return column_name.length;
            }

            public int getRowCount(){
                return obj.length;
            }
            /**
             * 得到数据所对应对象
             */
            @Override
            public Object getValueAt(int rowIndex, int columnIndex)
            {
                return obj[rowIndex][columnIndex];
            }


            /**
             * 使表格具有可编辑性
             */

            @Override

            public boolean isCellEditable(int rowIndex, int columnIndex) {

                if(columnIndex == 8)
                    return true;
                else
                    return false;

            }


            /**
             * 替换单元格的值
             */
            @Override

            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

                obj[rowIndex][columnIndex] = aValue;

                fireTableCellUpdated(rowIndex, columnIndex);

                selected_stu.clear();
                for(int i=0;i<getRowCount();i++){
                    String stu_no = (String) getValueAt(i, 0);
                    if((Boolean)getValueAt(i, 8)){

                        selected_stu.add(stu_no);
                    }
                    else{
                        for(int j=0;j<selected_stu.size();j++){
                            if(selected_stu.get(j) == stu_no){
                                selected_stu.remove(i);
                            }
                        }
                    }
                }

            }

            /**
             *返回列的数据类型
             */
            @Override
            public Class getColumnClass(int columnIndex){
                return typeArray[columnIndex];// 返回每一列的数据类型
            }

        }


        table = new JTable(new MyTableModel());
        jsp_table = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp_table.setBounds(10,20,520,300);
        jp.add(jsp_table);


    }


    public void actionPerformed (ActionEvent event){
        if(selected_stu.size() == 0){
            JOptionPane.showMessageDialog(this, "请选择至少一个学生！");
            return;
        }

        for(String s:selected_stu){
        	int falg = JOptionPane.showConfirmDialog(this, "你确定要删除" + s + "吗？", "", JOptionPane.YES_NO_OPTION);
        	if(falg == 0) {
        		if(deleteRecord(s)){
                    JOptionPane.showMessageDialog(this,s + "：删除成功！");
                  //刷新
                    this.dispose();
                    new DeleteFrame();
                }
                else{
                    JOptionPane.showMessageDialog(this,s + "：删除失败！");
                }
        	}   
        }
    }

    /**
     * select 全体学生
     */
    private void stuAll() {
        try {
            Class.forName(DRIVER_NAME);
            Connection con = DriverManager.getConnection(DB_URL, USER_NAME, DB_PASSWD);
            Statement sta = con.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet rs = sta.executeQuery(sql);

            stu_arraylist.clear();//清空

            while(rs.next()){
            	Student stu = new Student();
            	stu.id = rs.getString("stuId");
            	stu.name = rs.getString("stuName");
				stu.sex = rs.getString("stuSex");
				stu.homeplace = rs.getString("stuJg");
				stu.major = rs.getString("stuZy");
				stu.classes = rs.getString("classId");
				stu.age = rs.getInt("stuAge");
				stu.sourse = rs.getFloat("stuSourse");
                stu_arraylist.add(stu);//添加
            }
            rs.close();
            sta.close();
            con.close();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
	}
    
	private boolean deleteRecord(String id) {
		try {
            Class.forName(DRIVER_NAME);
            Connection con = DriverManager.getConnection(DB_URL, USER_NAME, DB_PASSWD);
            String sql = "DELETE FROM student WHERE stuId=?";
            PreparedStatement ps = con.prepareStatement(sql);           
            ps.setString(1, id);          
            int c = ps.executeUpdate();
            if(c >= 1){
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
