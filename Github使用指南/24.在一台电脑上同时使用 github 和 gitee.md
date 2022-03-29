
在 .ssh 文件夹中的的 config 文件添加相关配置。

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

