package cn.edu.cqupt.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.util.DBUtil;

/**
 * ��¼ģ��
 * @author Administrator
 * 
 */
public class LoginAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������������ַ����� utf-8
		req.setCharacterEncoding("utf-8");
		//��ø������� ���ݹ����ĵ�2���������ݣ��û���,���룩
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		//ƴ��sql
		String sql = "select * from ems_user where username='"+name+"' and pwd='"+pwd+"'";
		// ��������
		Connection conn = DBUtil.getConn();
		//ִ��sql���
		Statement st = DBUtil.getSt(conn);
		//����ѯ���������ݴ���������
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ж�rs�Ƿ�������
		try {
			if(rs.next()){
				// ��ʱ�ض��� list.jspҳ��        �� ������Ҫ�滻
				resp.sendRedirect("/EMS/list");
			}else{
				System.out.println("û����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//�ر����е����ļ����ͷ���Դ 
		DBUtil.rsClose(rs);
		DBUtil.stClose(st);
		DBUtil.connClose(conn);
	}
}
