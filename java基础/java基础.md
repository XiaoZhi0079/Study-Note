基本数据类型：直接存储数据的值 //int char boolean

引用数据类型：存储数据对象在堆内存中的地址 //数组 String

java-文件

创建文件对象：最常用的是传递url参数创建

一些方法：

isFile？isDiertory？length

mkdir：创建文件夹 且是一级文件夹

mkdirs：可以创建多级文件夹。

createFile：创建文件

delete：删除文件或空文件夹，使用delete执行删除方法之后，会直接删除，不会进回收站。

File提供了两种遍历**文件夹**的方法，第一种方法list返回一个数组，其中包含所有一级文件夹，文件的名字。第二种方式listFiles返回一个File的数组，其将每一个一级文件夹，文件的对象封装进去了。

如何得到一个文件夹里所有的内容呢？

使用递归算法，一层层遍历。



IO流

体系

![82119ce04a260c5922aebc953a5b94a7](./media/82119ce04a260c5922aebc953a5b94a7.png)

为什么使用字节流时使用数组传递和接受数据，而不用列表？

1.数组在内存中是连续的，文件的字节也是连续的。

2列表中的数据实际是目标类的封装类，开销更大。

3.因为列表是基于数组，列表长度可变性，动态扩容也是基于数组，使用列表多了一层包装，来回就是两层。



在进行io流时，用来接受的字节数组越大 效率越高。不过越大，效率的提升越来越有限，甚至适得其反。



输入流 输出流 

字节输入流 字节输出流 字符输入流 字符输入流



字节输入流：将磁盘中的字节传输到内存中

构造器：

FileInputStream



字节输出流：将数据写入磁盘

构造器：

FileOutputStream



字符流



文件字符输入流

FileReader



文件字符输出流

FileWriter

tip：

字符输出流为什么需要flush？

因为频繁的磁盘 I/O 操作很慢，加入缓冲区之后可以减少写入磁盘的次数，提高效率，缺点是需要flush刷新，将缓存区的字符赶紧写入磁盘。

flush：刷新字符流 close 关闭包含了刷新



字符输入转换流

InputStreamReader

![bc6241314c6c4162023e816033dad4ff](./media/bc6241314c6c4162023e816033dad4ff.png)

打印流

PrintStream PrintWriter

![1600c63fda9e3b2362ce41fb3a41fe97](./media/1600c63fda9e3b2362ce41fb3a41fe97.png)

特殊数据流

DataOutputStream：特殊数据输出流，允许把数据和类型都写出去

DataOutputStream：特殊数据输入流，允许按照类型读数据





Tips:

使用try-catch-finally方法时 遇到需要释放资源的情况 比如通信管道的释放，字节流管道的释放，可以使用try-with-resource方法。

![cab35877b6cf377d342cfd5799cfde94](./media/cab35877b6cf377d342cfd5799cfde94.png)





缓冲流：提高字符字节流流的速度，原理是更大的缓存池，默认是8k的缓存池

。。。

。。。

。。。

缓冲字符输入流

readLine():读取一行数据

![b516e2c29d398d73fba44351d59ddcd0](./media/b516e2c29d398d73fba44351d59ddcd0.png)

缓冲字符输出流

newLine():换行输出

![bc59d831d0c9a104f49b851a101987ce](./media/bc59d831d0c9a104f49b851a101987ce.png)

IO框架

common-io框架

引入依赖

```
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.11.0</version>
</dependency>

```

![e5a7dbd6658c8c568d1798605e0dd59c](./media/e5a7dbd6658c8c568d1798605e0dd59c.png)

junit单元测试

## 反射 

概念：加载类，并允许以编程的的方式解剖类的各种成分（成员遍历，方法，构造器等）。

反射第一步：获取class对象

![image-20251104173141371](./media/image-20251104173141371.png)



获取构造器

获取构造器的目的是为了创建对象

![image-20251104174751494](./media/image-20251104174751494.png)



获取成员变量

获取成员变量的目的是为了取值，赋值

![image-20251104174848174](./media/image-20251104174848174.png)



成员方法

获取成员方法的目的是调用方法

![image-20251104174905042](./media/image-20251104174905042.png)









