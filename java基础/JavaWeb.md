# java基础

## 多态

多态下不能调用子类独有方法。

```
Animal a1=Wolf w1
a1.eatmeat()    //报错 因为eatmeat是Wolf的独有方法。
//想要调用需要强行转换，先调用instanceof方法查看是否可以强转
a1.instanseof
Wolf w2=(Wolf)a1;
w2.eatmeat();
```

## 异常

![image-20251113153906025](./../计算机网络/media/image-20251113153906025.png)

Error属于严重的错误。

Checked Exception类异常属于检查型异常，写程序时需要使用throws在方法的声明之后显示捕获，或者使用try-catch包围。

```
//throws的案例

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clz = Class.forName("com.itwanger.s41.Demo1");
    }
}
```

```
public class Demo2 {
    private String mHost;
    private int mPort;
    private Socket mSocket;
    private final Object mLock = new Object();

    public void run() {
    }

    private void initSocket() {
        while (true) {
            try {
                Socket socket = new Socket(mHost, mPort);
                synchronized (mLock) {
                    mSocket = socket;
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

Unchecked Exception类异常属于运行时异常，可以通过编码进行规避，使用throw捕获。

```
public class ThrowDemo {
    static void checkEligibilty(int stuage){
        if(stuage<18) {
            throw new ArithmeticException("年纪未满 18 岁，禁止观影");
        } else {
            System.out.println("请认真观影!!");
        }
    }

    public static void main(String args[]){
        checkEligibilty(10);
        System.out.println("愉快地周末..");
    }
}
```

**try-catch-finally**

**try-catch-resources**

https://javabetter.cn/exception/try-with-resources.html

## 函数式编程

### 匿名内部类

![image-20250917213552099](./media/image-20250917213552099.png)

#### 常见形式

![image-20250917213705161](./media/image-20250917213705161.png)



![image-20251013161959851](./media/image-20251013161959851.png)

#### 使用场景

![image-20250917220131005](./media/image-20250917220131005.png)

### lamda表达式

![image-20250917225349763](./media/image-20250917225349763.png)

@functioninterface注解：标明为函数式接口

#### 案例

![image-20251009140238296](./media/image-20251009140238296.png)



### 方法引用

#### 静态方法引用

![image-20251013175709991](./media/image-20251013175709991.png)

案例

![image-20251013180448891](./media/image-20251013180448891.png)

#### 实例方法引用

![image-20251013180555660](./media/image-20251013180555660.png)

#### 特定类的方法引用

![image-20251013202256013](./media/image-20251013202256013.png)

构造器引用

![image-20251013211737996](./media/image-20251013211737996.png)

## 泛型

![image-20250908180018070](./media/image-20250908180018070.png)

### 泛型类

### 泛型接口

![image-20250908180710217](./media/image-20250908180710217.png)

### 泛型方法

![image-20250908212900437](./media/image-20250908212900437.png)

![image-20250908215218263](./media/image-20250908215218263.png)

### 泛型支持的类型



![image-20250909111719492](./media/image-20250909111719492.png)

因为泛型里的应该是对象，而基本数据类型都不是对象，进而引出包装类

![image-20250909112752311](./media/image-20250909112752311.png)

![image-20250909120300576](./media/image-20250909120300576.png)

#### 案例

![image-20250908212758228](./media/image-20250908212758228.png)

![image-20250908220505543](./media/image-20250908220505543.png)

xiaomi是car的子类，Arraylist<xiaomi>可以调用go方法

## 集合

Tip：使用了hash的集合 其存储对象要实现hashcode（)方法 equal方法。

​         需要排序的集合，其对象必须实现compare方法或者提供比较器器

![image-20251014171033444](./media/image-20251014171033444.png)

### Collection集合

#### 集合的体系

![image-20251014165943341](./media/image-20251014165943341.png)



![image-20251014171732353](./media/image-20251014171732353.png)

![image-20251015174727563](./media/image-20251015174727563.png)

#### List集合

##### Arraylist：根据索引查询快 增删慢

![image-20250908172358778](./media/image-20250908172358778.png)

![image-20250908172849225](./media/image-20250908172849225.png)

![image-20250908173412142](./media/image-20250908173412142.png)

##### LinkedList：查询慢 增删相对数组快

![image-20251014162932505](./media/image-20251014162932505.png)

###### 单双链表

![image-20251014162723970](./media/image-20251014162723970.png)



###### 使用场景

使用linkedlist设计栈表（因为首尾操作很快）

![image-20251014163417005](./media/image-20251014163417005.png)

使用linkedlist设计队列（首位操作快）

![image-20251014163928033](./media/image-20251014163928033.png)****

#### List集合的三种遍历方式（并发修改异常问题）

![image-20251014165835863](./media/image-20251014165835863.png)

##### for循环遍历

![image-20251014164703926](./media/image-20251014164703926.png)

代码有误 因为没次删除之后 索引会向前 

解决方案一：i--

![image-20251014164805299](./media/image-20251014164805299.png)

解决方案二：倒着删除

//////////////////////////

##### 迭代器

无法在遍历时进行列表自带的增删方法  但是可以使用迭代器对象使用其删除方法

![image-20251014165456090](./media/image-20251014165456090.png)

##### 增强for循环

增强for循环底层是迭代器 但是迭代器是隐藏的 拿不到迭代器对象 所以无法解决 

下面给出一些增强for循环的案例

###### 遍历数组 List的案例(额外拓展)

![image-20251015161320750](./media/image-20251015161320750.png)

###### 遍历Set Map(额外拓展)

![image-20251015161356984](./media/image-20251015161356984.png)



#### set集合

![image-20251014170321888](./media/image-20251014170321888.png)

![image-20251014170812680](./media/image-20251014170812680.png)

##### HashSet

###### 底层原理

![image-20251014171921284](./media/image-20251014171921284.png)

![image-20251014172057500](./media/image-20251014172057500.png)

![image-20251014172425253](./media/image-20251014172425253.png)

表的扩容：扩容后重新存数据

![image-20251014172639784](./media/image-20251014172639784.png)

红黑树

![image-20251014172859463](./media/image-20251014172859463.png)

去重机制

![image-20251014174009538](./media/image-20251014174009538.png)

##### LinkedHashSet

![image-20251014175338614](./media/image-20251014175338614.png)

##### TreeSet

![image-20251014222820591](./media/image-20251014222820591.png)

###### 排序实现原理

![image-20251014223738149](./media/image-20251014223738149.png)

实现一：排序目标类实现cpmparable接口   //Integer  String这些类已实现此接口

实现二：在构建Treeset对象时，传入比较器参数

![image-20251014223611169](./media/image-20251014223611169.png)

### Map集合

#### 体系

![image-20251014224118254](./media/image-20251014224118254.png)

#### 常用方法

![image-20251014224704489](./media/image-20251014224704489.png)

#### map的遍历方法

##### 一：使用keySet方法获取全部键的Set 然后遍历Set，根据键取值。

![image-20251014224804188](./media/image-20251014224804188.png)

##### 二：使用entrySet方法获取所有键值对的集合

![image-20251014225114061](./media/image-20251014225114061.png)

###### 案例

![image-20251014225217232](./media/image-20251014225217232.png)

##### 三：使用lambda表达式

![image-20251014225429697](./media/image-20251014225429697.png)

#### map实现类的底层原理

##### HashMap的底层原理

![image-20251014225717381](./media/image-20251014225717381.png)

##### LinkedMap的底层原理

![image-20251014225819391](./media/image-20251014225819391.png)

##### TreeMap的底层原理

![image-20251015162136750](./media/image-20251015162136750.png)

## 排序

### Arrays.sort:对数组进行排序

Tip：排序器方法只需要返回正负值，真正排序的是sort，根据排序器返回的值进行排序。

​         sort默认排序顺序是从小到大。

#### Arrays.sort（T[] a）//不传排序器时，需要元素类自己实现compareTo方法，Integer，String等等已实现。

![image-20251013171203377](./media/image-20251013171203377.png)

#### Arrays.sort(T[] a, Comparator<? super T> c)//传排序器

![image-20251013172226464](./media/image-20251013172226464.png)

### lists.sort（排序器）:list是List的示例对象

##### 当元素类型 `E` 实现了 `Comparable<E>` 时

![image-20251013173817402](./media/image-20251013173817402.png)

##### 要使用自定义排序器时

一个使用了匿名内部类的案例

![image-20251013174038847](./media/image-20251013174038847.png)

使用静态方法调用比较器工厂的排序器

![image-20251013174216633](./media/image-20251013174216633.png)

## Stream

![image-20251015162912966](./media/image-20251015162912966.png)

Stream（流）是对集合的增强，可以实现高效的聚合操作（过滤、映射、排序等）。它的特点是：

- **不存储数据**：只是对数据源（集合、数组等）的操作
- **惰性执行**：中间操作只有在终止操作调用时才会执行
- **一次性使用**：流一旦执行终止操作就会关闭

### Stream流的操作

![image-20251015163207844](./media/image-20251015163207844.png)

#### Stream流的创建

![image-20251015163725102](./media/image-20251015163725102.png)

**Stream类提供了一个可变参数的方法** 详解：杂记-可变参数

```
// 从集合创建
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();

// 从数组创建
String[] arr = {"x", "y", "z"};
Stream<String> arrStream = Arrays.stream(arr);

// 直接生成
Stream<Integer> numStream = Stream.of(1, 2, 3, 4);
```

Map集合如何获取stream流呢？

使用keyset方法获取键流   使用values方法获取值流   使用entrySet方法获取键值对流

![image-20251015164407900](./media/image-20251015164407900.png)

#### 中间操作（返回 Stream，可链式调用）

![image-20251015165017038](./media/image-20251015165017038.png)

常用中间操作：

- `filter(Predicate)`：过滤元素
- `map(Function)`：转换元素（例如字符串转长度）
- `sorted()`：排序
- `distinct()`：去重
- `limit(long)`：限制元素数量

```
List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant");

// 过滤长度 > 3 的单词，转为大写，再排序
Stream<String> processed = words.stream()
    .filter(word -> word.length() > 3)  // 保留长度>3的
    .map(String::toUpperCase)           // 转为大写
    .sorted();                          // 排序
```

合并流

![image-20251015170040600](./media/image-20251015170040600.png)

#### 终止操作（返回具体结果，结束流）

##### 一般操作

Tip:Optional是一个存储对象的容器 可以为null而不会引发空指针问题。

![image-20251015171306221](./media/image-20251015171306221.png)

- `forEach(Consumer)`：遍历元素
- `count()`：统计元素数量
- `collect(Collector)`：收集为集合（最常用）
- `findFirst()`/`findAny()`：查找元素
- `anyMatch(Predicate)`：判断是否有匹配元素

```
List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
// 遍历输出
Stream<String> processed = words.stream()
    .filter(word -> word.length() > 3)  // 保留长度>3的
    .map(String::toUpperCase)           // 转为大写
    .sorted();  
processed.forEach(System.out::println);  // 输出：APPLE, BANANA, ELEPHANT

// 统计数量
long count = words.stream().filter(w -> w.length() > 3).count();  // 结果：3
```

##### 收集Stream（流只能收集一次）

![image-20251015172319603](./media/image-20251015172319603.png)

`Collector`（收集器）用于将 Stream 的元素收集到集合或其他数据结构中，常用`Collectors`工具类提供的静态方法创建。

######  常见的 Collector 用法

```
List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant");

List<String> filteredList = words.stream()
    .filter(w -> w.length() > 3)
    .collect(Collectors.toList());  // 转为List

Set<String> filteredSet = words.stream()
    .filter(w -> w.length() > 3)
    .collect(Collectors.toSet());   // 转为Set（去重）
    
 Map<String, Integer> wordLengthMap = words.stream()
    .collect(Collectors.toMap(
        word -> word,               // 键：单词本身
        word -> word.length()       // 值：单词长度
    ));
// 结果：{apple=5, banana=6, cat=3, dog=3, elephant=8}
```

```
//拼接字符串
String joined = words.stream()
    .filter(w -> w.length() > 3)
    .collect(Collectors.joining(", ", "Words: [", "]"));
// 结果："Words: [apple, banana, elephant]"
```

## random

```
//使用random取随机值，加入要使随即范围为50
int x=(int)Math.random（）*50;

Random r = new Random（）；
Int x = r.nextInt(0,5)->生成0-5的整数 不包括5
```

## 多线程

### 实现方式

#### 继承Thread类

重写run方法，使用start方法调用

##### 优缺点

不能继承其他类，因为java是单继承。

#### 实现runnable接口



![image-20251007113648698](./media/image-20251007113648698.png)

##### 匿名内部类写法

![image-20251007115659737](./media/image-20251007115659737.png)

##### 优缺点

Tip:可以使用多个Tread对象操作同一个Runable接口实例

![image-20251007113958880](./media/image-20251007113958880.png)

![image-20251015191454538](./media/image-20251015191454538.png)

#### 利用callable接口，futuretask类实现

![image-20251007120146150](./media/image-20251007120146150.png)

##### 案例

```
public class MyThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> call=new call(100);
        FutureTask task=new FutureTask<String>(call);
        new Thread(task).start();
        System.out.println(task.get());

    }
}

public class call implements Callable<String> {

    private Integer n;

    public call(Integer n) {
     this.n = n;
    }
    @Override
    public String call() throws Exception {
        Integer sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
            System.out.println("线程计算中·："+i);
        }
        return "计算从1到"+n+"的运算，结果是"+sum;
    }
}
```

### 线程常用方法

![image-20251007164640554](./media/image-20251007164640554.png)

join的案例 保证线程1执行完之后再执行2，2执行完再执行3

![image-20251007170053229](./media/image-20251007170053229.png)

### 线程安全

#### 实现方案

##### 同步代码块

![image-20251007201347555](./media/image-20251007201347555.png)

案例：使用synchronized关键字包裹共享资源代码

![image-20251007202204374](./media/image-20251007202204374.png)

##### 同步方法

![image-20251007201529993](./media/image-20251007201529993.png)

案例：给共享资源的方法加上synchronized关键字

![image-20251007202325839](./media/image-20251007202325839.png)

##### lock锁

![image-20251007201652092](./media/image-20251007201652092.png)

案例:每一个Account对象都要有一把锁，在线程执行到上锁操作之后，代码结束之前，一定要解锁，所以使用try catch finally包围起来。

```
@Data
public class account {
    private String ID;
    private double money;
    //锁
    private Lock lk=new ReentrantLock();

    public account(String ID, double money) {
        this.ID = ID;
        this.money = money;
    }

    public void Withdraw(double money) throws InterruptedException {

        String name = Thread.currentThread().getName();

        lk.lock();

        try {
            if (this.money >= money){
                this.money -= money;
                System.out.println(name+"取款成功，余额为："+this.money);
            }else {
                System.out.println(name+"取款失败，余额不足");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lk.unlock();
        }

    }

}
```

### 线程通信

![image-20251007210009529](./media/image-20251007210009529.png)

![image-20251007222123112](./media/image-20251007222123112.png)

### 线程池

![image-20251007223520512](./media/image-20251007223520512.png)

#### 线程池的创建

![image-20251008205132762](./media/image-20251008205132762.png)

##### ThreadPoolExecutor实现线程池

![image-20251008211344255](./media/image-20251008211344255.png)

注意：当核心线程都在忙，并且任务队列也已经满了，线程池才会尝试创建临时线程。

```
//创建一个线程池
ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 100,TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
```

问答

![image-20251008213620121](./media/image-20251008213620121.png)

##### Executors工具类实现线程池（大型并发项目尽量避免使用该类 因为该类有耗尽系统资源的风险）

![image-20251008221430578](./media/image-20251008221430578.png)

#### 线程池处理Runable任务，Callable任务

![image-20251008220810182](./media/image-20251008220810182.png)

#### 线程任务的拒绝策略

![image-20251008220523181](./media/image-20251008220523181.png)

### 进程

![image-20251008223321588](./media/image-20251008223321588.png)

并发并行

并发

![image-20251008225432066](./media/image-20251008225432066.png)

并行

![image-20251008225343035](./media/image-20251008225343035.png)

### 线程的生命周期

![image-20251008225530615](./media/image-20251008225530615.png)

### 案例：员工抢红包

问题：实现10个员工抢200红包，结束后每个员工发自己的总金额。

思路：10个员工即10个线程。20个红包。20红包由主线程来发。可以设置接受Interger参数的列表。先将20红包存进一个集合，然后使用for循环 将列表中的红包一个一个取出来。

# 杂记

## 关于IOC容器管理的一些注解

1. 核心目的相同：

   @Bean, @Component, @Service, @Controller, @Repository 这些注解的最终目的完全相同：都是为了向 Spring 容器注册一个由其管理的 Bean。

2. **两大实现方式**：

   - **`@Component` 及其衍生注解 (`@Service` 等)**：可理解为“**自动挡**”。它们作用于**类**上，Spring 通过**组件扫描**来自动发现并注册我们自己编写的类。
   - **`@Bean`**：可理解为“**手动挡**”。它作用于**方法**上，在 `@Configuration` 配置类中**显式定义**如何创建 Bean，尤其适用于**第三方库的类**或复杂的创建逻辑。

3. 职责分工明确 (语义化)：

   @Controller (控制层), @Service (业务层), @Repository (数据层) 主要是为了代码分层清晰，提升可读性和可维护性，是给开发者看的“语义化”标签。从注册 Bean 的基础功能上看，它们与 @Component 无异。

4. 存在细微技术差异：

   这些分层注解不完全是“语法糖”。例如，@Repository 提供了将数据库特定异常转译为 Spring 通用数据访问异常的附加功能。

一言以蔽之：**它们都是为了创建 Bean，但 `@Component` 体系是让 Spring 自动来找，而 `@Bean` 是我们手动告诉 Spring 如何去做。选择不同的注解是为了让代码结构更清晰，有时还能获得特定的框架功能。**自动挡”和“手动挡”，描述的是**Bean如何被创建并放入容器的过程**。

### 案例

关于bean注解的案例：java-ai的commonconfiguration类

其他注解案例：talis教育系统的三层架构

## 单例模式

![image-20250907224251239](./media/image-20250907224251239.png)

```
//二者并无区别
private static final A a = new A()；
private static final int a = 10；
```

## 可变参数

Tip：可变参数实质是数组。传参时最多传一个可变参数，如果有其他形参，可变参数要放到最后。

![image-20251015174527006](./media/image-20251015174527006.png)

## 实体类

POJO分为以下三类

![image-20251111160140460](./../计算机网络/media/image-20251111160140460.png)

## Nginx

![image-20251111171412275](./../计算机网络/media/image-20251111171412275.png)

# JavaWeb

## 教学管理系统

### 三层架构

#### 控制层 

使用@Autowired方法创建一个私有服务类

没有传参，@RestController @RestMapping定义请求路径 

#### 服务层

使用@Autowired方法创建私有数据层类

进行数据处理，在实现类上@Service

#### 数据流层

查询，将查询结果返回服务层

sql语句中，使用\#{name}而不是${name},可以防止sql注入。

#### 实体类

Dept类

Result类

EmpQueryParam类

### 部门操作

#### 1.部门列表查询

定义Dept类（带_字段使用驼峰命名法）封装数据流层的参数。使用查询语句查出部门列表信息，得到json格式的信息，刚好可以封装到List<Dept>集合中，控制层调用服务层，服务层调用dao层，返回结果前端。

#### 2.根据id删除部门

使用url查询参数（？key=value）

控制层：接受前端传来的参数id，调用service层，返回统一结果（Result）给前端

服务层：接受来自控制层的参数id，调用DAO层

DAO层：根据id执行删除操作，sql语句使用占位符接受服务层所传递的参数

#### 3.添加部门

传参样例

```
{
    "name": "教研部"
}
```

控制层：使用requestbody接受参数，使用一个Dept对象封装,将Dept对象传给服务层，调用Result方法返回统一结果。

服务层：补全Dept属性，比如创建时间，修改时间。将Dept属性传递给DAO层

DAO层：接受Dept对象，执行sql语句添加部门。

#### 4.根据id查询部门（查询数据回显）

使用路径传参（/{id}）

控制层：使用@PathVariable注解接受id参数，将id传给服务层，接受服务层传递回来的Dept对象，调用Result方法返回统一结果。

服务层：传递id到dao层，调用DAO层查询，接受DAO层返回的Dept对象，返回至控制层

DAO层：根据id查询，结果封装至Dept类，返回到服务层

#### 5.修改部门

传参实例

```
{
    "id": 1,
    "name": "教研部"
}
```

控制层：使用@Requestbody接受json参数，将参数封装至Dept类，传递给服务层，调用Result方法返回统一结果。

服务层：接受Dept类，修改时间属性，传递给DAO层

DAO层：接受服务层传来的Dept类，使用update语句更新

### 员工管理

#### 1.员工列表查询

请求参数样例

```
/emps?name=张&gender=1&begin=2007-09-01&end=2022-09-01&page=1&pageSize=10
```

创建EmpQueryParam类接受前端传递参数 在Emp类新增deptname属性，接受返回值 创建PageResult类封装服务层传递的结果。

控制层：使用使用EmpQueryParam接受参数，传参给服务层，接受服务层传递的Pageresult参数，调用Result方法返回统一结果。

服务层：传参给DAO层，使用Pagehelper方法，将page和pagesize信息传给Pagehelper，

DAO层：接受服务层传递的参数

PageHelper方法的调用

```
        PageHelper.startPage(empqueryparam.getPage(),empqueryparam.getPageSize());
        List<Emp> rows = empMapper.Page(empqueryparam);
        Page<Emp> pageresult = (Page<Emp>) rows;
        PageResult<Emp> pageResult = new PageResult<>(); // 1. 创建一个 PageResult 对象
        pageResult.setTotal(pageresult.getTotal());     // 2. 设置 total 属性
        pageResult.setRows(pageresult.getResult());     // 3. 设置 rows 属性
        return pageResult;                               // 4. 返回这个对象
        //return new PageResult<Emp>(pageresult.getTotal(), pageresult.getResult());
```

查询语句

```
select e.*,d.name from emp e left join dept d on e.dept_id=d.id 
        <where>
            <if test="name != null and name != ''">
                emp.name LIKE CONCAT('%', #{name}, '%')
            </if>
            <if test="gender != null">
                AND gender = #{gender}
            </if>
            <if test="begin != null and end!= null">
                AND emp.entry_date BETWEEN #{begin} AND #{end}
            </if>
        </where>
        ORDER BY
            create_time
```



#### 2.删除员工

请求参数样例

```
/emps?ids=1,2,3
```

控制层：使用List列表接受前端传来的列表参数，将参数传递给服务层

服务层:接受参数。将参数传给DAO层。由于涉及两张表格，分两步操作。第一步删除基本信息表，第二部删除工作经历信息。

DAO层：接受服务层参数，根据id的个数执行动态sql语句

```
   <!--    删除员工基本信息-->
   <delete id="deleteByid">
        delete from emp where id in
        <foreach item="id" collection="ids" separator="," open="(" close=")">
            #{id}
        </foreach>
    </delete>
    
    <!--    删除员工工作经历信息-->
    <delete id="deleteByempid">
        delete from emp_expr where emp_id in
        <foreach item="empid" collection="empids" separator="," open="(" close=")">
            #{empid}
        </foreach>
    </delete>
```

#### 3.添加员工

请求参数样例

```
{
  "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2022-09-03-07-37-38222.jpg",
  "username": "linpingzhi",
  "name": "林平之",
  "gender": 1,
  "job": 1,
  "entryDate": "2022-09-18",
  "deptId": 1,
  "phone": "18809091234",
  "salary": 8000,
  "exprList": [
      {
         "company": "百度科技股份有限公司",
         "job": "java开发",
         "begin": "2012-07-01",
         "end": "2019-03-03"
      },
      {
         "company": "阿里巴巴科技股份有限公司",
         "job": "架构师",
         "begin": "2019-03-15",
         "end": "2023-03-01"
      }
   ]
}
```

数据库：创建expr表，创建Expr类，以备接收expressList中的数据，使用emp_id与emp表关联

控制层：在emp类添加exprList列表属性，使用Emp类接受参数，传参给服务层

服务层：接受参数，由于涉及两张表的增加操作，分两步操作。第一步进行emp表的操作，补全时间属性，传参给DAO层添加emp表信息。第二步将exprList中的数据一一取出封装至Expr类的对象中，根据id补充emp_id，使用循环进行sql操作。

```
            List<EmpExpr> empExprsList = emp.getExprList();
            log.info("empExprsList为{}",empExprsList);
            if(!CollectionUtils.isEmpty(empExprsList)){
                empExprsList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.addEmpExprsBatch(empExprsList);
            }

            empLogService.insertLog(new EmpLog(emp.getId(),LocalDateTime.now(),"添加员工"+emp.getName()));//将日志信息插入到表格
```

#### 4.上传文件至阿里云oss存储桶

在阿里云申请存储桶，配置AccessKey，添加为环境变量。引入相关的依赖

控制层

服务层

DAO层

#### 5.根据ID查询

前端传递id

响应数据样例

```
{
  "code": 1,
  "msg": "success",
  "data": {
    "total": 2,
    "rows": [
       {
        "id": 1,
        "username": "jinyong",
        "name": "金庸",
        "gender": 1,
        "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2022-09-02-00-27-53B.jpg",
        "job": 2,
        "salary": 8000,
        "entryDate": "2015-01-01",
        "deptId": 2,
        "deptName": "教研部",
        "createTime": "2022-09-01T23:06:30",
        "updateTime": "2022-09-02T00:29:04"
      },
      {
        "id": 2,
        "username": "zhangwuji",
        "name": "张无忌",
        "gender": 1,
        "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2022-09-02-00-27-53B.jpg",
        "job": 2,
        "salary": 6000,
        "entryDate": "2015-01-01",
        "deptId": 2,
        "deptName": "教研部",
        "createTime": "2022-09-01T23:06:30",
        "updateTime": "2022-09-02T00:29:04"
      }
    ]
  }
}
```

控制层：接收参数传给服务层

服务层：接收参数传递给DAO层

DAO层：接收参数，由于涉及两张表 执行多表联查的sql语句

```
        select
            emp.*,
            ee.id as expr_id, -- 给 emp_expr 的 id 起个别名叫 expr_id
            ee.emp_id,
            ee.begin,
            ee.end,
            ee.company,
            ee.job as expr_job -- 顺便也给 job 起个别名，避免和 emp.job 冲突
        from
            emp
                left join
            emp_expr ee on emp.id = ee.emp_id -- 建议给表也起别名，更清晰
        where
            emp.id = #{id}
```



#### 6.修改员工

请求参数实例

```
{
    "id": 2,
    "username": "zhangwuji",
    "password": "123456",
    "name": "张无忌",
    "gender": 1,
    "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2022-09-02-00-27-53B.jpg",
    "job": 2,
    "salary": 8000,
    "entryDate": "2015-01-01",
    "deptId": 2,
    "createTime": "2022-09-01T23:06:30",
    "updateTime": "2022-09-02T00:29:04",
    "exprList": [
      {
        "id": 1,
        "begin": "2012-07-01",
        "end": "2015-06-20"
        "company": "中软国际股份有限公司"
        "job": "java开发",
        "empId": 2
      },
      {
        "id": 2,
        "begin": "2015-07-01",
        "end": "2019-03-03"
        "company": "百度科技股份有限公司"
        "job": "java开发",
        "empId": 2
      },
      {
        "id": 3,
        "begin": "2019-3-15",
        "end": "2023-03-01"
        "company": "阿里巴巴科技股份有限公司"
        "job": "架构师",
        "empId": 2
      }
    ]
  }
```

控制层：使用Emp类对象接受参数，传递参数给服务层。

服务层：接受参数，因为涉及两张表，分两步操作。第一步，传递emp对象至DAO层，执行upadte的sql语句。第二步，删掉该员工工作经历表，重新上传，调用3添加员工关于添加员工工作经历的信息。

DAO层：接收参数，执行操作。

#### 7.查询全部员工

略

### 数据统计

#### 员工信息统计

##### 员工性别统计

响应数据样例

```
{
  "code": 1,
  "msg": "success",
  "data": [
    {"name": "男性员工","value": 5},
    {"name": "女性员工","value": 6}
  ]
}
```

创建JobStatistic类承接data里的数据 

控制层：接受请求，调用服务层

服务层：调用DAO层

DAO层：执行sql语句

```
select (if gender= '1'，"男性员工"，"女性员工") name count(*) value from emp group by gender;
```



##### 员工职位统计

响应数据实例



```
{
  "code": 1,
  "msg": "success",
  "data": {
    "jobList": ["教研主管","学工主管","其他","班主任","咨询师","讲师"],
    "dataList": [1,1,2,6,8,13]
  }
}
```

观察数据，这个功能的响应数据不同于员工性别统计。

新建一个JobOption类，用来封装data中的数据。

控制层：接受前端请求，调用服务层，接受服务层返回的JobOption对象，封装进result类返回

服务层：调用DAO层，接受DAO层返回的List<Map<String,Object>>对象，将其转化为流的形式，分别封装进List<jobList>,List<dataList>,再将这两个list封装进JobOption类对象中，返回控制层

```
        List<Map<String,Object>> list = empMapper.getJobOption();
        JobOption jobOption = new JobOption();
        jobOption.setJobList(list.stream().map(map -> map.get("jobName")).toList());
        jobOption.setDataList(list.stream().map(map -> map.get("count")).toList());
```

DAO层：执行查询语句，将结果封装至List<Map<String,Object>>,返回服务层

### 全局异常管理

创建全局异常处理类，加上@RestControllerAdvice注解

### 零碎知识点

#### @RequsetBody和@RequestParam

![image-20250721224006056](./media/image-20250721224006056.png)



在 Spring MVC 控制器方法中，使用一个**自定义的 Java 类（POJO/DTO）作为参数来接收 URL 查询参数（Query Parameters）时，不需要**显式地使用 `@RequestBody` 或 `@RequestParam` 注解。

#### 日志级别

TRACE（最细）

DEBUG

INFO

WARN

ERROR

FATAL

#### 过滤器

##### 概述

**Filter 是 Servlet 规范层面的组件**，不是 Spring 提供的，而是 **Tomcat / Jetty / Undertow 等 Web 容器提供的标准功能**。

- 运行在 **Servlet 容器层**
- 针对 **所有请求**（包括静态资源、Controller、甚至 JSP 等）都能过滤
- 能在请求进入 Servlet 前做事，也能在响应返回浏览器前做事

##### 常见用途

统一编码处理（UTF-8）

跨域 CORS

XSS 防护

权限校验（适合无 session 的早期验证）

日志/性能统计

全局请求包装（RequestWrapper）

#### 拦截器

##### 概述

**Interceptor 是 Spring MVC 提供的组件**。

- 只拦截 **进入 Spring MVC 的请求**
- 不会处理静态资源（除非你手动配置）
- 拦截的是 **Controller 调用前后**
- 运行在 Spring 容器内部，能拿到许多 Spring 的 bean

![image-20250728151317460](./media/image-20250728151317460.png)

#### AOP核心概念：AOP的底层是动态代理技术

![image-20250728193929889](./media/image-20250728193929889.png)

##### 通知类型

![image-20250731171630180](./media/image-20250731171630180.png)

##### 通知顺序

![image-20250731172312134](./media/image-20250731172312134.png)

##### 切入点表达式

![image-20250729103148287](./media/image-20250729103148287.png)

##### 切入点表达式还可以使用或与运算符

![image-20250729110448616](./media/image-20250729110448616.png)

##### 切入点表达式还可以使用注解

![image-20250729151455598](./media/image-20250729151455598.png)

##### 连接点的使用

![image-20250731202007125](./media/image-20250731202007125.png)

为什么都是通知类型，调用的对象却不一样？

- **`@Around` (环绕通知) 拥有最大的权力，它可以完全控制目标方法的执行。** 它可以决定目标方法是否执行、何时执行、甚至修改参数和返回值。
- **`@Before` (前置通知) 等其他通知则没有这个权力，** 它们只是在目标方法执行前（或后）的某个特定时间点“插一脚”，但无法阻止或改变目标方法的执行流程。

为了在代码层面体现这种“权力”的差异，AOP框架设计了两个不同的接口：

1. **`JoinPoint`**：一个**“只读”**的信息提供者。
2. **`ProceedingJoinPoint`**：一个**“可干预”**的执行控制器。

#### maven依赖多重继承

![image-20250802215116259](./media/image-20250802215116259.png)

父类可以引入统一依赖。父类可以统一管理依赖的版本。

![image-20250729212511046](./media/image-20250729212511046.png)



在properties可以定义依赖的版本

![image-20250729212154374](./media/image-20250729212154374.png)

maven中自定义属性

![image-20250802221435603](./media/image-20250802221435603.png)

maven聚合工程

![image-20250729212820495](./media/image-20250729212820495.png)

![image-20250729213123078](./media/image-20250729213123078.png)

#### spring原理

springboot配置优先级

yaml--->yml--->properties--->java系统属性--->命令行参数

##### bean管理

使用@Scope注解声明作用域

![image-20250913222254337](./media/image-20250913222254337.png)

可以使用使用applicationcontext对象获取bean

![image-20250913224204517](./media/image-20250913224204517.png)

单例的bean在项目启动时由ApplicationContext创建，可以加@Lazy注解延迟创建，在第一次使用时才创建。

![image-20250913225551355](./media/image-20250913225551355.png)

##### 起步依赖

springboot的启动依赖是由maven的依赖传递完成。

##### 自动配置

Gson：将对象转为json格式。

引入Gson依赖之后，springboot是如何进行自动配置的？

底层是实现方法三和实现方法四。

###### 自动配置实现方案一

![image-20250915144803319](./media/image-20250915144803319.png)

在第三方包的目标类的包上加@Component注解，在启动类上加入@ComponentScan(backpackages{"com.example1","com.example2"}})，在此修改扫描组件的包，默认是启动类所在包及其子包。

###### 自动配置实现方案二

![image-20250801213342518](./media/image-20250801213342518.png)

方法三：在第三方包中实现ImportSelector类，可以动态调整要装配的类，在启动项上方使用@import导入该类

```
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        boolean hasFoo = ClassUtils.isPresent("com.example.FooService", null);
        if (hasFoo) {
            return new String[] { "com.example.FooConfig" };
        } else {
            return new String[] { "com.example.BarConfig" };
        }
    }
}

```

方法四：在启动项上加入@EnableHeaderConfig注解，在第三方包上加上@EnableHeaderConfig的注解类

###### 自动配置源码跟踪

![image-20250915161625962](./media/image-20250915161625962.png)

###### 自动配置-@Conditional

![image-20250801221132393](./media/image-20250801221132393.png)

![image-20250801221329965](./media/image-20250801221329965.png)

![image-20250922212007687](./media/image-20250922212007687.png) 

#### vue

![image-20250803121303101](./media/image-20250803121303101.png)

组合式api 选项式api

#### 密码加密

![image-20251111171753861](./../计算机网络/media/image-20251111171753861.png)

# 框架

## spring-doc

### 教程查阅

https://www.showapi.com/news/article/67424e564ddd79f11a0c2355

### 概述

Spring Doc 是一个强大的工具，旨在为Spring REST API生成OpenAPI 3.0文档。

### 使用方法

引入依赖

```
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>${spring-doc}</version>
    </dependency>
```

写配置信息

```
springdoc:
  api-docs:
    path: /v3/api-docs       //api文档访问路径
  swagger-ui:
    path: /swagger-ui.html   //ui访问路径
  group-configs:
    - group: 第一组
      packages-to-scan:
        - com.example.controller     //所扫描的包
    - group: 第二组
      packages-to-scan:
        - com.example.control
```

控制类注解及方法注解（可选）

使用@Tag注解标注

```
@RestController
@RequestMapping("/clazzs")
@Tag(name = "班级管理", description = "班级增删改查")
public class ClazzController {

    @Operation(summary = "查询", description = "通过ID查询")
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        return Result.success(clazzService.findById(id));
    }
```

参数注解（可选）

使用@Opeartion注解标注

```
@GetMapping("/users/{id}")
@Operation(summary = "Get user by ID", description = "Returns a user by the specified ID")
public User getUserById(@Parameter(description = "The ID of the user to retrieve", required = true) @PathVariable Long id) {
// 方法实现
}
```

描述实体类（可选）

使用@Schema注解标注

```
@NoArgsConstructor
@Data
@Schema(name = "班级",description = "班级的POJO类")
public class Clazz {

@Schema(description = "班级ID", example = "1")
private Integer id;

@Schema(description = "班级名称", example = "Java班")
private String name;

@Schema(description = "班主任ID", example = "1")
private Integer masterId;

@Schema(description = "班主任名字", example = "里美尤利娅")
private String masterName;

}
```

添加文档信息（可选）

```

```

