-- ����һ�����ݿ�ems
create database ems;

-- ����ems_user�û����ݱ�
drop table ems_user;
create table ems_user(
	id int(5) primary key auto_increment,
	username varchar(40),
	realname varchar(40),
	pwd varchar(40),
	sex varchar(1)
);
select * from ems_user;
-- primary key     ����idΪ��������Զ�����ظ���
-- auto_increment  ����  ����������䣬�Ϳ��Է���id�ֶΣ������Զ���1����
-- ��֤ems_user�������ems������ݿ���

--����ems_emp��Ա��������ems���ݿ��У�
drop table ems_emp;
create table ems_emp(
	id int(5) primary key auto_increment,
 	name varchar(40),
 	salary double(6,2), -- 1111.11    6ָ��������С������λ��  2ָ��С����λ��
 	age int(5)
);
insert into ems_emp(name,salary,age) values('1',500.22,1);
insert into ems_emp(name,salary,age) values('44',44,4);
select * from ems_emp;
 
 
update ems_emp set name='qq',salary=555,age=18 where id=1;







