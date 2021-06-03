# cp命令

cp 命令用于复制文件

```
cp ~/home/re.txt ./temp.txt
```

把 目录 ~/home 下的文件 re.txt 复制到当前文件夹中 复制后的文件名为 temp.txt

## 参数

-i 文件覆盖时会给出提示

-r 递归复制文件夹下所有的子目录和文件
-v 参数就可以显示拷贝的一个个文件进度了。

sudo cp -r -v aaa/* bbb/
