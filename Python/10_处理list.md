# 处理列表

## 基本操作

```
str = 'Runoob'

print (str)          # 输出字符串
print (str[0:-1])    # 输出第一个到倒数第二个的所有字符
print (str[0])       # 输出字符串第一个字符
print (str[2:5])     # 输出从第三个开始到第五个的字符
print (str[2:])      # 输出从第三个开始的后的所有字符
print (str * 2)      # 输出字符串两次，也可以写成 print (2 * str)
print (str + "TEST") # 连接字符串
```

## 对列表中值排序

`sort()` 可以对列表中的元素排序,按数字大小和字母表顺序

```
number.sort()
```

`sorted()` 可以对列表进行一次临时排序

## 倒置列表

`reverse()` 可以将列表倒置

```
number.reverse()
```

## 确定列表长度

`len()` 可以返回列表长度

```
len(number)
```