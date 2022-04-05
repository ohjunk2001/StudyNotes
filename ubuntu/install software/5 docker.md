
https://docs.docker.com/engine/install/ubuntu/

```bash
$ sudo docker images # 查看已有的镜像
$ sudo docker ps # 查看正在使用的容器
$ sudo systemctl enable docker # auto startup
```

阿里云镜像

https://cr.console.aliyun.com/cn-hangzhou/instances/mirrors

```bash
$ sudo mkdir -p /etc/docker
$ sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://jfh21t2h.mirror.aliyuncs.com"]
}
EOF
$ sudo systemctl daemon-reload
$ sudo systemctl restart docker
```

```bash
$ docker pull mysql:5.7 # 拉取指定的 Mysql 版本
$ docker pull redis:3.4 
```

```bash
$ docker run -p 3306:3306 -name mysql \
-v /mydata/mysql/
```

