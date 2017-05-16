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
 * 修改逻辑
 * 根据请求传递过来的id参数 （格式：http://localhost:8080/EMS/load?id=1）
 * 根据id=1 查询数据库，将数据库查询得到的数据（Emp对象），显示（转发）到updateEmp.jsp界面上
 * @author Administrator
 *
 */
public class LoadAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//接收请求传递过来的参数
		String s = req.getParameter("id");
		// Integer 是  int的包装类
		// 获得了请球传递过来的id值
		int id = Integer.parseInt(s);
		// 连接数据库，拼接sql，执行sql，把查询的数据存入Emp类对象
		Connection conn = DBUtil.getConn();
		String sql = "select * from ems_emp where id="+id;
		Statement st = DBUtil.getSt(conn);
		ResultSet rs = null;
		// 创建一个空的雇员对象，等待着try中的数据给其赋值
		Emp emp = new Emp();
		try {
			rs = st.executeQuery(sql);
			// 因为修改请求是从 列表界面发过来的，只有该数据是存在的情况下，该请求才会发送。
			// 所以只需要把结果集的游标由0移动到1，读取相关数据即可
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
		// 把这个雇员对象emp转发到 updateEmp.jsp 这个界面
		// 先将雇员对象绑定到请求参数中
		req.setAttribute("emp", emp);
		// 转发都是针对于请求参数（重定向才是响应参数）
		req.getRequestDispatcher("updateEmp.jsp").forward(req, resp);
	}
}
