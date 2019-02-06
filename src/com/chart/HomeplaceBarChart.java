package com.chart;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class HomeplaceBarChart {
	static Map<String, Integer> map=new HashMap<String, Integer>();
	ChartFrame chartframe;
    public  HomeplaceBarChart() throws Exception{
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
                             "学生地域分布", // 图表标题
                            "学生地域分布统计", // 目录轴的显示标签
                            "数量", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
         
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        
        //实例化chartframe
        chartframe = new ChartFrame("", chart);
        chartframe.setBounds(250, 250, 600, 400);
        chartframe.setDefaultCloseOperation(ChartFrame.DISPOSE_ON_CLOSE);
        chartframe.setVisible(true);
          
    }
       private static CategoryDataset getDataSet() throws Exception {
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           homeplaceCount();
           Set set = map.keySet();
           
           for(Iterator iter = set.iterator(); iter.hasNext();)
           {
            String key = (String)iter.next();
            Integer value = map.get(key);
            dataset.addValue(value, key, key);
            //System.out.println(key+"---"+value);
           }
           return dataset;
       	}

		private static void homeplaceCount() throws Exception {
			final String DRIVER_NAME = "com.mysql.jdbc.Driver";
		    final String DB_URL = "jdbc:mysql://localhost:3306/student_management";
		    final String USER_NAME = "root";
		    final String DB_PASSWD = "123456";
		    Connection con = null;
		    PreparedStatement ps= null;
		    try {
	            Class.forName(DRIVER_NAME);
	            con = DriverManager.getConnection(DB_URL, USER_NAME, DB_PASSWD);
	            String sql = "SELECT stuJg,count( stuJg ) FROM student GROUP BY stuJg";
	            ps = con.prepareStatement(sql);            

	            ResultSet rs = ps.executeQuery();
	            map.clear();
	            while(rs.next()) {
	            	map.put(rs.getString(1), rs.getInt(2));
	            }
	            ps.close();
	            con.close();

	        } catch (ClassNotFoundException cnfe) {
	            cnfe.printStackTrace();
	        } catch (SQLException sqle) {
	            sqle.printStackTrace();
	        }finally {
	        	if(con != null) {
	        		con.close();
	        	}
	        }
		}
}