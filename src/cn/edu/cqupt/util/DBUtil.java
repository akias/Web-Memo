package cn.edu.cqupt.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接的工具类
 * 
 * @author GUOGANG
 * 
 */
public class DBUtil {
	// 建立连接
	public static Connection getConn() {
		// 初始化一个连接对象，赋值为空
		Connection conn = null;
		String url = "";
		String user = "";
		String password = "";
		//1、创建空的  properties对象（创造一张白纸）
		Properties pro = new Properties();
		//2、加载数据（给这张白纸贴上数据）
		try {
			pro.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//3、通过properties.getProperty("配置文件的key值") 获得配置文件的数据信息
		url = pro.getProperty("url");
		user =  pro.getProperty("user");
		password = pro.getProperty("password");
		//测试此3个数据是否传递过来
		// 给该连接对象赋值
		try {// try表示执行
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(
					url, user, password);
		} catch (SQLException e) {// catch捕捉，前提是try内的代码出现了异常
			e.printStackTrace(); // 如果try内没有异常，catch是不会被执行的
		}
		// 返回该连接
		return conn;
	}

	// 根据连接创建statement update-7月28日 周二AM11:30
	public static Statement getSt(Connection conn){
		Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
	// 关闭连接流（conn st rs）
	public static void connClose(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// 空指针异常
		}
	}
	// 关闭statement流
	public static void stClose(Statement st){
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// 空指针异常
		}
	}
	// 关闭 ResultSet 流
	public static void rsClose(ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// 空指针异常
		}
	}
}
