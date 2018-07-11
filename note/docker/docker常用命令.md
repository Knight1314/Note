- 获取docker的一些配置信息

  ```shell
  docker info	
  ```

- 查看镜像相关信息

     `docker images`显示镜像相关的信息，如仓库名、标签名、镜像ID、创建时间、镜像大小等。

     一个镜像可以有多个标签名，但是镜像ID是唯一的。镜像体积大小和Docker Hub上的大小不同，Docker Hub上的显示的压缩后的镜像大小，而使用`docker images`则显示的解压后的镜像大小。

     `docker images`列出的所有镜像和并不是最后所有镜像所占用的体积，应为docker镜像是多层存储结构，并且可以继承、复用，因此不同镜像可能会因为使用相同的基础镜像，从而拥有共同的层。因此实际体积比列出的所有体积和要小。可以使用`docker system df`查看镜像所占用的总体积。

     **虚悬镜像**：仓库名和标签名都为<none>的镜像就是虚悬镜像。这种现象是由于镜像更新，重新拉取镜像后仓库名和标签名移到了新的镜像上`docker pull repository:tag`。一般来说，虚悬镜像已经没有什么用处了，可以直接删除了，`docker image prune`

     **中间层镜像**：为了复用资源，docker会利用中间层镜像来构建顶层镜像，`docker iamges`列出的顶层镜像，使用`docker image ls -a`则会列出所有的镜像。

- ```shell
  docker images
  docker image ls
  docker iamge ls -a
  docker image ls repository
  docker image ls repository:tag
  docker image ls -f since|before=repository:tag	列出在镜像某个版本前|后的镜像
  docker image ls -f label=？	列出标签为某个值的镜像
  docker iamge ls -q	列出所有镜像ID
  docker image ls --format "{{.ID}:{.Repository}}"	只列出ID和仓库名
  docker image ls --format "table {{.ID}}\t{{.Repository}}\t{{.Tag}}"	以表格的形式列出数据
  docker image ls --digests #显示镜像摘要
  
  docker system df	#查看镜像占用空间情况
  
  docker image prune	#删除虚悬镜像
  ```

- 查找、拉取、推送镜像

     `docker pull` 默认地址为Docker Hub，一般是`IP:PORT`，仓库名是两段式名称，即`用户名/软件名`，默认用户为`library`。

     ```shell
     docker search image_name
     
     docker pull [选项] [Docker Registry 地址[:端口号]/]仓库名[:标签]
     docker pull image_name
     
     docker push image_name
     ```

- 启动、停止、重启容器

  `docker run` 启动容器，`-i`表示交互式操作；`-t`表示终端；`bash`表示使用`bash`终端进行交互；`--rm`表示退出容器后将容器删除，可以避免浪费空间；`ubuntu:16.04`表示镜像名称；

  ```shell
  docker run image_name
  docker run -it --rm ubuntu:16.04 bash
  
  docker stop job_name
  
  docker restart job_name
  ```

- 删除容器

- ```shell
  docker stop job_name
  
  docker rm job_name
  ```

- 将容器当前状态保存为镜像

- ```shell
  docker commit job_name image_name
  ```

- 查看镜像的历史版本

- ```shell
  docker history image_name
  ```

- 删除镜像

  镜像可以是docker的短ID、长ID、镜像名、仓库名：标签名、镜像摘要，

  ```shell
  docker image rm [选项] <镜像1> [<镜像2> ...]
  ```

  

