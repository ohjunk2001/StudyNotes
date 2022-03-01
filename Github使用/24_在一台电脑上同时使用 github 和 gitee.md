# 在一台电脑上同时使用 github 和 gitee

https://blog.csdn.net/qq_43199318/article/details/103469792

```
Host github_hd2098101
  HostName github.com
  User hd2098101
  IdentityFile /home/sunny/.ssh/id_rsa

Host gitee_hd2098101
  HostName gitee.com
  User hd2098101
  IdentityFile /home/sunny/.ssh/gitee_id_rsa
```

验证

```
ssh -T git@gitee.com
```

这样做添加一个 gitee 账户应该是没有问题的

