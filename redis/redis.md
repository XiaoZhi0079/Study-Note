# Redis

## 介绍

Redis 是完全开源免费的，是一个高性能的key-value数据库。

Redis 与其他 key - value 缓存产品有以下三个特点：

- Redis支持数据的持久化，可以将内存中的数据保持在磁盘中，重启的时候可以再次加载进行使用。
- Redis不仅仅支持简单的key-value类型的数据，同时还提供list，set，zset，hash等数据结构的存储。
- Redis支持数据的备份，即master-slave模式的数据备份。

------

### Redis 优势

- 性能极高 – Redis能读的速度是110000次/s,写的速度是81000次/s 。
- 丰富的数据类型 – Redis支持二进制案例的 Strings, Lists, Hashes, Sets 及 Ordered Sets 数据类型操作。
- 原子 – Redis的所有操作都是原子性的，同时Redis还支持对几个操作全并后的原子性执行。
- 丰富的特性 – Redis还支持 publish/subscribe, 通知, key 过期等等特性。

------

### Redis与其他key-value存储有什么不同？

- Redis有着更为复杂的数据结构并且提供对他们的原子性操作，这是一个不同于其他数据库的进化路径。Redis的数据类型都是基于基本数据结构的同时对程序员透明，无需进行额外的抽象。
- Redis运行在内存中但是可以持久化到磁盘，所以在对不同数据集进行高速读写时需要权衡内存，应为数据量不能大于硬件内存。在内存数据库方面的另一个优点是， 相比在磁盘上相同的复杂的数据结构，在内存中操作起来非常简单，这样Redis可以做很多内部复杂性很强的事情。 同时，在磁盘格式方面他们是紧凑的以追加的方式产生的，因为他们并不需要进行随机访问。

## 使用

//添加到环境变量

先运行服务器端redis-server.exe,再运行客户端redis-cli.exe

启动服务端

```
redis-server.exe 配置文件.conf            //配置文件.conf可以省略  不同环境的的命名不同 
```

启动客户端

```
redis-cli.exe -h 127.0.0.1 -p 6379      //ip地址和端口可省略 省略则使用默认配置
```

## 配置

windows下分为redis.windows.conf与redis.windows-service.conf。

**redis.windows.conf**：

Windows 环境下的默认配置文件，包含 Redis 的端口、密码、持久化、后台运行等核心配置（你启动 Redis 时需要指定这个文件）。

**redis.windows-service.conf**：

专门用于将 Redis 注册为 Windows 服务时的配置文件（如果想让 Redis 开机自启，会用到这个配置）。

可以直接修改conf文件，也可通过命令行窗口编辑。

**命令语法**：

```
redis 127.0.0.1:6379> CONFIG GET CONFIG_SETTING_NAME
redis 127.0.0.1:6379> CONFIG SET CONFIG_SETTING_NAME
```

具体命令https://www.redis.net.cn/tutorial/3504.html

## 数据类型

### String

string是redis最基本的类型，你可以理解成与Memcached一模一样的类型，一个key对应一个value。

string类型是二进制安全的。意思是redis的string可以包含任何数据。比如jpg图片或者序列化的对象 。

string类型是Redis最基本的数据类型，一个键最大能存储512MB。

#### 命令

##### 增/改

set：赋值/更新值      

##### 查

get：取值

##### 删

del：删除值（可批量删除）

#### 案例

```
127.0.0.1:6379> set a 1
OK
127.0.0.1:6379> set b 2
OK
127.0.0.1:6379> get a
"1"
127.0.0.1:6379> get b
"2"
127.0.0.1:6379> del a b
(integer) 2
```

### Hash

Redis hash 是一个键值对集合。

Redis hash是一个string类型的field和value的映射表，hash特别适合用于存储对象。

#### 命令

##### 增改

hset：赋值/更新单个值 

hmset：赋值/更新多个值  

hsetnx：赋值，只有目标不存在才赋值，避免覆盖

##### 查

get：获取单个值

hmget：获取多个值

hmgetall：获取所有值

##### 删

hdel：删除一个或多个字段

```
redis 127.0.0.1:6379> HMSET user username satomi password yuria
OK
redis 127.0.0.1:6379> HGETALL user
1) "username"
2) "satomi"
3) "password"
4) "yuria"
```

### List

Redis 列表是简单的字符串列表，按照插入顺序排序。你可以添加一个元素导列表的头部（左边）或者尾部。

#### 命令

##### 增

lpush：往左边插一个值

rpush：往右边插一个值

lpushx：只有列表存在时，才往左插值，避免创建新列表

......

linsert:在列表中**指定元素的前 / 后**插入新元素，返回插入后长度（元素不存在则返回 - 1）

##### 改

lset:改指定索引的列表元素

##### 查

llen:查询列表长度

lindex：查指定索引的列表元素

lrange：查指定范围的列表元素

##### 删

lpop：删左侧的列表元素

rpop：删右侧的列表元素

......

#### 案例

```
127.0.0.1:6379> lpush mylist a b c
(integer) 3
127.0.0.1:6379> lpush mylist d
(integer) 4
127.0.0.1:6379> lrange mylist 0 10
1) "d"
2) "c"
3) "b"
4) "a"
127.0.0.1:6379> rpush mylist e
(integer) 5
127.0.0.1:6379> lrange mylist 0 10
1) "d"
2) "c"
3) "b"
4) "a"
5) "e"
127.0.0.1:6379> llen mylist
(integer) 5
127.0.0.1:6379> lindex mylist 3
"a"
127.0.0.1:6379> lpop mylist
"d"
127.0.0
```

### Set

Redis的Set是string类型的无序不重复集合。

集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是O(1)。

#### 命令

##### 增

sadd myset a b：增加集合元素a，可批量添加

##### 查

scard myset：查集合中元素的数量

smembers myset：查set集合的所有元素

sismember myset a：查元素a是否在集合中

srandmember myset [number]：随机返回set集合中number个元素

......

查set集合间交集/并集/差集元素

......

##### 删

srem：删除集合中指定元素

spop myset [number]：删除集合中number个随机元素

del myset：直接删除集合

### zset（sorted set）：有序集合

Redis zset 和 set 一样也是string类型元素的集合,且不允许重复的成员。

不同的是每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。

zset的成员是唯一的,但分数(score)却可以重复。

#### 命令

##### 增/改

zadd myzset score member ：添加元素至zset，可批量添加

参数：nx（元素不存在时才添加）、xx（元素存在时才更新分数）、ch（返回分数变化的元素数）......

```
ZADD myzset NX 80 "赵六"
```

##### 查

zcard myzset：查询集合元素数量

zcount myzset：查询分数范围内的元素数量

```
zcount myzset 80 90 //80到90分的元素数量
```

zscore myzset a：获取指定元素a的分数

zrange myzset 0 99：按照升序获取0-99排名的元素 0 -1表示获取所有元素

zrevrange myzset 0 99：降序......

......

##### 删

zrem myset a b:删除集合中元素a，b

.....

按排名删除

