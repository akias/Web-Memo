package cn.edu.cqupt.entity;
/**
 * 用户对象实体类
 * @author Administrator
 * 本类的属性对应的ems_user这张表的字段
 */
public class User {
	// id序号
	private int id;
	// 用户名
	private String username;
	// 真实姓名
	private String realname;
	// 密码
	private String pwd;
	// 性别
	private String sex;
	// 私有化属性的get set 方法
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
	// 自定义的toString方法
	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", realname=" + realname
				+ ", sex=" + sex + ", username=" + username + "]";
	}
	
	
}
