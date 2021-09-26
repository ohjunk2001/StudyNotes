# Cloudreve

https://cloudreve.org/

## Download and install

```
# 创建一个文件夹,将下载好的压缩包放在这里面。
$ mkdir ~/Cloudreve

# 解压程序包
$ tar -zxvf cloudreve_VERSION_OS_ARCH.tar.gz

# 赋予执行权限
$ chmod +x ./cloudreve

# 启动 Cloudreve
$ ./cloudreve
->
   ___ _                 _                    
  / __\ | ___  _   _  __| |_ __ _____   _____ 
 / /  | |/ _ \| | | |/ _ | '__/ _ \ \ / / _ \   
/ /___| | (_) | |_| | (_| | | |  __/\ V /  __/
\____/|_|\___/ \__,_|\__,_|_|  \___| \_/ \___|

   V3.3.2  Commit #db7489f  Pro=false
================================================

[Info]    2021-09-24 08:31:13 初始化数据库连接
[Info]    2021-09-24 08:31:13 开始进行数据库初始化...
[Info]    2021-09-24 08:31:13 初始管理员账号：admin@cloudreve.org
[Info]    2021-09-24 08:31:13 初始管理员密码：rMSJsnnY
[Info]    2021-09-24 08:31:13 数据库初始化结束
[Info]    2021-09-24 08:31:13 初始化任务队列，WorkerNum = 10
[Info]    2021-09-24 08:31:13 初始化定时任务...
[Info]    2021-09-24 08:31:13 当前运行模式：Master
[Info]    2021-09-24 08:31:13 开始监听 :5212
```

> 管理员账号，密码一定要记住，它们只会出现一次。没记住那就删除所有文件从头再来吧。

## Linux Daemon

我们利用 Systemed 做进程守护。

```
# 编辑配置文件
$ sudo vim /usr/lib/systemd/system/cloudreve.service
# 在文件里添加以下内容
->
[Unit]
Description=Cloudreve
Documentation=https://docs.cloudreve.org
After=network.target
After=mysqld.service
Wants=network.target

[Service]
WorkingDirectory=~/cloudreve
ExecStart=~/cloudreve/cloudreve
Restart=on-abnormal
RestartSec=5s
KillMode=mixed

StandardOutput=null
StandardError=syslog

[Install]
WantedBy=multi-user.target

# 更新配置
systemctl daemon-reload

# 启动服务
systemctl start cloudreve

# 设置开机启动
systemctl enable cloudreve
```

## 管理命令

```
# 启动服务
systemctl start cloudreve

# 停止服务
systemctl stop cloudreve

# 重启服务
systemctl restart cloudreve

# 查看状态
systemctl status cloudreve
```

iP:端口号访问

```
sudo ufw allow 5212 # 开放 5212 端口
```

