# JavaScript 基础（必须掌握）

## 变量与常量

### 重点内容：var  let  const

var（目前已被淘汰）：变量提升，函数作用域（只要函数function{}可以限制其作用域），声明的变量可修改。

let：变量提升，块级作用域（{}即可限制其作用域），声明的变量可修改。

const：变量提升，块级作用域，声明的变量不可再次赋值，如果是对象或者数组，值或元素可修改。

## 数据类型

注：在TS中，可以显示注明数据类型，也可以由TS做类型推断。

### 原始类型

Number

String

Boolean

null

Symbol：表示独一无二的值，常用于对象的属性名。

```
let sym = Symbol('description');
```

Bigint：用于表示大于 `2^53 - 1` 的整数。

```
let bigIntNum = BigInt(123456789123456789123456789);
```

undefined

```
let a;
console.log(a); // undefined
```

### 引用类型

Object：对象类型，存储一组键值对。

```
let person = {
  name: "Alice",
  age: 30
};
```

Array：数组类型，属于对象类型的一种，存储一组有序的值。

```
let arr = [1, 2, 3, 4];
```

##Function：函数

```
const fn = function () {
  console.log("hello");
};
```

Date：时间对象 处理时间

```
let now = new Date();
console.log(now); // 当前时间
```

RegExp：正则表达式

```
let regex = /abc/;
```

（ts特性）tuple:元组，表示一个固定长度且类型各异的数组。

```
let person: [string, number] = ["Alice", 30];  // 第一个元素是 string，第二个是 number

```

（ts特性）enum：枚举，用于定义常量

```
enum Color {
  Red,
  Green,
  Blue
}

let c: Color = Color.Green;  // 使用枚举值
```

（ts特性）any：用于表示任何类型，等同与js的动态类型

```
let value: any = "Hello";
value = 42;  // 允许重新赋值为不同类型
```

（ts特性）unknown：与 `any` 类似，但更安全，只有在做类型检查之后，才能对其进行操作。

```
let value: unknown = "Hello";
if (typeof value === "string") {
  console.log(value.length);  // 可以安全地访问字符串的属性
}
```

## 函数

### 函数声明

```
function fn() {
  console.log("hello");
}
```

### 函数表达式

```
//赋值给变量
const fn = function () {
  console.log("hello");
};
//箭头函数
const fn = () => {
  console.log("hello");
};
//给变量的函数加类型（TS 特性）
const add: (x: number, y: number) => number =(x, y) => x + y;
```

### 函数参数默认值

```
function greet(name = "匿名用户") {
  console.log("你好：" + name);
}

greet(); // 你好：匿名用户

//TS写法
function greet(name: string = "匿名用户") {
  console.log(name);
}
```

### 剩余参数

注：剩余参数 **必须写在最后**。

```
function sum(...nums) {
  return nums.reduce((a, b) => a + b, 0);
}

sum(1, 2, 3, 4); // 10

//TS写法
function sum(...nums: number[]): number {
  return nums.reduce((a, b) => a + b, 0);
}
```

### 展开运算符

## 条件与循环

### if else

### switch

### 三元表达式

### for

### while

### for...of

遍历可迭代对象（数组、字符串、Set、Map）

```
for (const value of iterable) {
  // value 是每个元素的值
}

//示例

//遍历数组
const arr = [10, 20, 30];

for (const item of arr) {
  console.log(item);
}

//遍历字符串
for (const ch of "abc") {
  console.log(ch);
}
```

### for...in

遍历对象的键（key），如对象的值

```
for (const key in obj) {
  // key 是属性名 obj[key] 是属性值
}

//示例
const person = {
  name: "Alice",
  age: 25
};

for (const key in person) {
  console.log(key, person[key]);
}
```

## 对象与数组操作

### 解构赋值

**解构赋值** 是 ES6 中引入的语法糖，允许你从对象或数组中提取值，并将它们赋给变量，写法更加简洁和可读。

### 属性访问

使用.访问属性

当属性名包含空格、数字或特殊字符时，需要使用[]访问属性，[]也可用于动态访问。

### 数组方法（`map`, `filter`, `forEach`, `find`, `some`, `reduce`）

## 模块化

## Promise & 异步



# TypeScript

类型限定

```
let str = 'abc'
str = 10  //报错 TypeScript会自动推断类型 例子中推断为string 所以不能赋值为number

let str: string
str = 'abc' 

function add(a: number, b: number): number {
  return a + b;
}
```

类型缩小

```
function printLength(x: string | string[]) {
  if (typeof x === "string") {
    console.log(x.length);     // x 一定是 string
  } else {
    console.log(x.length);     // x 一定是 string[]
  }
}
```

