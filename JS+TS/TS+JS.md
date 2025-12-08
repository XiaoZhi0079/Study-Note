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

