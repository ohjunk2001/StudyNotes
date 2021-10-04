# FRP 反向代理

https://github.com/yanghao9527/frp/releases

[参考2](https://cloud.tencent.com/developer/article/1748214#:~:text=frp%20%E6%98%AF%E4%B8%80%E4%B8%AA%E4%B8%93%E6%B3%A8%E4%BA%8E%E5%86%85%E7%BD%91%E7%A9%BF%E9%80%8F%E7%9A%84%E9%AB%98%E6%80%A7%E8%83%BD%E7%9A%84%E5%8F%8D%E5%90%91%E4%BB%A3%E7%90%86%E5%BA%94%E7%94%A8%EF%BC%8C%E6%94%AF%E6%8C%81%20TCP%E3%80%81UDP%E3%80%81HTTP%E3%80%81HTTPS%20%E7%AD%89%E5%A4%9A%E7%A7%8D%E5%8D%8F%E8%AE%AE%E3%80%82.%20%E5%8F%AF%E4%BB%A5%E5%B0%86%E5%86%85%E7%BD%91%E6%9C%8D%E5%8A%A1%E4%BB%A5%E5%AE%89%E5%85%A8%E3%80%81%E4%BE%BF%E6%8D%B7%E7%9A%84%E6%96%B9%E5%BC%8F%E9%80%9A%E8%BF%87%E5%85%B7%E6%9C%89%E5%85%AC%E7%BD%91%20IP,%E8%8A%82%E7%82%B9%E7%9A%84%E4%B8%AD%E8%BD%AC%E6%9A%B4%E9%9C%B2%E5%88%B0%E5%85%AC%E7%BD%91%E3%80%82.%20%E8%BF%99%E9%87%8C%E7%AE%80%E5%8D%95%E8%AE%B0%E5%BD%95%E5%85%B6%E5%AE%A2%E6%88%B7%E7%AB%AF%E5%8F%8A%E6%9C%8D%E5%8A%A1%E7%AB%AF%E7%9A%84%E9%85%8D%E7%BD%AE%E6%96%B9%E6%B3%95%E3%80%82.%20github%EF%BC%9A%20https%3A%2F%2Fgithub.com%2Ffatedier%2Ffrp.%20document%EF%BC%9A%20https%3A%2F%2Fgofrp.org%2Fdocs%2F.)

[参考3](https://www.jianshu.com/p/e8e26bcc6fe6)

在使用frp之前，需要一台有公网IP的服务器（下文称外网主机），一台需要实现内网穿透的机器（下文称内网主机），SSH工具，以及一个域名（如果只是建立SSH反向代理则不需要域名）。



## 处理服务器上的安装包

下载解压后

```shell
# 外网主机作为服务端，可以删掉不必要的客户端文件，使用rm指令删除文件
$ rm -f frpc
$ rm -f frpc.ini
# 接下来要修改服务器配置文件，即 frps.ini 文件。
$ vi frps.ini
->
[common]
bind_port        = 17000               # 服务监听端口
bind_addr        = 0.0.0.0             # 监听IP
token            = 123456              # 密钥
dashboard_port   = 17001               # web面板
dashboard_user   = admin               # 面板用户名
dashboard_pwd    = admin               # 面板密码
subdomain_host   = *.your_doming.com   # WEB访问域名绑定（绑定后只能绑定子域名访问）
vhost_http_port  = 10000               # web服务http端口
vhost_https_port = 10001               # web服务https端口

# 注：以上配置根据需求设置，最简单的配置只需要前两行，既仅配置服务监听端口，其余按需配置。

[common]
bind_port = 7000
vhost_http_port = 8080



bind_port是自己设定的frp服务端端口，vhost_http_port是自己设定的http访问端口。
```

## 处理客户端上的安装包

下载解压赋予权限

```shell
$ rm -f frps
$ rm -f frps.ini
$ vi frpc.ini
->
[common]
server_addr = free.frp.ioiox.com  # 服务器IP或者地址
server_port = 7007                # 服务器提供的端口号
token = www.ioiox.com             # 服务器提供的token

[web1]                            # 为避免错误,一定需更改为比较特殊的名称,不能和服务器端其他配置重名.
type = http                       # http协议
local_ip = 127.0.0.1              # 127.0.0.1指穿透本机,也可以填写内网IP.
local_port = 5000                 # 群晖内网HTTP端口,默认为5000.
custom_domains = nas.ioiox.com    # 填写你的域名

[web2]                            # 为避免错误,一定需更改为比较特殊的名称,不能和服务器端其他配置重名.
type = https                      # https协议
local_ip = 127.0.0.1              # 127.0.0.1指穿透本机,也可以填写内网IP.
local_port = 5001                 # 群晖内网HTTPS端口,默认为5001.
custom_domains = nas.ioiox.com    # 填写你的域名

[OpenVpn]
type = udp                        # 协议
local_ip = 192.168.123.142        # 127.0.0.1指穿透本机,也可以填写内网IP.
local_port = 1194                 # 内网端口
remote_port = 11194               # 远程连接端口
-------------------------------------------------------------------------------------------------------
[common]
server_addr = x.x.x.x
server_port = 7000

[ssh]
type = tcp
local_ip = 127.0.0.1
local_port = 22
remote_port = 6000

[nas]
type = http
local_port = 5000
custom_domains = no1.sunnyrx.com

[web]
type = http
local_port = 80
custom_domains = no2.sunnyrx.com


上面的配置和服务端是对应的。

[common]中的server_addr填frp服务端的ip（也就是外网主机的IP），server_port填frp服务端的bind_prot。

[ssh]中的local_port填群晖的ssh端口。

[nas]中的type对应服务端配置。local_port填群晖的DSM端口。custom_domains为要映射的域名，记得域名的A记录要解析到外网主机的IP。

[web]同上，local_port填群晖的web端口。这里创建了两个http反向代理是为了分别映射群晖两个重要的端口，5000和80，前者用于登录群晖管理，后者用于群晖的Web Station和DS Photo。
```

## 启动

```shell
# 前台启动
$ ./frpc -c ./frpc.ini

# 后台启动命令
$ nohup ./frpc -c ./frpc.ini &
```