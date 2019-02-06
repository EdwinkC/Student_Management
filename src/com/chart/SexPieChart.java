package com.chart;


import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class SexPieChart {
	ChartFrame chartframe;
	public SexPieChart() throws Exception {
		DefaultPieDataset data = getDataSet();
		JFreeChart chart = ChartFactory.createPieChart3D("学生性别比例", data, true, false, false);
		PiePlot pieplot = (PiePlot)chart.getPlot();
		DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
		NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
		StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
        pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
      //没有数据的时候显示的内容
        pieplot.setNoDataMessage("无数据显示");
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02D);
     
        pieplot.setIgnoreNullValues(true);//设置不显示空值
        pieplot.setIgnoreZeroValues(true);//设置不显示负值
        
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
        piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
        
        chartframe = new ChartFrame("", chart);
        chartframe.setBounds(250, 250, 600, 400);
        chartframe.setDefaultCloseOperation(ChartFrame.DISPOSE_ON_CLOSE);
        chartframe.setVisible(true);
        
	}
	private static DefaultPieDataset getDataSet() throws Exception {
		 DefaultPieDataset dataset = new DefaultPieDataset();
		 dataset.setValue("女生", sexCount("女"));
	     dataset.setValue("男生",sexCount("男"));
	     return dataset;
	}
	
	
	private static int sexCount(String sex) throws Exception {
		final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	    final String DB_URL = "jdbc:mysql://localhost:3306/student_management";
	    final String USER_NAME = "root";
	    final String DB_PASSWD = "123456";
	    Connection con = null;
	    PreparedStatement ps= null;
	    try {
            Class.forName(DRIVER_NAME);
            con = DriverManager.getConnection(DB_URL, USER_NAME, DB_PASSWD);
            String sql = "SELECT count(*) FROM student WHERE stuSex = ?";
            ps = con.prepareStatement(sql);            
            ps.setString(1, sex);      
            int count=0;
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	count = rs.getInt(1);
            	//System.out.println(count);
            }
            ps.close();
            con.close();
            return count;
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }finally {
        	if(con != null) {
        		con.close();
        	}
        }
		return -1;
	}

}
