package cn.edu.cqupt.entity;
/**
 * ��Աʵ����
 * @author Administrator
 *
 */
public class Emp {
	// ���
	private int id;
	// ��Ա����
	private String name;
	// ��Ա����
	private double salary;
	// ����
	private int age;
	// �������Զ�Ӧ��get set����
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
	// toString ������д
	@Override
	public String toString() {
		return "Emp [age=" + age + ", id=" + id + ", name=" + name
				+ ", salary=" + salary + "]";
	}
}
