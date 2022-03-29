
Dictionary 是除 List 以外 Python 中最灵活的数据类型

- 储存多个无序的数据

- 使用 `{}` 进行定义

- 使用键值对存储数据，键值对之间使用 `,` 分隔

  - `key` 是索引
  - `value` 是数据
  - 键和值之间使用 `:` 分隔
  - 键必须唯一，值可以取任何数据类型

  ```python
  people={"name":"小明",
  "age":18,
  "height":1.75}
  ```

## Dictionary 和 list 的搭配使用

List 中的元素都是不同的 Dictionary

多个  Dictionary 放进一个 List 中，在循环体内部对每个字典进行相同的处理

