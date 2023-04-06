
git 可以使用四种主要的协议来传输资料: 本地协议（ Local ），HTTP 协议，SSH（Secure Shell）协议及 git 协议。其中，本地协议由于目前大都是进行远程开发和共享代码所以一般不常用，而git协议由于缺乏授权机制且较难架设所以也不常用。

最常用的便是 SSH 和 HTTP(S)协议。git 关联远程仓库可以使用 http 协议或者 ssh 协议。

## 特点

ssh：

- 一般使用22端口；
- 通过先在本地生成SSH密钥对再把公钥上传到服务器；
- 速度相较慢点

https：

- 一般使用443端口；
- 通过用户名/密码授权，可用性比较高；
- 速度相较快点

一般企业防火墙会打开80和443这两个http/https协议的端口，因此在架设了企业防火墙的时候使用http就可以很好的绕开安全限制使用git了，很方便；而对于ssh来说，企业防火墙很可能没打开22端口。

 

## 【使用区别】

clone项目：

- 使用ssh方式时，需要配置ssh key，即要将生成的SSH密钥对的公钥上传至服务器；
- 使用http方式时，没有要求，可以直接克隆下来。

push项目：

- 使用ssh方式时，不需要验证用户名和密码，之前配置过ssh key，(如果你没设置密码)直接push即可；
- 使用http方式时，需要验证用户名和密码。

总结：

- HTTPS 利于匿名访问，适合开源项目，可以方便被别人克隆和读取(但没有 push 权限)；
- SSH 不利于匿名访问，比较适合内部项目，只要配置了 SSH 公钥极可自由实现 clone 和 push 操作。

## 生成秘钥

```
ssh-keygen -t rsa -C "winkcial@gmail.com"
```
之后连续按三次回车就行了

~~~
yanghao@yanghao-X550VC:~/桌面$ ssh-keygen -t rsa -C ”yanghao.tianjin.mail@gmail.com”
Generating public/private rsa key pair.
Enter file in which to save the key (/home/yanghao/.ssh/id_rsa): 
Created directory '/home/yanghao/.ssh'.
Enter passphrase (empty for no passphrase): 
Enter same passphrase again: 
Your identification has been saved in /home/yanghao/.ssh/id_rsa
Your public key has been saved in /home/yanghao/.ssh/id_rsa.pub
The key fingerprint is:
SHA256:ZYCOtXnDHLMF23OqyDNAa5tzFmPTd8wc7IWl63i/Oss ”yanghao.tianjin.l@gmail.com”
The key's randomart image is:
+---[RSA 3072]----+
|       .o.    .  |
|      o o+.. +   |
|    .+ =.== * .  |
|   ...+.*o O +   |
|    + =.S.o B    |
|   . * = o +     |
|    + B . . o    |
|     + o   o..   |
|            E+o. |
+----[SHA256]-----+
yanghao@yanghao-X550VC:~/桌面$ 
~~~

## 查看秘钥

输入以下命令查看秘钥

```
sudo vim /home/yanghao/.ssh/id_rsa.pub
```
## 在 github 上添加秘钥

登录账户，打开设置找到这个选项

![no.1](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/github/images_20220329132048.svg)

## 验证

在终端输入以下命令

```
ssh -T git@github.com
```

中间时候 询问你yes/no,输入yes。

```
The authenticity of host ‘github.com (52.74.223.119)’ can’t be established.
RSA key fingerprint is SHA256:nThbg6kXUpJWGl7E1IGOCspRomTxdCARLviKw6E5SY8.
Are you sure you want to continue connecting (yes/no)? yes
之后，显示如下：
Warning: Permanently added ‘github.com,52.74.223.119’ (RSA) to the list of known hosts.
Hi linuxidc! You’ve successfully authenticated, but GitHub does not provide shell access.
```

这样就显示你连接成功了。 