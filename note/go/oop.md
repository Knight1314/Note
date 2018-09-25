go语言中的对象就是结构体，可以在结构的基础上为其设置对应的方法，方法可以被声明到任意类型，只要不是一个指针或者一个interface。

```go
type Point struct{
    X,Y float64
}

func (p Point) Distance(q Point) float64{
    ...
}

type Path []Point
func(p Path) Distance() float64{
    ...
}
```

如果需要修改对象的内容，就需要使用对象指针作为方法的承载体了

```go
type Point struct{
    X,Y float64
}

func (p *Point) Scale(factor float64){
    p.X *= factor
    p.Y *= facotr	
}

//调用
p := Point{1,2}
&p.Scale(2)

p := &Point{1,2}
p.Scale(2)

//可以直接省略指针，使用对象进行调用，但是这个对象必须是有地址的，不能使用临时变量
p := Point{1,2}
p.Scale(2)

//false
Point{1,2}.Scale(2)
```

如果一个结构体中内嵌有一个结构体，那么这个结构体将可以使用内嵌有结构体的方法

```go
type ColoredPoint{
    point
    Color color.RGBA
}

p:=ColoredPoint{}
q:=ColoredPoint{}
p.Distance(q.Point)
```

方法可以当做一个变量，然后通过这个变量去调用内部逻辑

```
var dis = p.Distace
dis(q)
```

#### 接口

GO语言中的接口实现就是拥有某个接口定义的所有方法。如DefineWriter实现了Writer接口的Write方法，那DefineWriter就是Writer类型的

```go
type Writer interface{
    Write(p []byte) (n int, err error)
}

type DefineWriter int
func (D *DefineWriter) Write(int, error){
    //do something...
}
```

接口定义与扩展

```go
type Writer interface{
	Write(p []byte) (n int, err error)
}
type Reader interface{
    Reade(p []byte) (n int, err error)
}

type ReadWriter interface{
    Reader
    Writer
}

type ReadWriter interface{
    Write(p []byte) (n int, err error)
    Reade(p []byte) (n int, err error)
}
```

空接口类型可以接受所有类型的数据

```go
var any interface{}
any = 12
any = 12.4
any = "12.4"
any = map[string]int{"first":1}
```

- 接口实现**泛型编程**

  所谓的泛型编程，就是我不需要知道你传递的数据是何种类型，我只需要知道你传递的数据类型实现了我所需要的方法即可。

- 接口实现**隐藏具体实现**

  接口通过泛型，根据传递的参数返回不同类型的数据结构。

#### 反射

- 变量有`type`和`value`组成

- `type`包括`static type`和`concrete type`,前者表示编译时显示的类型，如`int`,`string`等，或者表示的是 系统运行时看见的类型

- `reflect.TypeOf()`和`reflect.ValueOf()`, 通过`TypeOf`获取到的类型获取结构体的具体参数使用`Field(index)`,获取字段数量使用`NumField`, 获取具体方法使用`Method(index)`,方法数量使用`NumMethod`，获取指定方法使用`MethodByName()`,然后通过`call(args)`方法调用反射获取的方法，期`arg`之能是`[]reflect.Value`类型的数据。

- 反射修改数据的值

- ```go
  //通过反射获取变量的类型指针，只能是指针，
  pointer = reflect.ValueOf(&num)
  
  //获取指针对应的元素数据类型，如果pointer不是指针则会报panic
  newValue = pointer.Elem()
  
  //判断此变量是否可以重新赋值，只有指针可以
  newValue.CanSet()
  
  newValue.SetFloat(77)
  
  
  ```

- 

- 类型转换`value.Interface().(已知的类型)`