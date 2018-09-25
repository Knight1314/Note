- 仓库

  仓库由两部分组成如`dl.dockerpool.com/ubuntu`，`dl.dockerpool.com`表示的是注册地址，`ubuntu`表示的是一个项目的仓库名

- Docker Hub

  ```shell
  # 登录docker hub
  docker login
  
  # 登出docker hub
  docker logout
  
  # 在仓库中搜索docker镜像[查找收藏数在N以上的镜像]
  docker search image [--filter=stars=N]
  
  # 推送镜像至docker hub
  docker tag iamge:tag username/image:tag
  docker push username/image:tag
  ```

  