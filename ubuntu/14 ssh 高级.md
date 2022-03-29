# ssh 高级

- 免密登录
- 配置别名

## 免密登录

步骤

1.配置公钥

执行`ssh-keygen`会得到公钥和私钥

2.上传公钥到远程主机

执行`ssh-copy-id -p port user@remote 让远程主机记住我们的公钥

![no.1](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/Ubuntu/images_20220328132440.svg)

非对称加密算法
- 使用公钥加密的数据，需要私钥解密，远程到本地
- 使用私钥加密的数据，需要公钥解密，本地到远程

## 配置别名

ssh -p port user@remote

将 `-p port user@remote` 这一长串的东西起个别名

在 `~/.ssh/config`中追加以下内容

```
Host mac
  HostName IP address
  Usr RemoteHostName
  Port 22
```