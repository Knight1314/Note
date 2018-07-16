#### 数组

数组的定义

```javascript
var arr = [];
var arr = new Array();
var arr = new Array(length);
```

数组的遍历

```javascript
fruits.forEach(function (item, index, array) {
    console.log(item, index);
});
```

数组函数

```javascript
.push(element)
.pop()
.shift()
.unshift(element)
.indexof(element)
.splice()
.slice()//数组复制
```

数组的使用

可以使用中括号加索引的方式获取数组中的元素值，也可以使用点加上属性名获取元素值，但是不能使用点加上索引获取元素值。

```javascript
arr[0]
arr.key
```

内置对象

内置对象`length`可以修改，当修改为比当前数组中元素个数小的时候，会将部分数据删除。

```javascript
arr.length
```

#### 字符串

可以使用单引号或者双引号创建字符串字面量，也可以通过创建字符串对象的方式获得一个字符串实例。在使用字面量创建字符串的时候，引号中如果是数学表达式，会先进行表达式的运算，然后在赋值给字符串变量。还可以通过反引号来创建多行字符串，

```javascript
"string"
'string'
new String("string");

var str = "2+2"; //4
var str = new String("2+2");//2+2

var str = `first line
second line`；
//first line
//second line
```

字符串常用函数

| 方法                                                         | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [`charAt`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/charAt), [`charCodeAt`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/charCodeAt), [`codePointAt`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/codePointAt) | 返回字符串指定位置的字符或者字符编码。                       |
| [`indexOf`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/indexOf), [`lastIndexOf`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/lastIndexOf) | 分别返回字符串中指定子串的位置或最后位置。                   |
| [`startsWith`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/startsWith), [`endsWith`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/endsWith), [`includes`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/includes) | 返回字符串是否以指定字符串开始、结束或包含指定字符串。       |
| [`concat`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/concat) | 连接两个字符串并返回新的字符串。                             |
| [`fromCharCode`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/fromCharCode), [`fromCodePoint`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/fromCodePoint) | 从指定的Unicode值序列构造一个字符串。这是一个String类方法，不是实例方法。 |
| [`split`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/split) | 通过将字符串分离成一个个子串来把一个String对象分裂到一个字符串数组中。 |
| [`slice`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/slice) | 从一个字符串提取片段并作为新字符串返回。                     |
| [`substring`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/substring), [`substr`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/substr) | 分别通过指定起始和结束位置，起始位置和长度来返回字符串的指定子集。 |
| [`match`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/match), [`replace`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/replace), [`search`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/search) | 通过正则表达式来工作.                                        |
| [`toLowerCase`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/toLowerCase), [`toUpperCase`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/toUpperCase) | 分别返回字符串的小写表示和大写表示。                         |
| [`normalize`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/normalize) | 按照指定的一种 Unicode 正规形式将当前字符串正规化。          |
| [`repeat`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/repeat) | 将字符串内容重复指定次数后返回。                             |
| [`trim`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/trim) | 去掉字符串开头和结尾的空白字符。                             |

字符串表达式嵌套

```javascript
"str is".(1+2)."long"
`str is ${1+2} long`
```

#### 国际化

```javascript
Intl.DateTimeFormat
Intl.NumberFormat
Intl.Collator
```

