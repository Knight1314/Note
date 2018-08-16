##### 设置路由访问

```go
http.HandleFunc("/", func_name)
```

##### 设置监听端口

```go
err := http.ListenAndServe(":port", nil)
```



##### http处理方法

```go
func func_name (w http.ResponseWriter, r *http.Request){
    
}
```



##### http.Request对象

```go
r *http.Request
r.Method 				//返回请求方式，POST，GET，PUT，DELETE等
r.parseForm				//解析表单，以便获取表单中的参数

//获取表单参数，包括POST，GET和queryString中的参数，如果url中也包含同名参数，返回值为一个slice，r.Form是一个url.Values类型的变量，里面保存的key-value结构的数据。在做参数校验的时候，如果没有对应的参数则没有相应的条目，使用下面[]形式会报错，推荐使用.Get方式，.Get只能回去一个值，如果是map，需要多个值的时候，只能选择[]方式。
r.Form["param_name"]	
r.Form.Get("param_name")

//不需要提前调用r.parseForm解析表单，只会返回同名参数中的第一个，不存在返回空字符串
r.FormValue("param_name")	

//解析文件上传控件，如果文件大小超过了maxMemory，那么剩下的部分将存储在系统的临时文件中
r.ParseMultipartForm("maxMemory")
//获取上面的文件句柄
r.FormFile
```

模板解析

```go
t,_ := template.ParseFiles("login.gtpl")
t.Execute(w, nil)
```

#### 数据库

```go
_ "github.com/go-sql-driver/mysql"
```

```go
/**
数据源名称方式：user:password@/dbname
user@unix(/path/to/socker)/dbname?charset=utf8
user:password@tcp(localhost:5555)/dbname?charset=utf8
user:password$tcp([de:ad:be:ef::ca:fe]:80)/dbname
*/
db,err := sql.Open("driver_name","datasource_name")

//sql预编译
stmt,err := db.Prepare("sql")

//执行sql语句
rows,err  := db.Query("sql")

//执行预编译的sql语句,传入预编译所需要的参数
res,err := stmt.Exec("param")


//返回sql影响的数据条数
res.RowsAffected()

//判断是否还有结果
rows.Next()

//将rows中的数据复制给相应的变量
rows.Scan(&var)
```

