# 列表

- 列表是一系列有次序的元素集合，Python 中用 `[]` 表示列表，用 `,` 分隔元素；

- 列表的索引从 0 开始；

- 元素类型相同；

- 在 Python 中 列表和字符串密不可分；

  

```python
number=['1','2','3','4']
print(number)
->
['1', '2', '3', '4'] #  [] 和 , 会输出出来
```

你会发现会保留 `[]` 和 `,`

## 基本操作（一维 List）

> 基本操作就是增删改查

### 查和改

```
print(number[2]) # 获取这个
number[2]='10' # 直接改
->
3
```

### 增

`append()` 会添加一个元素到列表的末尾

```
number.append('5')
print(number)
->
['1', '2', '3', '4', '5']
```

`insert()` 会插入一个元素到列表的指定位置中

```
number.insert(3,'23')
# 3 是索引，‘23’ 是新添加的元素
```

### 删

`del` 用于删除列表中指定位置的元素

```python
del number[3] # 3 是索引
```

`pop()` 删除末尾元素同时还能够使用它的值

```
a=number.pop()# pop() 方法将 number 末尾元素删除，同时将值赋给变量 1
```

你也可以 pop 任意一个位置的元素

```
a=number.pop(2)# 2 是索引
```

`remove()` 有时我们想要删除一个元素，我们只知道它的值不知道它的索引位置。这时就可以使用 `remove()`

```
number=['1','2','2']number.remove('2')# 删除第一个值为 '2' 的列表元素
```

## 列表的索引

一维列表的索引有两套

## 二维列表

```python
for i in range(8): # 声明一个 8x16 的矩阵
    Table.append([])
    for j in range(16):
        Table[i].append('0')
```

### 基本操作

```python
Table[0][0]='yanghao' # 把第一列第一行的元素改成 'yanghao'
```

