```shell
FROM <image_name>
MAINTAINER <author_name>
RUN
ADD <src> <destination>
CMD
EXPOSE <port>
ENTRYPOINT
WORKDIR
ENV
USER
VOLUME
```

- FROM ：表示基于哪个镜像进行创建，可以多次使用，表示会创建多个镜像
- MAINTAINER：表示镜像的作者
- EXPOSE：指定容器运行时监听的端口

