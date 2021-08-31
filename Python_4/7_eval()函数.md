# eval() 函数

eval() 函数非常强大

将字符串当成有效的表达式来求值并返回计算结果

```py
In [1]: eval("1+1")                                                             
Out[1]: 2

In [2]: eval("'*'*20")                                                          
Out[2]: '********************'

In [3]: type("[1,2,3,4,5,6]")                                                   
Out[3]: str

In [4: type(eval("{'name':'yanghao','age':18}"))                               
Out[8]: dict


```