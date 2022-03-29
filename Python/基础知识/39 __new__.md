
`__new__` 方法是一个由 `Object` 类提供的内置静态方法，主要作用：

- 在内存中为对象分配空间
- 返回对象的引用

Python 的解释器获取对象的引用，将引用作为第一个参数传递给 `__init__` 方法

## 重写 `__new__` 方法

重写 `__new__` 方法的模式非常固定

- 重写 `__new__` 方法一定要 `return super().__new__(cls)`
- 否则 Python 的解释器得不到分配了空间的对象引用，就不会调用对象的初始化方法
- 注意：`__new__` 是一个静态方法，在调用时需要主动传递参数 `cls`


## 实例分析

运行以下代码，分析结果

```py
class MusicPlayer(object):

    def __new__(cls,*arg,**kwargs):
        # 1.创建对象时 __new__ 方法会被自动调用
        print("调用 __new__ method")
        
        # 2. 为对象分配空间
        instance=super().__new__(cls)

        # 3.返回对象的引用
        return instance

    def __init__(self,*args,**kwargs): 
        # 一个星号代表多值元组参数，两个星号代表多值字典参数
        print("初始化")

# 创建播放器对象

player=MusicPlayer()

print(player)
```