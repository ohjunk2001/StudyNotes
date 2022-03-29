
想要再一台电脑上使用多个 github 账号，就需要取消全局配置。

```shell
$ git config --global --unset user.name
$ git config --global --unset user.email
```



生成各个账号对应的 ssh key，比如我现在要在电脑上再添加一个 github 账号（用户名 yanghao9527 邮箱 tool2020@qq.com）

```shell
$ ssh-keygen -t rsa -C "tool2020@qq.com" 
```



将 ssh key 的公钥添加到 github 账户上。

在 ~/.ssh 下创建文件 config

```shell
$ touch config
```



验证

```shell
$ ssh -T git@hd2098101
$ ssh -T git@yanghao9527
->You've successfully authenticated, but GitHub does not provide shell access. 
```



在每个仓库配置账户信息

```
  git config user.email "you@example.com"
  git config user.name "Your Name"
```

