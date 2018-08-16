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

