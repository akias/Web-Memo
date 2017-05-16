package cn.edu.cqupt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.util.DBUtil;
/**
 * 本类处理注册业务逻辑
 * @author Administrator
 * 需要继承HttpServlet 
 */
public class RegistAction extends HttpServlet {
	//实现（覆盖、重写）service
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置响应参数的编码  utf-8、
		resp.setCharacterEncoding("utf-8");
		// 根据相应参数创建输出流（输出到浏览器端）
		PrintWriter pw = resp.getWriter();
		//设置请求参数的编码 为世界通用码 utf-8
		req.setCharacterEncoding("utf-8");
		//获得请求参数中过来的数据
		// getParameter 的参数值为html中  文本框的name属性值 
		String username = req.getParameter("username");
		String realname = req.getParameter("realname");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		// 拼接一个sql语句
		String sql = "insert into ems_user(username,realname,pwd,sex)" +
				"values('"+username+"','"+realname+"','"+pwd+"','"+sex+"')";
		// 利用jdbc把该语句执行（将数据插入数据库，完成注册功能）
		// 用工具类获得连接
		Connection conn = DBUtil.getConn();
		// 执行sql 创建一个Statement
		Statement st = DBUtil.getSt(conn);
		// 执行
		try {
			st.executeUpdate(sql);
			// 替换成，展开登录界面的代码
			//pw.print("注册成功，请自行去数据库看。。。");
			// 重定向 （利用响应参数），让本次请求，再发一次（自定义的）请求
			// 重定向的第二次请求，与前一次请求没有关系。
			resp.sendRedirect("/EMS/login.jsp");
		} catch (Exception e) {
			// 打印堆栈信息 
			e.printStackTrace();
			pw.print("sorry ,出错了！！！！~.~");
		}
		// 关闭
		DBUtil.stClose(st);
		DBUtil.connClose(conn);
	}
}
