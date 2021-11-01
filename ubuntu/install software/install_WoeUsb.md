# Ubuntu 20.04 安装 WoeUSB

WoeUSB 在 Github 上的地址 

https://github.com/slacka/WoeUSB/releases

在 Ubuntu 20上安装会遇到依赖问题

github 上有解决办法

https://github.com/slacka/WoeUSB/issues/344

```bash
$ sudo add-apt-repository ppa:nilarimogard/webupd8
$ sudo apt update
$ wget http://mirrors.kernel.org/ubuntu/pool/universe/w/wxwidgets3.0/libwxgtk3.0-0v5_3.0.4+dfsg-3_amd64.deb
$ sudo dpkg -i libwxgtk*_amd64.deb
$ sudo apt install woeusb
```

