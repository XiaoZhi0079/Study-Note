# MySQL

## MySQL介绍

MySQL属于关系型数据库。关系型数据库还有SQL Server, Oracle, MariaDB（MySQL创始人开发的底层逻辑与MySQL一致的数据路）, DB2数据库。

非关系型数据库：Redis,ES

##### MySQL的特性

MySQL区别于其它关系型数据库很大的一个特点就是支持插件式的存储引擎,支持如InnoDB, MyISAM, Memory等
目前google、腾讯、淘宝、百度、新浪、facebook等公司都在使用MySQL作为数据存储层方案
MySQL设计成C/S模型
MySQL的服务器模型采用的是I/O复用+可伸缩的线程池,是实现网络服务器的经典模型

## MySQL数据类型

MySQL数据类型定义了数据的大小范围, 因此使用时选择合适的类型, 不仅会降低表占用的磁盘空间, 间接减少了磁盘I/O的次数, 提高了表的访问效率, 而且索引的效率也和数据的类型息息相关。

### 数据类型

#### 数值类型

Tip：float，double在精度方面不适合做金融，和其他需要高精度的计算，在MySQL中应该使用Decimal字段，在java中应使用BigDecimal类。

![image-20251018220447732](./media/image-20251018220447732.png)

#### 字符串类型

![image-20251018220509273](./media/image-20251018220509273.png)

#### 日期和时间类型

![image-20251018220526212](./media/image-20251018220526212.png)

#### 枚举类和SET

这两个类型,都是限制该字段只能取固定的值,但是枚举字段只能取一个唯一的值,而集合字段可以取任意个值。

**枚举类的应用**

```
-- 创建用户表      
CREATE TABLE `user` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  -- 枚举类型：性别（单选）
  `gender` ENUM('男', '女', '未知') DEFAULT '未知',
  `age` TINYINT UNSIGNED
);
```

**set的应用**

```
-- 创建文章表
CREATE TABLE `article` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  -- 集合类型：标签（多选）
  `tags` SET('技术', '编程', 'MySQL', 'Java') DEFAULT '',
  `content` TEXT
);
```



## MySQL运算符

Tip：运算时要注意，不要越界，精度也要考虑。

算术运算符

![image-20251018220658670](./media/image-20251018220658670.png)

逻辑运算符

![image-20251018220714819](./media/image-20251018220714819.png)

比较运算符

![image-20251018220729016](./media/image-20251018220729016.png)

## MySQL的常用函数

### 时间和日期函数

![image-20251018220838338](./media/image-20251018220838338.png)

### 聚合函数

count sum min max avg

### 数学函数

```
(1) 绝对值函数：ABS(x) 用于返回 x 的绝对值

(2) 返回圆周率的函数：PI() PI() 返回圆周率值

(3) 平方根函数：SQRT(x) SQRT(x) 返回非负数 x 的二次方根

(4) 求余函数：MOD(x,y) MOD(x,y) 返回 x 被 y 除后的余数，MOD(x,y) 对于带有小数部分的数值也起作用，它 返回除法运算后的精确余数

(5) 获取整数的函数：CEIL(x) 、CEILING(x) 、FLOOR(x) CEIL(x) 用于返回不小于 x 的最小整数值

​	CEILING(x) 用于返回不小于 x 的最小整数

​	FLOOR(x) 返回不大于 x 的最大整数值

(6) 获取随机数的函数：RAND() 、RAND(x) RAND() 用于返回一个随机浮点值，范围在 0 ~ 1 之间

​	RAND(x) 用于返回一个随机浮点值，范围在 0~1 之间，x 被用作种子值，用来产生重复序列

(7) 四舍五入的函数：ROUND(x) 、ROUND(x,y) ROUND(x) 用于对 x 进行四舍五入

​	ROUND(x,y) 用于对 x 进行四舍五入，并保留小数点后 y 位

(8) 截取数值的函数：TRUNCATE(x,y) TRUNCATE(x,y) 用于对 x 进行截取，结果保留小数点后 y 位

(9) 符号函数：SIGN(x) SIGN(x) 用于返回参数 x 的符号，当 x 为负数时返回 -1 ，当 x 为正数时返回 1 ， 当 x 为 零时返回 0

(10) 幂运算函数：POW(x,y) 、POWER(x,y) 、EXP(x) POW(x,y) 用于返回 x 的 y 次方的结果

(11) 对数运算函数：LOG(x) 、LOG10(x) LOG(x) 返回 x 的自然对数

​	使用 LOG10(x) 计算以 10 为基数的对数

(12) 角度与弧度相互转换的函数：RADIANS(x) 、DEGREES(x) RADIANS(x) 用于将参数 x 由角度转化为弧度

​	DEGREES(x) 用于将参数 x 由弧度转化为角度

(13) 正弦函数和反正弦函数：SIN(x) 、ASIN(x) SIN(x) 用于返回 x 的正弦值，其中 x 为弧度值

​	ASIN(x) 用于返回 x 的反正弦，即正弦为 x 的值

(14) 余弦函数和反余弦函数：COS(x) 、ACOS(x) COS(x) 用于返回 x 的余弦，其中 x 为弧度值

​	ACOS(x) 用于返回 x 的反余弦，即余弦是 x 的值

(15) 正切函数、反正切函数、余切函数：TAN(x) 、ATAN(x) 、COT(x) TAN(x) 返回 x 的正切，其中 x 为给定的弧 度值

​	ATAN(x) 用于返回 x 的反正切，即正切为 x 的值

​	COT(x) 用于返回 x 的余切

```



## MySQL完整性约束

### 主键约束----->主键索引

primary key：不能为空 不能重复  存在联合主键       //  InnoDB引擎要求一定要有主键约束，即使不指定也会自动生成。

### 自增键约束

auto_increment：自增，只能用于整数类型的字段，下一条数据默认+1

### 唯一键约束----->唯一键索引

unique：不能重复

### 非空约束

not null：不能为空

### 默认约束

default：给字段一个默认值

### 外键约束

foreign key：外键

### 案例

![image-20251018224610351](./media/image-20251018224610351.png)

tip：现在的开发中，由于MySQL的性能问题，外键，存储函数，存储过程，触发器这些逻辑由后端业务控制。

因为后端业务大多发生在内存中 内存速度很快 而MySQL经常要有磁盘的IO，速度很慢。

## 关系型数据库表设计

tip：

一对一 / 一对多 / 多对多，说的是**实体实例（也就是两边表里的一条条记录/行）之间的“基数”关系**，而不是“整张表对整张表”的关系。

一对一：用户表和用户信息表 用户表中的一条数据在用户信息表中对应的只有一条。

一对多：作者表和书籍表，作者有多本书，书籍表中有多条数据与一个作者对应。

多对多：学生表和课程表，学生可以选多门课，一门课有很多学生选，多对多对应。

### 一对一：子表增加一列 关联父表的主键或唯一键

![image-20251020132725934](./media/image-20251020132725934.png)

### 一对多：子表增加一列 关联父表的主键或唯一键

图中 用户表的uid与订单表有一对多的关系

![image-20251020133536833](./media/image-20251020133536833.png)

### 多对多：增加一个中间表

## 关系型数据库范式

Tip:数据库表的范式类似于代码的解耦。好比说把一张囊括了很多内容的表分割成课程表 学生表 教师表

应用数据库范式可以带来许多好处,但是最重要的好处归结为三点:

1.减少数据冗余(这是最主要的好处,其他好处都是由此而附带的)
2.消除异常(插入异常,更新异常,删除异常)
3.让数据组织的更加和谐
但是数据库范式绝对不是越高越好,范式越高,意味着表越多,多表联合查询的机率就越大,SQL的效率就变低。

### 第一范式

Tip：

元组：一条（行）数据的概念。

属性：列的概念。 

![image-20251020171226506](./media/image-20251020171226506.png)

![image-20251020171447412](./media/image-20251020171447412.png)

### 第二范式

![image-20251020171746548](./media/image-20251020171746548.png)

![image-20251020171920672](./media/image-20251020171920672.png)

### 第三范式

传递依赖：即两个非主属性相互完全依赖

![image-20251020172557370](./media/image-20251020172557370.png)

## Mysql使用命令

### 登录

```
mysql -u root -p password    //root用户带密钥登录
mysql -u root -p password -h 域名 -P port   //远程连接
```

**常用选项**

![image-20251217155342933](./media/image-20251217155342933.png)

### 管理用户

#### 查看用户

```
//默认有3个用户 一个root用户，两个系统内置用户，两个系统内置用户用户内部操作，默认被锁定
mysql> select user,host from mysql.user;
+---------------+-----------+
| user          | host      |
+---------------+-----------+
| mysql.session | localhost |
| mysql.sys     | localhost |
| root          | localhost |
+---------------+-----------+
3 rows in set (0.00 sec)
```

#### 创建用户

```
CREATE USER [IF NOT EXISTS] '用户名'@'主机名' IDENTIFIED BY '密码';
```

**示例**

```
//仅允许本地登录
mysql> create user if not exists xiaozhi@localhost identified by '1968zhss';
Query OK, 0 rows affected (0.00 sec)

//仅允许8.138.19网段登录 %表示任意
mysql> create user if not exists xiaozhi@'8.138.19.%' identified by '1968zhss';
Query OK, 0 rows affected (2.25 sec)
```

#### 授权

```
GRANT [权限类型] ON [数据库名.表名] TO [用户名@主机名]
```

**示例**

```
grant all on tlias.* to xiaozhi@localhost; //授予用户xiaozhi tlias数据库的所有权限
注：此时xiaozhi仅仅能操作tlias数据库，而没有创建，操作其他数据库的权限
```

#### 查看用户授权

```
SHOW GRANTS FOR [用户名]@[主机名]
```

```
mysql> show grants for xiaozhi@localhost;
+------------------------------------------------------------+
| Grants for xiaozhi@localhost                               |
+------------------------------------------------------------+
| GRANT USAGE ON *.* TO 'xiaozhi'@'localhost'                |
| GRANT ALL PRIVILEGES ON `tlias`.* TO 'xiaozhi'@'localhost' |
+------------------------------------------------------------+
2 rows in set (0.00 sec)

//usage表示无实际权限
```

#### 撤权

```
REVOKE [权限] ON [数据库名.表名] from [用户名@主机]；
```

案例

```
revoke delete on tlias from xiaozhi@localhost；//撤销用户xiaozhi对tlias所有表的删除权
```



## MySQL核心SQL

### SQL语句

#### DQL

查询语句

#### DDL

![image-20251020200156252](./media/image-20251020200156252.png)

#### DML

![image-20251020200204903](./media/image-20251020200204903.png)

#### DCL

![image-20251020200215591](./media/image-20251020200215591.png)

grant：授权

revoke：撤权

#### TCL

事物控制语言

开启事物：start transaction

事物提交：commit

事物回滚： rollback

### CRUD专题

在频繁执行增删改查操作时，可以创建一个连接池，避免MySQL Serve频繁的与MySQL Client三次握手，再断开连接，浪费资源。

![image-20251021195112868](./media/image-20251021195112868.png)

select通用语法

```
select {字段列表} from <表1>,<表2> [where 表达式] [group by] [having] [order by] [limit <>]
```



### 一些关键字

#### distinct：字段去重

![image-20251021202649147](./media/image-20251021202649147.png)

#### Null：空值查询

![image-20251021202802258](./media/image-20251021202802258.png)

#### union：合并查询结果

![image-20251021202907273](./media/image-20251021202907273.png)

#### 带in子查询

in 和not in

![image-20251022153850860](./media/image-20251022153850860.png)

#### limit：分页查询

**格式**

![image-20251022154030520](./media/image-20251022154030520.png)

**案例**

//第一条：查询前10列数据

//第二条：查询2000条之后的10条数据

![image-20251022153740111](./media/image-20251022153740111.png)

这是一个进行sql查询优化的案例 通过使用where字段使用加了索引的字段 加速查询。在写sql语句时 尽量与带了索引的字段相关联。

![image-20251022184541915](./media/image-20251022184541915.png)

#### explain

![image-20251022162951308](./media/image-20251022162951308.png)

#### order by：排序

tip：在使用order by做查询时，select的字段和order by都是建立索引的字段 索引才会生效。

![image-20251022191015118](./media/image-20251022191015118.png)

#### group by：分组

tip：使用group by时，select的字段必须与group by的字段有关 常常与聚合函数一起使用。

​         如果要对分组的数据进行筛选，若加在group by之前 使用where 若之后，使用having关键字。

​         在使用group by时，group by后的值也可以使用到索引。

​         使用group by时，select *无意义，因为只会列出group by字段限制的数据中的一条。

![image-20251022192440343](./media/image-20251022192440343.png)

group by后加多个字段，按照多字段进行分组

![image-20251022192859230](./media/image-20251022192859230.png)

### 连接查询

Tip：

​	做多表查询时 比如三表 第一张表必须是与其余表都有关系的表，然后使用left join字段，根据on字段连接其他表

![image-20251022202622780](./media/image-20251022202622780.png)

#### 内连接

select * from stu join sc；

结果是两张表的笛卡尔积

#### 外连接

**左连接**

select * from stu left join sc on 条件；

根据条件匹配。但是stu的每一行数据最少出现一次，匹配不到sc表的值，则为null。

**右连接**

同左连接

### 库操作

select database：查询当前使用的数据库

show databases：列出所有数据库

create database db：创建数据库

![image-20251022205012008](./media/image-20251022205012008.png)

use db：使用db数据库

删除数据库：drop db；

![image-20251022205108734](./media/image-20251022205108734.png)

### 表操作

#### 列出当前使用数据库下所有表

```
show tables；
```

#### 建表

![image-20251022205223418](./media/image-20251022205223418.png)

#### 查看表结构

```
desc A;    //查看A表结构
```

#### 查看建表sql

```
show create table A;   //查看A表的建表sql语句
```

#### 添加字段

![image-20251022205340228](./media/image-20251022205340228.png)

#### 修改字段

![image-20251022205411144](./media/image-20251022205411144.png)

#### 删除字段

![image-20251022205425117](./media/image-20251022205425117.png)

#### 修改表名

![image-20251022205442769](./media/image-20251022205442769.png)

#### 删除表

![image-20251022205457696](./media/image-20251022205457696.png)

## 优化手段

![image-20251026213129288](./media/image-20251026213129288.png)

id自带索引 所以临时表b查的比较快，然后根据这张小表b中的id来查 。