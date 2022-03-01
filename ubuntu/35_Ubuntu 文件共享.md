# 文件共享

## 1. 安装 smbma

打开文件管理器，随便找一个文件，右键双击点击属性，找到共享。

第一次打开因为没有安装 smbma 所以系统会提示你安装 smbma 。

安装后还不能连接

## 2. 创建一个共享文件夹

```shell
$ mkdir /home/yanghao/smbshare
```

## 3. 修改 samba 配置文件

```shell
// 修改 /etc/samba/smb.conf
$ sudo vim /etc/samba/smb.conf
// 在smb.conf文件最后加上以下内容

[share]
    path = /home/yanghao/smbshare
    public = yes
    writable = yes
    valid users = gzd
    create mask = 0644
    force create mode = 0644
    directory mask = 0755
    force directory mode = 0755
    available = yes
```

### 关于smb.conf的几点解释：

-  [share]表示共享文件夹的别名，之后将直接使用这个别名
-  `force create mode` 与 `force directory mode`的设置是因为Windows下与Linux下文件和文件夹的默认权限不同造成的，Windows下新建的文件是可执行的，必须强制设定其文件权限。
-  valid users 设置为你当前的Linux用户名，例如我的是yanghao，因为第一次打开共享文件夹时，需要验证权限。

## 4. 设置登陆密码

```shell
// 创建/etc/samba/smbpasswd文件

$ sudo touch /etc/samba/smbpasswd

// 输入以下命令创建
// 根据 smb.conf 设置的valid users，设置用户密码

$ sudo smbpasswd -a yanghao

//输入两次密码后，会提示 Added user yanghao. 表示设置成功
// 若用户名非当前登录系统的用户名，可能会提示Failed
```

## 5. 在 win 上登陆

在 Ubuntu 上输入一下命令找到你的 ip 地址。

```shell
$ ifconfig -a
```

在 win 10 上 ，按 win + r 输入

```shell
$ //ip/
```

你就可以访问了。