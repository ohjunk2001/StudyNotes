# Golang 链接 Redis 

Golang 操作 Redis 需要首先下载第三方开源库，提供 API 操作 Redis。

[API 官方文档](https://pkg.go.dev/github.com/gomodule/redigo/redis)

[FAQ](https://github.com/gomodule/redigo/wiki/FAQ)

在 GOPATH 目录下，执行一下命令

```shell
$ go get github.com/gomodule/redigo/redis # 需要 git ，这个地址是新迁移的地址
# 下载完成，你会在 目录 /home/ubuntu/DevWorkspace/GoDev/go/pkg/mod/github.com/gomodule 下看到 redigo
```

案例 Set

```go
package main

import (
	"fmt"

	"github.com/gomodule/redigo/redis"
)

func main() {
	connect, err := redis.Dial("tcp", "127.0.0.1:6379") // 连接数据库
	if err != nil {
		fmt.Println("redis.Dial err= ", err)
		return
	}
	defer connect.Close()
	fmt.Println("connect=", connect)

	// 通过 go 向数据库写入数据
	_, err = connect.Do("Set", "name", "tomjerry 猫猫")
	if err != nil {
		fmt.Println("set err=", err)
		return
	}

	// 通过 go 读取数据
	r, err := redis.String(connect.Do("Get", "name"))
	if err != nil {
		fmt.Println("读取失败")
		return
	}
	// 因为返回 r 是 interface{}
	// name 对应的值是 string ,我们需要转换
	//nameString := r.(string) 类型断言转换不好
	// 直接使用 Redis 提供的 redis.String() 方法

	fmt.Println("操作成功 ", r)
}

```

案例 操作 Hash

一

```go

func main() {
	connect, err := redis.Dial("tcp", "127.0.0.1:6379")
	if err != nil {
		fmt.Println("err=", err)
		return
	}
	_, err = connect.Do("HSET", "user01", "name", "yanghao")
	if err != nil {
		fmt.Println("err=", err)
		return
	}
	r, err := redis.String(connect.Do("HGet", "user01", "name"))
	if err != nil {
		fmt.Println("get err=", err)
	}

	fmt.Println("name=", r)

}
```

二

```go
func main() {
	connect, err := redis.Dial("tcp", "127.0.0.1:6379")
	if err != nil {
		fmt.Println("err=", err)
		return
	}
	defer connect.Close()

	_, err = connect.Do("HMSET", "user01", "name", "yanghao", "age", "19")
	if err != nil {
		fmt.Println("err=", err)
		return
	}
    r, err := redis.Strings(connect.Do("HMGet", "user01", "name", "age")) // 这里使用的是 Strings() 返回值是一个 []string
	if err != nil {
		fmt.Println("get err=", err)
	}

	fmt.Printf("r=%v\n", r)
	for i, v := range r {
		fmt.Printf("r[%d]=%s\n", i, v)
	}

}
```

