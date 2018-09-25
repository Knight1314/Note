#### 数组

```php
# 为数组的每个元素都执行回调函数
array_map($callback,$array)	
```

#### 日期

```php
time()					返回当前unix时间戳
date('format',time())	格式化当前时间,Y四位数年份，m两位数月份，d两位数日期
```

#### 系统函数

```php
//创建是否具有递归权限为mode的文件夹，mode应为数字，不能为字符串，默认权限411
mkdir(dir_name,mode,recursive)	
```

#### 常用技巧

- 三元操作符的几种用法

  ```php
  $a = $condition ? $result1 : $result2;
  
  //可以如果result1=condition
  $a = $result1 ?: $result2;
  
  //或者
  $value = $value.$value2
  ```


#### 网络处理

```php
curl_init([url]); 	// 初始化cUrl会话
curl_exec($ch);		//执行cUrl请求
curl_close($ch);	//关闭会话

```

