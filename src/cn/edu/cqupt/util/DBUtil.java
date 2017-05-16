package cn.edu.cqupt.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ���ݿ����ӵĹ�����
 * 
 * @author GUOGANG
 * 
 */
public class DBUtil {
	// ��������
	public static Connection getConn() {
		// ��ʼ��һ�����Ӷ��󣬸�ֵΪ��
		Connection conn = null;
		String url = "";
		String user = "";
		String password = "";
		//1�������յ�  properties���󣨴���һ�Ű�ֽ��
		Properties pro = new Properties();
		//2���������ݣ������Ű�ֽ�������ݣ�
		try {
			pro.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//3��ͨ��properties.getProperty("�����ļ���keyֵ") ��������ļ���������Ϣ
		url = pro.getProperty("url");
		user =  pro.getProperty("user");
		password = pro.getProperty("password");
		//���Դ�3�������Ƿ񴫵ݹ���
		// �������Ӷ���ֵ
		try {// try��ʾִ��
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(
					url, user, password);
		} catch (SQLException e) {// catch��׽��ǰ����try�ڵĴ���������쳣
			e.printStackTrace(); // ���try��û���쳣��catch�ǲ��ᱻִ�е�
		}
		// ���ظ�����
		return conn;
	}

	// �������Ӵ���statement update-7��28�� �ܶ�AM11:30
	public static Statement getSt(Connection conn){
		Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
	// �ر���������conn st rs��
	public static void connClose(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// ��ָ���쳣
		}
	}
	// �ر�statement��
	public static void stClose(Statement st){
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// ��ָ���쳣
		}
	}
	// �ر� ResultSet ��
	public static void rsClose(ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// ��ָ���쳣
		}
	}
}
