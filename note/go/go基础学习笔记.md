1. 自增语句`i++`给`i`加1；这和`i += 1`以及`i = i + 1`都是等价的。对应的还有`i--`给`i`减1。它们是语句，而不像C系的其它语言那样是表达式。所以`j = i++`非法，而且++和--都只能放在变量名后面，因此`--i`也非法。

2. go只有一种循环形式，那就是for循环
  ```go
    //普通的for循环
    for init; condition; post{
  
  
   }
  
   //相当于while循环
   for condition {
  
   }
  
   //死循环
   for{
  
   }
  
   //类似于foreach类型
   for _,arg := range os.Args[1:] {
  
   }
  ```

3. 函数内的变量只在函数内部有效；函数外的变量在当前包内的所有文件均可以访问；如果变量或函数名称首字母大写，则表示可以在外部包内访问；在包级别声明的变量会在main入口函数执行前完成初始化，局部变量将在声明语句被执行到的时候完成初始化。

4. 

5. **flag**包

6. new()函数返回的是指针变量，如new(int)得到的是*int类型的变量

7. 数组定义

   ```go
   var a [3]int
   var a [4]int = [4]int{1,2,3,4}
   q := [...]int{1,2,3}//数组长度根据初始化的数值个数来定
   ```

#### 变量

- **变量声明**：变量声明可以省略变量类型或者变量初始值，如果省略了变量类型，则根据变量初始值确定变量的类型，如果省略了变量的初始值，则将变量类型的零值（0、false、""、nil）复制给变量。

  ```go
  var a int = 10
  var a = 10
  var a int
  
  var a,b,c int
  var a,b,c = 10,20.4,"str"
  ```

- **简短变量声明**：简短变量声明语句中必须至少要声明一个新的变量，否则会报错

  ```go
  a := 10
  ```

  

#### 函数

- **函数的声明**：函数可以有省略形式参数，只保留参数的类型即可；Go语言的函数可以有多个返回值，当返回的结果在函数定义的时候已经声明过，可以只使用`return`后面不加任何参数；

  ```go
  func funcName(param paramType...) returnType{
      ...
      retutn ...
  }
  
  func add(a int, b int) int{
      return a+b
  }
  func(int, int) int{
      return 0
  }
  
  func add (a int, b int) res int{
      res = a+b
      return 
  }
  ```

- **匿名函数**：函数可以作为变量的值，函数的零值为nil，但是函数不能作为map的key

- ```go
  func test(n int) int{
      return n
  }
  f := test
  fmt.Println(f(3))
  ```

- **可变参数函数**：可变参数函数虽然表面上和以切片作为参数相同，但是两者的实际定义是不同的。

- ```go
  func func_name(... type){
      
  }
  
  func func_name([] type){
      
  }
  ```

- **defer**：当函数内的所有非defer语句执行结束后才执行defer后面的语句，如果有多个defer语句，先执行最后一个，倒序执行。defer语句经常被用于处理成对的操作，如打开、关闭、连接、断开连接、加锁、释放锁。通过defer机制，不论函数逻辑多复杂，都能保证在任何执行路径下，资源被释放。释放资源的defer应该直接跟在请求资源的语句后。 


#### 内置函数

- len()	返回字符串的长度
- strconv.Atoi()  字符串转为整形，两返回值，一个转换成功的数值，一个错误。
- regex.MatchString("regex","string")
- template类

#### 包

- go语言导包的时候，如果有两个包的名字相同，则必须对其中一个包进行重命名，重命名只影响当前文件中的代码，对其他文件不影响。

  ```go
  import(
  	"crypto/rand"
      mrand "math/rand"
  )
  ```

- 当需要使用到一些包的内部函数进行一些变量初始化，但是却不会用到这些包的具体函数的时候，可以使用匿名函数，这样即使没有显示地调用导入包的函数，编译器也不会报错。

  ```go
  import(
  	_ "image/png"
  )
  ```

  