
在 Python 中用单引号或者双引号括起来的东西是字符串

1.可以使用索引获取字符串指定位置的字符，索引从 0 开始

2.使用索引加 `:` 获取部分字符串

`变量[头下标:尾下标]`

```py
list='asdfgh'
print(list[0:2])
```

输出结果

```
asd
```

处理字符串

1. title()

```
name="abc low"
print(name.title())
```

输出结果

```
Abc Low
```

2. upper()、lower()

```
name="abc low"
print(name.title())
print(name.upper())
print(name.lower())
```

输出结果

```
Abc Low
ABC LOW
abc low
```

### 链接字符串

使用加号链接

```
a="1"
b="2"
c=a+" "b
```

那么 c='12'

### 制表符和换行符

制表符：`\t`

换行符：`\n`

### 删除空白

使用 `rstrip()` 可以删除字符串中多余的空白

这种删除是暂时的，要想永久删除必须将操作结果保存到原变量中

`lstrip()` 删除字符串开头的空白

### str()

`str()` 将数字转换成字符串