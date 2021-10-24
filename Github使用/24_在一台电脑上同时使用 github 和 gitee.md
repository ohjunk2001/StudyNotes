# 在一台电脑上同时使用 github 和 gitee

https://blog.csdn.net/qq_43199318/article/details/103469792

```
Host gitee_yanghao9527
  HostName gitee.com
  User yanghao9527
  IdentityFile /home/yanghao/.ssh/gitee_id_rsa
```

验证

```
ssh -T git@gitee.com
```

这样做添加一个 gitee 账户应该是没有问题的

