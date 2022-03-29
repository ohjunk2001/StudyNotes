# Number

NUmber 数据类型包含以下几种 int, float, bool, complex

## 判断类型

判断一个元素的类型

```
a=1
isinstance(a,int) # 判断 a 是不是 int 类型，返回值 True 或 False 
type(a)
```

isinstance() 与 type() 区别：

- type() 不会认为子类是一种父类类型，不考虑继承关系。
- isinstance() 会认为子类是一种父类类型，考虑继承关系。

```python
class A:
    pass
 
class B(A):
    pass
 
isinstance(A(), A)    # returns True
type(A()) == A        # returns True
isinstance(B(), A)    # returns True
type(B()) == A        # returns False
```

