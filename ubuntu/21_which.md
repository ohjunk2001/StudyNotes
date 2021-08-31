# which

- /etc/passwd 是用于保存用户信息的文件
- /usr/bin/passwd 是用于修改用户密码程序

`which` 用于查看执行命令所处的位置

Case

```
yanghao@yanghao-X550VC:~/桌面$ which ls
/usr/bin/ls
yanghao@yanghao-X550VC:~/桌面$ which git
/usr/bin/git
yanghao@yanghao-X550VC:~/桌面$ which tar
/usr/bin/tar
```

## bin 和 sbin

- 在 liunx 中，绝大多数可执行文件都是保存在 /bin /sbin /usr/bin
- /bin 是可执行二进制文件，主要用于具体应用
- /sbin 是系统管理员专用的二进制代码存放目录，主要用于系统管理
- user/bin 后期安装的软件
- /user/bin 超级用户的一些管理程序

>Tip:`cp` 这个终端命令是内置到系统内核中的，没有独立文件，因此无法用`which`找到
