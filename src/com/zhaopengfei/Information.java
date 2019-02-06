package com.zhaopengfei;

public class Information {
	//数据库连接字
	final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3306/student_management";
    final static String USER_NAME = "root";
    final static String DB_PASSWD = "123456";
    
    public static String ID;
    
    static public class Student{
    	String id;
    	String name;
    	String sex;
    	int age;
    	String homeplace;
    	String major;
    	String classes;
    	float sourse;
    }

}

