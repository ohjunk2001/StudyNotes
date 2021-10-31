# Redis 链接池

- 事先初始化一定数量的链接，放入链接池中
- 当 Go 需要操作 Redis 时，直接从 Redis 链接池中取出就行
- 这样可以节省临时获取 Redis 链接的时间

**第一个案例**

```go
package main

import (
	"fmt"

	"github.com/gomodule/redigo/redis"
)

func main() {
	fmt.Println("hello")
	var pool *redis.Pool
	pool = &redis.Pool{
		MaxIdle:     8,   // 最大空闲连接数
		MaxActive:   0,   // 表示和数据库的最大连接数, 0表示没有限制
		IdleTimeout: 100, // 最大空闲时间
		Dial: func() (redis.Conn, error) { // 链接哪一个 ip 的 redis
			return redis.Dial("tcp", "localhost:6379")
		},
	}
	c = pool.Get()
	pool.Close() // 关闭链接池

}
```



我们可以去查看源码 pool.go

**第二个案例**

```go
package main

import (
	"fmt"

	"github.com/gomodule/redigo/redis"
)

var pool *redis.Pool

func init() {
	pool = &redis.Pool{
		MaxIdle:     8,
		MaxActive:   0,
		IdleTimeout: 100,
		Dial: func() (redis.Conn, error) {
			return redis.Dial("tcp", "localhost:6379")
		},
	}
}

func main() {
	// 从 pool 中取出一个链接
	conn := pool.Get()
	defer conn.Close()
	_, err := conn.Do("Set", "name", "汤姆猫")
	if err != nil {
		fmt.Println("conn.Do error=", err)
	}

	// 取出
	r, err := redis.String(conn.Do("Get", "name"))
	if err != nil {
		fmt.Println("conn.Do() error=", err)
	}
	fmt.Println("r=", r)
}
```

