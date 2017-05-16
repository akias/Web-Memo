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
 * 1、通过JDBC查询数据库
 * 2、将所有雇员信息存入到集合中
 * 3、再显示到emplist.jsp页面中
 * @author Administrator
 *
 */
public class ListAction extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//PrintWriter out = resp.getWriter();
		// 请求 响应
		// 利用jdbc去数据库查询ems_emp这张表的所有数据，并存入集合
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
				// 根据rs的getInt/getString/getDouble 方法 获得数据库表中对应字段的值
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				// 创建一个新的雇员对象，并将从数据库查询的数据赋值给此空雇员对象
				Emp emp = new Emp();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				// 将赋了值的雇员对象，添加进入到集合中
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 重定向 发另一个请求（响应参数）
		// 转发      将未完成的事情转交给下一个地址去完成（请求参数）
		// 利用转发机制，把emps这个集合数据，发给emplist.jsp(java代码片段)
		// 先将要传递的数据绑定到req请求参数中
		req.setAttribute("emps", emps);
		req.getRequestDispatcher("emplist.jsp").forward(req, resp);
	}
}
