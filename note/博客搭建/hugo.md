#### hugo搭建自己的博客

##### 安装hugo

```shell
brew install hugo
```

##### 验证是否安装成功

```shell
hugo version
```

##### 创建一个网站

```shell
hugo new site blog
```

##### 添加主题

为你的网站添加一个主题，hugo必须有主题才能编译启动

```shell
cd blog
git init
git clone https://github.com/enten/hyde-y.git themes/hyde-y

# 为网站配置主题
echo 'theme = "hyde-y"' >> config.toml
```

##### 添加博客页面

```shell
hugo new posts/blog_name.md
```

##### 启动服务

启动服务后，可以在浏览器中输入 http://localhost:1313

```shell
hugo server -D

                   | EN
+------------------+----+
  Pages            |  7
  Paginator pages  |  0
  Non-page files   |  0
  Static files     | 57
  Processed images |  0
  Aliases          |  1
  Sitemaps         |  1
  Cleaned          |  0

Total in 33 ms
Watching for changes in /Users/jankeyfu/Documents/blog/{content,data,layouts,static,themes}
Watching for config changes in /Users/jankeyfu/Documents/blog/config.toml
Serving pages from memory
Running in Fast Render Mode. For full rebuilds on change: hugo server --disableFastRender
Web Server is available at http://localhost:1313/ (bind address 127.0.0.1)
Press Ctrl+C to stop
```

##### 生成静态文件

```shell
hugo
```

