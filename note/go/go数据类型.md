#### 数组

```go
var a [3]int
var a [4]int = [4]int{1,2,3,4}
q := [...]int{1,2,3}		//数组长度根据初始化的数值个数来定
r := [...]int{99:-1}		//前99个值为0，最后一个值赋值为-1
l :- [...]int{1,2,3,:5,-1}  //结果为 [1,2,3,0,0,-1] 5:表示直到第五个元素都是0，这个值必须比前面已有的元素个数大
```

##### 数组比较

数组的长度包括在数组的类型中，不同类型的数组是不能进行比较的，编译前就会报错：`invalid operation: a == c (mismatched types [2]int and [3]int)`

```go
var a [2]int = [2]{1,2}
var b [2]int = [...]int{1,2}
var c [3]int = [3]int{1,2}
var d [2]int = [2]int{1,3}

a=b
a!=c
a!=d
```

##### 数组函数

```go
len(arr)	//返回数组的长度
range(arr)	//返回数组的索引和值
```

#### Slice

```go
arr := [...]T{}		
slice := arr[offset:end]//引用[offset,end)数组
slice := arr[offset:]	//引用[offset,len(arr))数组
slice := arr[:end]		//引用[0,end)数组
slice := arr[:]			//引用所有

make([]T, len, cap)		//创建一个长为len，容量为cap的slice
```

slice有两个参数，容量和长度，容量表示为数组从offset开始到数组末尾的长度，长度表示从数组中截取的长度。slice可以进扩展，`slice[:len]`表示将数组扩展到长度为`len`,但是slice扩展的长度不能超过其容量，否则会出现panic。

slice不能使用`==`进行比较，除了标准库提供了高度优化的`bytes.Equal`函数来判断两个字节型slice是否相等，其余类型的slice都需要自定义比较函数。但是slice可以和nil进行比较。

##### slice函数

```go
append(slice, val)
append(slice, val1, val2, val3)
```

#### Map

map中的元素不是一个变量，因此不能对map的元素进行取址操作。如`&map['key']` 。禁止对map元素取址的原因是map可能随着元素数量的增长而重新分配更大的内存空间，从而可能导致之前的地址无效

```go
ages := make(map[string]int)

ages := map[string]int{
    "alice":   31,
    "charlie": 34,
}

map[string]int{}

//判断值是否为空
if val,ok := map["key"]; !ok{
    
}
```

##### 函数

```go
delete(map, key)
for key,val := range map{
    
}

for key:=range map{
    
}
```

#### 结构体

结构体对象通过`.`操作内部变量；如果结构体成员名字是以大写字母开头的，那么该成员就是导出的；如果要在函数内部修改结构体成员的话，用指针传入是必须的；因为在Go语言中，所有的函数参数都是值拷贝传入的，函数参数将不再是函数调用时的原始变量。
```go
type Employee struct {
    ID        int
    Name      string
}

var jankey Employee
jankey.ID = 10
jankey.Name = JankeyFu

//结构体面值
p := Employee{1, "jankey"}
p := Employed{ID:1, Name:"jankey"}

//获取变量指针
&jankey.ID


pp := &Point{1, 2}
pp := new(Point)
*pp = Point{1, 2}


```
 结构体可以通过`==`等运算符进行比较。

结构体可以通过访问匿名成员获取深层次的对象变量

```go
type Point struct{
    X,Y int
}
type Circle struct{
    Center Point
    Radius int
}
type Wheel struct{
    Circle circle
    Spokes int
}

var w Wheel
w.Circle.Center.X = 10 //等价于 w.X

//构建实例时只能层层构造
w = Wheel{Circle{Point{8, 8}, 5}, 20}

```

#### Json

```go
//紧凑的json
json.Marshal(obj)

//格式化的json
json.MarshalIndent(obj)

//json解析为结构体
var title []struct{Title string} 
json.Unmarshal(data, &titles)


json.Decoder().decode(&var)


//omitempty 表示成员为零值的时候不导出为json
type Movie struct {
    Title  string
    Year   int  `json:"released"`
    Color  bool `json:"color,omitempty"`
    Actors []string
}



```

#### 模板

```

```







