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

import cn.edu.cqupt.entity.Emp;
import cn.edu.cqupt.util.DBUtil;
/**
 * �޸��߼�
 * �������󴫵ݹ�����id���� ����ʽ��http://localhost:8080/EMS/load?id=1��
 * ����id=1 ��ѯ���ݿ⣬�����ݿ��ѯ�õ������ݣ�Emp���󣩣���ʾ��ת������updateEmp.jsp������
 * @author Administrator
 *
 */
public class LoadAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�������󴫵ݹ����Ĳ���
		String s = req.getParameter("id");
		// Integer ��  int�İ�װ��
		// ��������򴫵ݹ�����idֵ
		int id = Integer.parseInt(s);
		// �������ݿ⣬ƴ��sql��ִ��sql���Ѳ�ѯ�����ݴ���Emp�����
		Connection conn = DBUtil.getConn();
		String sql = "select * from ems_emp where id="+id;
		Statement st = DBUtil.getSt(conn);
		ResultSet rs = null;
		// ����һ���յĹ�Ա���󣬵ȴ���try�е����ݸ��丳ֵ
		Emp emp = new Emp();
		try {
			rs = st.executeQuery(sql);
			// ��Ϊ�޸������Ǵ� �б���淢�����ģ�ֻ�и������Ǵ��ڵ�����£�������Żᷢ�͡�
			// ����ֻ��Ҫ�ѽ�������α���0�ƶ���1����ȡ������ݼ���
			rs.next();
			String name = rs.getString("name");
			double salary = rs.getDouble("salary");
			int age = rs.getInt("age");
			emp.setId(id);
			emp.setName(name);
			emp.setSalary(salary);
			emp.setAge(age);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// �������Ա����empת���� updateEmp.jsp �������
		// �Ƚ���Ա����󶨵����������
		req.setAttribute("emp", emp);
		// ת���������������������ض��������Ӧ������
		req.getRequestDispatcher("updateEmp.jsp").forward(req, resp);
	}
}
