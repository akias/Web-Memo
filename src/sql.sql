-- 创建一个数据库ems
create database ems;

-- 建立ems_user用户数据表
drop table ems_user;
create table ems_user(
	id int(5) primary key auto_increment,
	username varchar(40),
	realname varchar(40),
	pwd varchar(40),
	sex varchar(1)
);
select * from ems_user;
-- primary key     设置id为主键（永远不能重复）
-- auto_increment  自增  后续插入语句，就可以放弃id字段，他会自动从1增长
-- 保证ems_user这个表在ems这个数据库中

--建立ems_emp雇员表（创建到ems数据库中）
drop table ems_emp;
create table ems_emp(
	id int(5) primary key auto_increment,
 	name varchar(40),
 	salary double(6,2), -- 1111.11    6指代整数加小数的总位数  2指代小数的位数
 	age int(5)
);
insert into ems_emp(name,salary,age) values('1',500.22,1);
insert into ems_emp(name,salary,age) values('44',44,4);
select * from ems_emp;
 
 
update ems_emp set name='qq',salary=555,age=18 where id=1;







