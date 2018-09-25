```shell
FROM <image_name>
MAINTAINER <author_name>
RUN <command>
ADD <src> <destination>
CMD
EXPOSE <port>
ENTRYPOINT
WORKDIR
ENV
USER
VOLUME
```



- FROM ：表示基于哪个镜像进行创建，像linux、nginx、mongo等等，可以多次使用，表示会创建多个镜像，此命令必须是文件的第一条语句。`FROM scratch`表示从一个空白镜像开始进行构建。

- MAINTAINER：表示镜像的作者

- RUN：表示在构建镜像的时候运行相应的命令。Dockerfile每一个指令都会构建一层。这样当有很多命令的时候，就会出现很多层，会让镜像显得很臃肿，Union FS 是有最大层数限制的，比如 AUFS，曾经是最大不得超过 42 层，现在是不得超过 127 层。可以在构建的时候，将多个命令放置在一层中构建，采用 `&&`进行命令拼接，使用`\`进行换行，最后在构建完相应的应用的时候，将不需要的文件进行删除，因为镜像是多层存储的东西，上一层的东西并不会在下一层中删除，任何无关的东西都应该删除掉。

  ```shell
  RUN buildDeps='gcc libc6-dev make' \
      && apt-get update \
      && apt-get install -y $buildDeps \
      && wget -O redis.tar.gz "http://download.redis.io/releases/redis-3.2.5.tar.gz" \
      && mkdir -p /usr/src/redis \
      && tar -xzf redis.tar.gz -C /usr/src/redis --strip-components=1 \
      && make -C /usr/src/redis \
      && make -C /usr/src/redis install \
      && rm -rf /var/lib/apt/lists/* \
      && rm redis.tar.gz \
      && rm -r /usr/src/redis \
      && apt-get purge -y --auto-remove $buildDeps
  ```

  

- EXPOSE：指定容器运行时监听的端口



#### 根据Dockerfile进行镜像构建

- Docker build

  ```shell
  # 在当前目录下进行docker镜像的构建
  docker build -t image:flag .
  ```

  

