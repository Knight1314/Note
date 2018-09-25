#### 变量声明

```javascript
var		//默认值undefined
let		//声明一个块作用域的局部变量，默认值undefined。
const	//声明一个块作用域的只读的命名常量，必须初始化。常量定义的对象和数组内部的属性是可以更改的。
```

#### 循环

```javascript
for(express; condition; express){
    statement;
}

while(condition){
 	statement;     
}

do{
    statement;
}while(condition);

//获取的是数组的下标
for(var in obj){
    
}

//获取的是数组的值
for(var of obj){
    
}
```

#### 标签：

```javascript
label:while(){
    while(){
    	//跳出并结束循环至标签
        break label;
    	//跳出循环至标签继续下一次循环
    	continue labe;
    }
}
```

