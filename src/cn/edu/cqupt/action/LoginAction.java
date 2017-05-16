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
 * 登录模块
 * @author Administrator
 * 
 */
public class LoginAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求参数过来的字符编码 utf-8
		req.setCharacterEncoding("utf-8");
		//获得跟随请求 传递过来的的2个参数数据（用户名,密码）
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		//拼接sql
		String sql = "select * from ems_user where username='"+name+"' and pwd='"+pwd+"'";
		// 建立连接
		Connection conn = DBUtil.getConn();
		//执行sql语句
		Statement st = DBUtil.getSt(conn);
		//将查询出来的数据存入结果集中
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//判断rs是否有数据
		try {
			if(rs.next()){
				// 暂时重定向到 list.jsp页面        ↓ 后面需要替换
				resp.sendRedirect("/EMS/list");
			}else{
				System.out.println("没数据");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭所有的流文件，释放资源 
		DBUtil.rsClose(rs);
		DBUtil.stClose(st);
		DBUtil.connClose(conn);
	}
}
