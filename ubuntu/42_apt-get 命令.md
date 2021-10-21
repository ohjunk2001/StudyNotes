# apt-get 命令

https://www.cnblogs.com/cyl2008/p/6417443.html

apt-get，是一条linux命令，适用于deb包管理式的操作系统（例如Ubuntu系统），主要用于自动从互联网的软件仓库中搜索、安装、升级、卸载软件或操作系统。

**安装与卸载**

```shell
$ apt-get install PackageName # 安装

$ apt-get remove PackageName # 卸载

$ apt-get purge PackageName # 清除相关配置

$ apt-get update  # 更新源文件，并不会做任何安装升级操作

$ apt-get upgrade	# 升级所有已安装的包

$ apt-mark hold PackageName # 升级时忽略某个安装包

$ apt-mark unhold PackageName # 解除忽略

$ apt-get install PackageName --only-upgrade	# 仅升级指定的包

$ apt-get install PackageName --reinstall # 重新安装包

$ apt-get -f install   # 如果遇到依赖问题，可以用此命令尝试修复安装

$ apt-get build-dep PackageName	# 安装相关的编译环境

$ apt-get source PackageName   # 下载该包的源代码

$ apt-get dist-upgrade # 升级系统

$ apt-get dselect-upgrade # 使用 dselect 升级

```

**查询**

```shell
$ apt-cache show packagename 	# 显示包的相关信息，如说明、大小、版本等 

$ apt-cache madison PackageName # 显示可以安装的版本，显示的信息比上面那条命令少很多

$ apt-cache depends PackageName  # 了解使用该包依赖哪些包

$ apt-cache rdepends PackageName # 查看该包被哪些包依赖

```

## dpkg 与 apt-get 的区别

