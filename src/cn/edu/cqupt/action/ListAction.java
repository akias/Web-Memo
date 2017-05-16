package cn.edu.cqupt.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.entity.Emp;
import cn.edu.cqupt.util.DBUtil;
/**
 * 1��ͨ��JDBC��ѯ���ݿ�
 * 2�������й�Ա��Ϣ���뵽������
 * 3������ʾ��emplist.jspҳ����
 * @author Administrator
 *
 */
public class ListAction extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//PrintWriter out = resp.getWriter();
		// ���� ��Ӧ
		// ����jdbcȥ���ݿ��ѯems_emp���ű���������ݣ������뼯��
		Connection conn = DBUtil.getConn();
		String sql = "select * from ems_emp";
		Statement st = DBUtil.getSt(conn);
		List<Emp> emps = new ArrayList<Emp>();
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				// ����rs��getInt/getString/getDouble ���� ������ݿ���ж�Ӧ�ֶε�ֵ
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				// ����һ���µĹ�Ա���󣬲��������ݿ��ѯ�����ݸ�ֵ���˿չ�Ա����
				Emp emp = new Emp();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				// ������ֵ�Ĺ�Ա������ӽ��뵽������
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// �ض��� ����һ��������Ӧ������
		// ת��      ��δ��ɵ�����ת������һ����ַȥ��ɣ����������
		// ����ת�����ƣ���emps����������ݣ�����emplist.jsp(java����Ƭ��)
		// �Ƚ�Ҫ���ݵ����ݰ󶨵�req���������
		req.setAttribute("emps", emps);
		req.getRequestDispatcher("emplist.jsp").forward(req, resp);
	}
}
