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
 * 修改雇员的逻辑类
 * @author Administrator
 * 需要前端传递过来id name salary age 4个参数
 * 根据id值拼接修改的SQL
 * update ems_emp set name='' and salary ='' and age='' where id=id;
 * 执行完sql后，重定向 list
 */
public class UpdateAction extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 因为参数中涉及到中文，所以约束一下编码为utf-8
		req.setCharacterEncoding("UTF-8");
		// java为基本数据类型提供了各自的包装类，类中具备将字符串转为对应数据类型的方法
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String s = req.getParameter("salary");
		double salary = Double.parseDouble(s);
		int age = Integer.parseInt(req.getParameter("age"));
		// 建立连接 拼接sql 执行sql 
		Connection conn = DBUtil.getConn();
		String sql = "update ems_emp set name='"+name+"',salary="+salary+
									",age="+age+" where id="+id;
		Statement st = DBUtil.getSt(conn);
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//利用响应参数重定向到list(要与web.xml中查询所有雇员的url-parttre的值对应上)
		resp.sendRedirect("/EMS/list");
	}
}
