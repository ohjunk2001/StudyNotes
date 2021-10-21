# Redis 使用（Ubuntu）

Redis 是 Nosql 数据库，不是传统的数据库。

官网 http://www.redis.cn/

Redis:Remote Dictionary Server （远程字典服务器）Redis 性能非常高，单机能够达到 15w qbs ，通常适合做缓存，也可以持久化。

完全免费开源

## 安装 Redis 

参考文章

## 启动数据库

```shell
$ redis-server # 启动服务器
$ redis-cli # 启动客户端
```



Redis 会默认创建 16 个数据库。数据库编号从 0 开始。

```shell
set key值 value值 # 插入一个键值对
get key值 # 获取 value值
select 1 # 选择编号 为 1 的数据库。
dasize # 查看当前数据库的大小
exit # 退出数据库客户端
```



## Redis 支持的五大数据类型

String 、Hash 、List（有点像栈加队列的结构） 、Set 、zset（有序集合）

## Redis 的 Crud 操作

Crud （增删改查）

### String 

- string 是 redis 最基本的类型，key-value；

- string 类型是二进制安全的，除普通的字符串外，还可以存放图片；

- redis 中字符串 value 值的最大值是 512m。

**crud**

```shell
set # 如果存在就是修改，不存在就是添加
get key值 # 查询 
del key值 # 删除

set key_1 value
expire key seconds # 设置生存时间，超出这个时间，key_1 就会消失。
mset key value # 一次性多个键值对，如果某个 key 存在 value 值会被覆盖

var(
name="tom"
)
```

### **Hash**

Redis hash 是一个键值对的集合。String 类型的 filed 和 value 的映射表 hash 特别社和用于存储对象。

```shell
$ hset key filed value
$ hget key filed value
$ hgetall
$ hmset
$ hmget
```

### List

Redis List 的本质是一个链表，List 的元素有序可以重复。

```shell
$ lpush key value1 value2 # 从左边插入元素
$ lrange start stop # 返回列表中指定区间的元素
$ rpush key value1 vlaue2 # 从右边插入元素
```

### Set

Redis 的 Set 是 string 类型的无序集合。

底层是 Hash Table 数据结构
