# 安装与初步设置
## 基本信息

## 查看mysql有没有已安装的依赖包卸载旧mysql

```shell
$ dpkg --list|grep mysql
$ sudo apt-get remove mysql-common // 先卸载mysql-common
$ sudo apt-get autoremove --purge mysql-server-5.0
# 然后继续用 dpkg --list|grep mysql 查看，还剩什么就卸载什么；
$ sudo apt-get update
```
## 安装MySQL:

```shell
$ sudo apt-get install mysql-server
$ mysql --version # 查看版本

#安装后，MySQL服务器应自动启动。要检查它是否正在运行，执行
$ systemctl status mysql.service`

# 如果由于某些原因MySQL服务器未运行，执行以下命令以启动MySQL服务器：
$ sudo systemctl start mysql
```
## 配置


为了提高MySQL安装的安全性，执行以下命令进行初始化

```shell
$ sudo mysql_secure_installation
```
在按Enter键之后，将出现的第一件事是VALIDATE PASSWORD插件提示窗口：此步骤
是为root用户设置安全密码，具体取决于选择的密码类型。

输入 Y并按Enter键。

输入密码强度数字，然后按Enter键：


完成所有设置后，以root用户登录MySQL。 在终端中，键入以下命令：

`mysql -u root -p`，输入 root用户的密码，然后按Enter 。 

会得到以下错误信息

默认情况下， root用户将使用auth_socket插件身份验证方法，而不是密码。

要设置root用户使用密码连接到MySQL实例，需要将身份验证方法从auth_socket更改为mysql_native_password方法。
首先，在MySQL用户前面使用sudo命令连接到MySQL实例：sudo mysql -u root -p
