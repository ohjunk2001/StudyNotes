# 处理 Dictionary

| 函数| 功能|
|---|---|
|len(Dictionary)| 获取 Dictionary 的长度|
|Dictionary.keys()|获取字典中所有 key 列表|
|Dictionary.values()|获取字典中所有 value 列表|
|Dictionary.items()|获取字典中所有 (key,value) 列表|
|Diction.pop(key)|删除 key 这个键值对 |
|Dictionary.clear()|清空字典中所有的键值对|

**获取和修改 key 值** 

```py
people={"name":"小明",
  "age":18,
  "height":1.75}
print(people["name"]) # 会获得 name 对应的 key 值
people["age"]=19 # 修改 "age" 对应的 key 值
```

**合并字典**

```py
temp_dict={"age":18,
"height":1.75}

people_dict={"name":yanghao,
"age:20"}

people_dict.update(temp_dict)

'''
temp_dict 和 people_dict 所有的键值对会合并

如果有相同的键值对且 key 值不同，最终的 key 值取决于 temp_dict 中的 key 值
'''
```