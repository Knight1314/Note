- 数值运算`$(($i+$j))`，但是shell只支持整数的四则运算。

- 子进程/父进程，使用`source`执行脚本，则脚本中的变量会成为全局变量，其余执行脚本的方式，脚本中的变量都只会是临时变量，当脚本运行结束后，临时变量也会清除。

- test

  ```shell
  # 文件类型
  test -e 	文件名是否存在 
  test -f 	文件名是否存在并且是否为文件
  test -d		文件名是否存在并且是否为目录
  
  #文件权限 test -command filename
  test -r		文件是否有可读权限
  test -w		文件是否有可写权限
  test -x		文件是否有可执行权限
  
  # 文件比较 test file1 -command file2
  test -nt	判断文件是否更新
  test -ot	判断文件是否更旧
  test -ef	判断是否为同一个文件,硬链接返回true，软连接返回false
  
  # 数值比较 test n1 -command n2
  test -eq
  test -ne
  test -gt
  test -lt
  test -ge
  test -le
  
  # 字符串比较
  test -z string		判断是否为空字符串
  test [-n] string	判断是否从是否非空
  test str1 = str2	
  test str1 != str2
  
  # 逻辑符号
  -a 					逻辑与
  -o					逻辑或
  -!				    逻辑非
  ```
