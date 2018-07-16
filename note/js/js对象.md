#### 对象定义

对象可以通过点号来设置或者获取其属性值，也可以通过方括号进行获取和设置，因此对象有时也称为关联数组

```javascript
var obj = new Object();
obj.property = val;	
obj[property] =val;

//对象初始化容器
var obj = {
    property1:value,
    proterty2:value2,
    ...
    functionName:function(){
    
	},
    
    functionName(){
        
    },
      
    //设置属性和获取属性值，可以直接通过.方法名获取或设置，不需要带括号
    get functionName(){

    },
	
    set functionName(){

    }
};
    
//构造函数法
function ObjectName(proterty...){
    this.property1 = value1;
    ...
} 

//对象创建
var obj = Object.create(ObjectName);

//为对象添加新属性
Object.prototype.propertyName = defalutValue;
```

#### 对象方法

```javascript
obj.hasOwnProperty(property)
Object.keys(obj);				//获取对象所有的属性js5之后
Object.getOwnPropertyNames(obj);//js5之后
```

对象定义属性

```javascript
Object.defineProperties(obj,{
		//属性定义    
	}
);

//删除对象非继承属性，也可以删除非var定义的全局变量
delete obj.property;
```

