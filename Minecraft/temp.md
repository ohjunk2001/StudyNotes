# 服务器器核心

```
$ git clone https://gitee.com/hd2098101/minecraft_-server.git
$ cat file.tar* | tar -xv

```



# 管理面板

https://mcsm.suwings.top/#download

## 安装

```
$ wget -qO- https://gitee.com/Suwingser/MCSManager-installer/raw/master/install.sh | bash

->

--------------- Complete ---------------
 Successfully installed!!!
 Directory: /opt/MCSManager/
--------------- Complete ---------------
Joining system service...
Create file: /usr/lib/systemd/system/mcsm.service
complete.

--------------- Quickstart ---------------
 Start： systemctl start mcsm
 Stop:   systemctl stop mcsm
 Status: systemctl status mcsm
--------------- Quickstart ---------------
```

## 启动停止

```
$ systemctl start mcsm
$ systemctl stop mcsm
```

## 网页地址

http://42.193.120.165:23333