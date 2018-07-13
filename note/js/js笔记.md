#### 函数

```javascript
function func_name(param...){
	body;
    return return_val;
}
```

javascript的函数可以当做变量进行赋值，然后通过变量进行函数的调用。

```javascript
var func = function(n){return n*n};
func(2);//结果为2*2=4
```

js函数声明可以在调用的后面，但是函数表达式必须在调用前声明。

```javascript
square(10);
function square(n){
    return n*n;
}

//Uncaught TypeError: add is not a function
add(3,5);
var add = function(a, b){return a+b;};
```

js函数可以将函数名作为参数进行传递

```javascript
function test(f, a){
    f(a);
}

function f(a){
    return a * a;
}
```

所谓函数的闭包就是在函数定义内部还有函数的定义,在闭包中变量名称冲突的时候，越靠近内部的变量优先级越高，会覆盖前面定义过的变量。

```javascript
function outside(){
    function inside(){
        
    }
}
```

函数的参数都存放在一个数组`arguments`中，它是一个类数组，含有索引和长度属性，但是不具有数组的操作对象的方法。

```javascript
function test(){
    
}
//arguments[0] = 1  arguments[3] = 4
test(1,2,3,4)

```

函数可以设置默认值，如果没有设置的话，它的默认值是`undefined`

```javascript
function multiply(a,b=1){
    
}
```

js可以定义不确定函数，

```javascript
function multiply(multiplyer, ...theOther){
    //x => multiplyer * x 等价于 return x * multiplyer
    return theOther.map(x => multiplyer * x);
}
```

预定义的函数

```
eval()
uneval()
ifFinite()
isNaN()
parseFloat()
parseInt()
decodeURI()	//统一资源定位符解码
decodeURIComponent()
encodeURI()	//统一资源定位符编码
encodeURIComponent()
escape() // 已废弃
unescape() //已废弃
```

