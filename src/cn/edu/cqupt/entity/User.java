package cn.edu.cqupt.entity;
/**
 * �û�����ʵ����
 * @author Administrator
 * ��������Զ�Ӧ��ems_user���ű���ֶ�
 */
public class User {
	// id���
	private int id;
	// �û���
	private String username;
	// ��ʵ����
	private String realname;
	// ����
	private String pwd;
	// �Ա�
	private String sex;
	// ˽�л����Ե�get set ����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	// �Զ����toString����
	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", realname=" + realname
				+ ", sex=" + sex + ", username=" + username + "]";
	}
	
	
}
