package cn.edu.cqupt.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.util.DBUtil;
/**
 * �޸Ĺ�Ա���߼���
 * @author Administrator
 * ��Ҫǰ�˴��ݹ���id name salary age 4������
 * ����idֵƴ���޸ĵ�SQL
 * update ems_emp set name='' and salary ='' and age='' where id=id;
 * ִ����sql���ض��� list
 */
public class UpdateAction extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ��Ϊ�������漰�����ģ�����Լ��һ�±���Ϊutf-8
		req.setCharacterEncoding("UTF-8");
		// javaΪ�������������ṩ�˸��Եİ�װ�࣬���о߱����ַ���תΪ��Ӧ�������͵ķ���
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String s = req.getParameter("salary");
		double salary = Double.parseDouble(s);
		int age = Integer.parseInt(req.getParameter("age"));
		// �������� ƴ��sql ִ��sql 
		Connection conn = DBUtil.getConn();
		String sql = "update ems_emp set name='"+name+"',salary="+salary+
									",age="+age+" where id="+id;
		Statement st = DBUtil.getSt(conn);
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//������Ӧ�����ض���list(Ҫ��web.xml�в�ѯ���й�Ա��url-parttre��ֵ��Ӧ��)
		resp.sendRedirect("/EMS/list");
	}
}
