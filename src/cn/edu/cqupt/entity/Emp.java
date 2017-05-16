package cn.edu.cqupt.entity;
/**
 * 雇员实体类
 * @author Administrator
 *
 */
public class Emp {
	// 序号
	private int id;
	// 雇员姓名
	private String name;
	// 雇员工资
	private double salary;
	// 年龄
	private int age;
	// 各个属性对应的get set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// toString 方法重写
	@Override
	public String toString() {
		return "Emp [age=" + age + ", id=" + id + ", name=" + name
				+ ", salary=" + salary + "]";
	}
}
