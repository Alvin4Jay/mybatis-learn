# MySQL练习

## 一、数据库创建

1.创建一个名为mydb1的数据库:

```mysql
create database if not exists mydb1;
create database if not exists mydb2 character set utf8mb4;
create database if not exists mydb3 character set utf8mb4 collate utf8mb4_general_ci;
```

2.查看数据库

```mysql
show databases;
```

3.查看数据库创建语句(定义信息)：

```mysql
show create database mydb2;
```

4.数据库删除：

```mysql
drop database if exists mydb1;
```

5.修改数据库定义信息：

```mysql
alter database mydb2 character set utf8;
```

6.备份和恢复数据库：

```mysql
mysqldump为shell脚本：
./mysqldump -u 用户名 -p 数据库名 > xxx.sql

sql语句：
source xxx.sql
```

## 二、创建表

1.创建一个员工表

```mysql
create table employee (
    id int,
    name varchar(40),
    sex varchar(4),
    birthday date,
    entry_date date,
    job varchar(40),
    salary decimal(8, 2),
    resume text
)
```

2.查看库的所有表

```mysql
show tables;
```

3.查看表的创建细节

```mysql
show create table employee;
```

4.查看表结构

```mysql
desc employee;
```

5.修改表

- 增加image列

  ```mysql
  alter table employee add image blob;
  ```

- 修改job列

  ```mysql
  alter table employee modify job varchar(60);
  ```

- 删除set列

  ```mysql
  alter table employee drop sex;
  ```

- 表名修改为user

  ```mysql
  rename table employee to user;
  ```

- 修改表的字符集

  ```mysql
  alter table user character set utf8;
  ```

- 修改列名

  ```mysql
  alter table user change column name username varchar(20);
  ```

6.删除表

```mysql
drop table user;
```

## 三、增删改

1.插入数据(字符串、日期用单引号''包含)

```mysql
insert into employee(id, name, sex, birthday, entry_date, job, salary, resume) values(1, 'aaa', '男', '1992-10-20', '2018-04-09', 'bbb', 98.00, 'aaaaa');
```

2.修改数据

```mysql
update employee set salary=3000 where name='张三';
update employee set salary=3000, job='ccc' where name='aaa';
update employee set salary=salary+1000 where name='张三';
```

3.删除数据

```mysql
delete from employee where name='bbb';

使用truncate删除表中记录。
truncate table employee;
```

## 四、查询

```mysql
查询表中所有学生的信息。
select * from student;

查询表中所有学生的姓名和对应的英语成绩。
select name,english from student;

过滤表中重复的英语数据。
select distinct english from student;

在所有学生总分上加10分特长分。
select name,(chinese+english+math)+10 from student;

统计每个学生的总分。
select name,(chinese+english+math) from student;

使用别名表示学生分数。
select name as 姓名,(chinese+english+math)+10 as 总分 from student;
select name 姓名,(chinese+english+math)+10  总分 from student;

查询姓名为王五的学生成绩
select * from student where name='王五';

查询英语成绩大于90分的同学
select * from student where english>'90';

查询总分大于200分的所有同学
select name from student where (chinese+english+math)>200;

查询英语分数在 80－90之间的同学。
select name from student where english>80 and english<90;
select name from student where english between 80 and 90;  == select name from student where english>=80 and english<=90;

查询数学分数为89,90,91的同学。
select * from student where math in(89,90,91);

查询所有姓李的学生成绩。
select * from student where name like '李%';
select * from student where name like '李_';


查询数学分>80，语文分>80的同学。
select * from student where math>80 and chinese>80;

对数学成绩排序后输出。
select name,math from student order by math; 

对总分排序后输出，然后再按从高到低的顺序输出
select name 姓名,(chinese+english+math) 总分 from student order by (chinese+english+math) desc;
select name 姓名,(chinese+english+math) 总分 from student order by 总分 desc;

对姓李的学生成绩排序输出
select * from student where name like '李%' order by (chinese+english+math) desc;

统计一个班级共有多少学生？
select count(name) from student;
select count(*) from student;

统计数学成绩大于90的学生有多少个？
select count(*) from student where math>80;

统计总分大于250的人数有多少？
select count(*) from student where (chinese+english+math)>250;

关于 count的函数的细节 （count只统有值的行）


统计一个班级数学总成绩？
select sum(math) from student;

统计一个班级语文、英语、数学各科的总成绩
select sum(chinese),sum(english),sum(math) from student;

统计一个班级语文、英语、数学的成绩总和
select sum(chinese+english+math) from student;

统计一个班级语文成绩平均分
select sum(chinese)/count(*) from student;

统计一个班级语文成绩平均分
select avg(chinese) from student;

求一个班级总分平均分
select avg(chinese+math+english) from student;

求班级最高分和最低分
select max(chinese+math+english),min(chinese+math+english) from student;

对订单表中商品归类后，显示每一类商品的总价
select product,sum(price) from orders group by product;

查询购买了几类商品，并且每类总价大于100的商品
select product from orders group by product having sum(price)>100;
```

## 五、约束(index、key)

```mysql
定义主键约束（每一个表必须有一个主键列）
create table student
(
	id int  primary key,
	name varchar(40)
);

定义主键自动增长
create table student
(
	id int  primary key auto_increment,
	name varchar(40)
);

定义唯一约束
drop table student;
create table student
(
	id int primary key auto_increment,
	name varchar(40) unique
);

定义非空约束
drop table student;
create table student
(
	id int primary key auto_increment,
	name varchar(40) unique not null
);

定义外键约束
create table husband
(
	id int primary key,
	name varchar(40)
);

create table wife
(
	id int primary key,
	name varchar(40),
	husband_id int,
	constraint husband_id_FK foreign key(husband_id) references husband(id)
);
```

## 六、数据库表的设计

```mysql
一对多或多对一的对象存到数据库时，表的设计方案
部门和员工
create table department
(
	id int primary key,
	name varchar(40)
);

create table employee
(
	id int primary key,
	name varchar(40),
	salary decimal(8,2),
	department_id int,
	constraint department_id_FK foreign key(department_id) references department(id)
);


多对多对象的表的设计（老师和学生）
create table teacher
(
	id int primary key,
	name varchar(40),
	salary decimal(8,2)
);

create table student
(
	id int primary key,
	name varchar(40)
);

create table teacher_student
(
	teacher_id int,
	student_id int,
	primary key(teacher_id,student_id),
	constraint teacher_id_FK foreign key(teacher_id) references teacher(id),
	constraint student_id_FK foreign key(student_id) references student(id)	
);



一对一的对象的数据库设计
create table person
(
	id int primary key,
	name varchar(40)
);

create table idcard
(
	id int primary key,
	city varchar(40),
	constraint id_FK foreign key(id) references person(id)	
);
```

## 七、自关联对象的数据库设计

```mysql
自连接的表
create table person
(
	id int primary key,
	name varchar(40),
	parent_id int,
	constraint parent_id_FK foreign key(parent_id) references person(id)
);
```







