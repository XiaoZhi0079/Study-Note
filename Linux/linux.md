#### vim

##### 工作模式

![image-20250824225826796](./media/image-20250824225826796.png)

##### 命令模式

![image-20250824225734999](./media/image-20250824225734999.png)

##### 底线命令模式

![image-20250824225804394](./media/image-20250824225804394.png)

#### 基本操作

##### ls

参数： -a -h -l

选项：路径

![ead7128405722d4aae1c566725000ba](C:\Users\张海松\Documents\WeChat Files\wxid_bojikarto3u022\FileStorage\Temp\ead7128405722d4aae1c566725000ba.jpg)

##### mkdir

![image-20250823152417618](./media/image-20250823152417618.png)

##### touch  cat  more

![image-20250823152343170](./media/image-20250823152343170.png)

##### cp

![image-20250823151931001](./media/image-20250823151931001.png)

##### mv

![image-20250823145944174](./media/image-20250823145944174.png)

##### rm

![image-20250823151022088](./media/image-20250823151022088.png)

通配符

![image-20250823151434630](./media/image-20250823151434630.png)

##### which

![image-20250823152943605](./media/image-20250823152943605.png)

##### find

###### 按名字搜索

![image-20250823153143404](./media/image-20250823153143404.png)

![image-20250823153233176](C:\Users\张海松\AppData\Roaming\Typora\typora-user-images\image-20250823153233176.png)

通配符

![image-20250823154629787](./media/image-20250823154629787.png)

按大小搜索

![image-20250823153823730](./media/image-20250823153823730.png)

##### grep

![image-20250823154852471](./media/image-20250823154852471.png)

![image-20250823155132701](C:\Users\张海松\AppData\Roaming\Typora\typora-user-images\image-20250823155132701.png)

##### wc

![image-20250823155156076](./media/image-20250823155156076.png)

管道符|

![image-20250823155948837](./media/image-20250823155948837.png)

##### echo

类似于 print 

![image-20250823214607547](./media/image-20250823214607547.png)

使用``符号

![image-20250823214738231](./media/image-20250823214738231.png)

##### 重定向符

![image-20250823211656605](./media/image-20250823211656605.png)

##### tail

tail -F 路径  查看并跟踪

tail -20F 路径  查看后20行并跟踪

修改主机名

![image-20250824225154324](./media/image-20250824225154324.png)

##### 关机

![image-20250821170653218](./media/image-20250821170653218.png)



##### systemctl

![image-20250825141601643](./media/image-20250825141601643.png)

![image-20250825141634375](./media/image-20250825141634375.png)

##### ln

![image-20250825141719199](./media/image-20250825141719199.png)

![image-20250825141711892](./media/image-20250825141711892.png)

##### date命令

![image-20250825141824509](./media/image-20250825141824509.png)

![image-20250825141836899](./media/image-20250825141836899.png)

![image-20250825141907986](./media/image-20250825141907986.png)

##### 修改linux时区

![image-20250825141941651](./media/image-20250825141941651.png)

##### 安装软件

![image-20250825141429983](./media/image-20250825141429983.png)

![image-20250825141517272](./media/image-20250825141517272.png)

##### ntp程序校准时间

![image-20250825142007957](./media/image-20250825142007957.png)

##### env

![image-20250825202442129](./media/image-20250825202442129.png)

##### $

![image-20250825203042480](./media/image-20250825203042480.png)

##### export

![image-20250825203316091](./media/image-20250825203316091.png)

##### 自定义环境变量PATH

![image-20250825210248303](./media/image-20250825210248303.png)

##### ./（可执行文件名）

执行文件

上传下载文件（wsl的linux不需要，因为本质就是挂载在本机）

![image-20250825212822878](./media/image-20250825212822878.png)

#### 解压缩

##### 常用格式

![image-20250825213838206](./media/image-20250825213838206.png)

##### tar命令

![image-20250825214050138](./media/image-20250825214050138.png)

###### 压缩常用命令组合

![image-20250825222340069](./media/image-20250825222340069.png)

###### 解压常用命令组合

![image-20250825223437542](./media/image-20250825223437542.png)

##### zip命令

![image-20250825223735140](./media/image-20250825223735140.png)

##### unzip命令

![image-20250825223841207](./media/image-20250825223841207.png)

#### 主机状态监控

![image-20250825163447697](./media/image-20250825163447697.png)

##### top查看资源占用

![image-20250825154827267](./media/image-20250825154827267.png)

![image-20250825155120087](./media/image-20250825155120087.png)

###### 内容详解

![image-20250825155234286](./media/image-20250825155234286.png)

![image-20250825155811745](./media/image-20250825155811745.png)

###### 命令选项

![image-20250825160002861](./media/image-20250825160002861.png)

###### 交互式选项

![image-20250825161119002](./media/image-20250825161119002.png)

##### df查看硬盘使用情况

![image-20250825161821275](./media/image-20250825161821275.png)

##### 磁盘信息监控

![image-20250825162215385](./media/image-20250825162215385.png)

##### sar网络状态监控

![image-20250825162731734](./media/image-20250825162731734.png)

#### 用户管理

##### 切换用户

su 用户名

![image-20251022151731462](./media/image-20251022151731462.png)

##### 查看用户信息

id 用户名

![image-20250822154449679](./media/image-20250822154449679.png)

##### 查看当前用户

![image-20250822154551591](./media/image-20250822154551591.png)

##### 注销登录

![image-20250821222844373](./media/image-20250821222844373.png)

##### 添加用户

<img src="./media/image-20250822153905063.png" alt="image-20250822153905063" style="zoom:50%;" />

![image-20250821222433243](./media/image-20250821222433243.png)

##### 删除用户

![image-20250821222524569](./media/image-20250821222524569.png)

![image-20250821222756428](./media/image-20250821222756428.png)



##### 用户组

添加组 删除组

![image-20250822154630182](./media/image-20250822154630182.png)

查看组信息，查看用户信息

![image-20250822161448670](./media/image-20250822161448670.png)

sudo gpasswd -d yuria wudang：将尤利娅移除wudang组

groups yuria ：查看尤利娅的组信息

![image-20250822161848966](./media/image-20250822161848966.png)

![4943e09aa816c266a24078401ba898d](C:\Users\张海松\Documents\WeChat Files\wxid_bojikarto3u022\FileStorage\Temp\4943e09aa816c266a24078401ba898d.jpg)

为用户配置sudo权限

![image-20250825140701716](./media/image-20250825140701716.png)

#### 快捷键

![image-20250825141319553](./media/image-20250825141319553.png)

#### 权限修改

##### chmod

![image-20250824225914061](./media/image-20250824225914061.png)

![image-20250824225952604](./media/image-20250824225952604.png)

![image-20250825131337210](./media/image-20250825131337210.png)





##### chown

