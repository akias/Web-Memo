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
 * ���ദ��ע��ҵ���߼�
 * @author Administrator
 * ��Ҫ�̳�HttpServlet 
 */
public class RegistAction extends HttpServlet {
	//ʵ�֣����ǡ���д��service
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������Ӧ�����ı���  utf-8��
		resp.setCharacterEncoding("utf-8");
		// ������Ӧ��������������������������ˣ�
		PrintWriter pw = resp.getWriter();
		//������������ı��� Ϊ����ͨ���� utf-8
		req.setCharacterEncoding("utf-8");
		//�����������й���������
		// getParameter �Ĳ���ֵΪhtml��  �ı����name����ֵ 
		String username = req.getParameter("username");
		String realname = req.getParameter("realname");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		// ƴ��һ��sql���
		String sql = "insert into ems_user(username,realname,pwd,sex)" +
				"values('"+username+"','"+realname+"','"+pwd+"','"+sex+"')";
		// ����jdbc�Ѹ����ִ�У������ݲ������ݿ⣬���ע�Ṧ�ܣ�
		// �ù�����������
		Connection conn = DBUtil.getConn();
		// ִ��sql ����һ��Statement
		Statement st = DBUtil.getSt(conn);
		// ִ��
		try {
			st.executeUpdate(sql);
			// �滻�ɣ�չ����¼����Ĵ���
			//pw.print("ע��ɹ���������ȥ���ݿ⿴������");
			// �ض��� ��������Ӧ���������ñ��������ٷ�һ�Σ��Զ���ģ�����
			// �ض���ĵڶ���������ǰһ������û�й�ϵ��
			resp.sendRedirect("/EMS/login.jsp");
		} catch (Exception e) {
			// ��ӡ��ջ��Ϣ 
			e.printStackTrace();
			pw.print("sorry ,�����ˣ�������~.~");
		}
		// �ر�
		DBUtil.stClose(st);
		DBUtil.connClose(conn);
	}
}
