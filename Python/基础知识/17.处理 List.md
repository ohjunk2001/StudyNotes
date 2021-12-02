# 处理列表

## 基本操作

```python
fruit=['apple','watermelon','banana','pear','pitaya']
print (fruit)          # 输出字符串  
print (fruit[0:-1])    # 输出第一个到倒数第二个的所有元素
print (str[1:3])     # 输出从第二个开始到第四个的所有元素
print (str[2:])      # 输出从第三个开始的后的所有元素

fruit=['apple']
fruit=fruit*3 # 列表重复三次
print(fruit)
-> ['apple', 'apple', 'apple']

fruit_1=['apple']
fruit_2=['watermelon']
fruit=fruit_1+fruit_2 # 拼接列表
print(fruit)
-> ['apple', 'watermelon']

```

**对列表中值排序**

`sort()` 可以对列表中的元素排序,按数字大小和字母表顺序

```
number.sort()
```

`sort(reverse=ture)` 降序排序

`sorted()` 可以对列表进行一次临时排序

**倒置列表**

`reverse()` 可以将列表倒置

```
number.reverse()
```

**确定列表长度**

`len()` 可以返回列表长度

```
len(number)
```

**获得索引**

`列表.index(数据)` 获得数据第一次出现的索引

**合并列表**

`列表.extend(列表2)` 将列表 2 追加到列表 1

**统计数据出现次数**

`列表.count(数据)` 统计数据在列表中出现的次数

> 带 `.` 基本上是方法 其他的是函数

