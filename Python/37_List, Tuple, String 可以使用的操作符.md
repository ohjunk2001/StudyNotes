# List， Tuple, String, Dictionary 可以使用的操作符

|操作符|表达式|结果|描述|支持的数据类型|
|---|---|--|--|-------|
|+|[1,2]+[3,4]|[1,2,3,4]|合并|String, List,Tuple|
|*|["1"]*3|["1","1","1"]|重复|String, List, Tuple|
|in| 3 in (1,2,3)|true|元素是否存在|String, List, Tuple,Dictionary|
|not in|3 not in (1,2,3)|false|元素是否不存在|Dictionary, List,String,Tuple|
|>= =< > <  ==|(1,2,3)<(2,2,2)|True|元素比较|String, List, Tuple|

> not in in 成为成员运算符
> in 在字典时判断的是元素的键
