# Buffer 缓冲区

- Buffer 的结构与数组类似，操作方法也与数组类似
- 数组不能存储二进制文件，Buffer 是专门存储二进制数据的
- Buffer 存储的是二进制数据，显示时以 16 进制的形式显示
- Buffer 每一个元素范围是 00~ff，即 0~255、00000000~11111111
- 每一个元素占用一个字节内存
- Buffer 是对底层内存的直接操作，因此大小一旦确定就不能修改

Buffer 常用方法：

- `Buffer.from(str[, encoding])`：将一个字符串转换为 Buffer
- `Buffer.alloc(size)`：创建指定大小的 Buffer
- `Buffer.alloUnsafe(size)`：创建指定大小的 Buffer，可能包含敏感数据（分配内存时不会清除内存残留的数据）
- `buf.toString()`：将 Buffer 数据转为字符串

```js
var str = 'Hello前端'
var buf = Buffer.from(str)

// 占用内存的大小，一个汉字3字节 13
console.log(buf.length)
// 字符串的长度 7
console.log(str.length)
// 8进制输出第一个元素 145
console.log(buf[1].toString(8))

//创建一个10个字节的buffer
var buf2 = Buffer.alloc(10)
//通过索引，来操作buf中的元素
buf2[0] = 88
buf2[1] = 255
buf2[2] = 0xaa
buf2[3] = 255

var buf3 = Buffer.allocUnsafe(10)
console.log(buf3)
```

#  fs 文件系统模块

- fs 模块中所有的操作都有两种形式可供选择:同步和异步
- 同步文件系统会阻塞程序的执行，也就是除非操作完毕，否则不会向下执行代码
- 异步文件系统不会阻塞程序的执行，而是在操作完成时，通过回调函数将结果返回
- 实际开发很少用同步方式，因此只介绍异步方式

打开模式：

| 模式 | 说明                                     |
| ---- | ---------------------------------------- |
| r    | 读取文件，文件不存在抛异常               |
| r+   | 读写文件，文件不存在抛异常               |
| rs   | 同步模式下打开文件用于读取               |
| rs+  | 同步模式下打开文件用于读写               |
| w    | 写文件，不存在则创建，存在则覆盖原有内容 |
| wx   | 写文件，文件存在打开失败                 |
| w+   | 读写文件，不存在创建，存在截断           |
| wx+  | 读写，存在打开失败                       |
| a    | 追加，不存在创建                         |
| ax   | 追加，存在失败                           |
| a+   | 追加和读取，不存在创建                   |
| ax+  | 追加和读取，存在失败                     |

## 读取文件

### 简单文件读取

语法格式：

```js
fs.readFile(path[, options], callback)
```
- `path`：文件路径
- options
  ：配置选项，若是字符串则指定编码格式
  - `encoding`：编码格式
  - `flag`：打开方式
- 
  callback
  ：回调函数
  - `err`：错误信息
  - `data`：读取的数据，如果未指定编码格式则返回一个 Buffer

```js
const fs = require('fs') // 导入模块

fs.readFile('./files/1.txt', 'utf-8', function(err, data){
  if(err) {
    return console.log('failed!' + err.message)
  }
  console.log('content:' + data)
})


// 复制文件内容
fs.readFile("C:/Users/笔记.mp3", function(err, data) {
	if(!err) {
		console.log(data);
		// 将data写入到文件中
		fs.writeFile("C:/Users/hello.jpg", data, function(err){
			if(!err){
				console.log("文件写入成功");
			}
		} );
	}
});
```

### 流式文件读取

- 简单文件读取的方式会一次性读取文件内容到内存中，若文件较大，会占用过多内存影响系统性能，且读取速度慢
- 大文件适合用流式文件读取，它会分多次将文件读取到内存中

```js
var fs = require('fs')

// 创建一个可读流
var rs = fs.createReadStream('C:/Users/笔记.mp3')
// 创建一个可写流
var ws = fs.createWriteStream('a.mp3')

// 监听流的开启和关闭
// 这几个监听不是必须的
rs.once('open', function () {
  console.log('可读流打开了~~')
})

rs.once('close', function () {
  console.log('可读流关闭了~~')
  //数据读取完毕，关闭可写流
  ws.end()
})

ws.once('open', function () {
  console.log('可写流打开了~~')
})

ws.once('close', function () {
  console.log('可写流关闭了~~')
})

//要读取一个可读流中的数据，要为可读流绑定一个data事件，data事件绑定完毕自动开始读取数据
rs.on('data', function (data) {
  console.log(data)
  //将读取到的数据写入到可写流中
  ws.write(data)
})
```

简便读取

```js
var fs = require('fs')

var rs = fs.createReadStream('C:/Users/lilichao/Desktop/笔记.mp3')
var ws = fs.createWriteStream('b.mp3')

// pipe()可以将可读流中的内容，直接输出到可写流中
rs.pipe(ws)
```

# 路径动态拼接问题 `__dirname`

- 在使用 fs 模块操作文件时，如果提供的操作路径是以 `./` 或 `../` 开头的相对路径时，容易出现路径动态拼接错误的问题
- 原因：代码在运行的时候，会以执行 node 命令时所处的目录，动态拼接出被操作文件的完整路径
- 解决方案：在使用 fs 模块操作文件时，直接提供完整的路径，从而防止路径动态拼接的问题
- `__dirname` 获取文件所处的绝对路径

```js
fs.readFile(__dirname + '/files/1.txt', 'utf8', function(err, data) {
  ...
})
```

## 其它操作

验证路径是否存在：

- `fs.exists(path, callback)`
- `fs.existsSync(path)`

获取文件信息：

- `fs.stat(path, callback)`
- `fs.stat(path)`

删除文件：

- `fs.unlink(path, callback)`
- `fs.unlinkSync(path)`

列出文件：

- `fs.readdir(path[,options], callback)`
- `fs.readdirSync(path[, options])`

截断文件：

- `fs.truncate(path, len, callback)`
- `fs.truncateSync(path, len)`

建立目录：

- `fs.mkdir(path[, mode], callback)`
- `fs.mkdirSync(path[, mode])`

删除目录：

- `fs.rmdir(path, callback)`
- `fs.rmdirSync(path)`

重命名文件和目录：

- `fs.rename(oldPath, newPath, callback)`
- `fs.renameSync(oldPath, newPath)`

监视文件更改：

- `fs.watchFile(filename[, options], listener)`

# Path 模块

path 模块是 Node.js 官方提供的、用来处理路径的模块。它提供了一系列的方法和属性，用来满足用户对路径的处理需求。

## 路径拼接 `path.join()`

```js
const path = require('path')
const fs = require('fs')

// 注意 ../ 会抵消前面的路径
// ./ 会被忽略
const pathStr = path.join('/a', '/b/c', '../../', './d', 'e')
console.log(pathStr) // \a\d\e

fs.readFile(path.join(__dirname, './1.txt'), 'utf8', function (err, dataStr) {
  if (err) {
    return console.log(err.message)
  }
  console.log(dataStr)
})
```

## 获取路径中文件名 `path.basename()`

使用 `path.basename()` 方法，可以获取路径中的文件名

```js
path.basename(path[, ext])
```

- path: 文件路径
- ext: 文件扩展名

```js
const path = require('path')

// 定义文件的存放路径
const fpath = '/a/b/c/index.html'

const fullName = path.basename(fpath)
console.log(fullName) // index.html 包含扩展名

const nameWithoutExt = path.basename(fpath, '.html')
console.log(nameWithoutExt) // index 不包含扩展名
```

## 获取路径中文件扩展名 `path.extname()`

```js
const path = require('path')

const fpath = '/a/b/c/index.html'

const fext = path.extname(fpath)
console.log(fext) // .html
```

# Http 模块

http 模块是 Node.js 官方提供的、用来创建 web 服务器的模块。

## 创建一个简单 web 服务器

```js
const http = require('http')

// 创建 web 服务器实例
const server = http.createServer()

// 为服务器实例绑定 request 事件，监听客户端的请求
server.on('request', function (req, res) {
  // req 是请求对象，包含了 客户端相关的数据和方法
  const url = req.url  // 客户端请求的 url 地址
  const method = req.method // 客户端的请求类型 Get
  const str = `Your request url is ${url}, and request method is ${method}`
  console.log(str)

  // 设置 Content-Type 响应头，解决中文乱码的问题
  res.setHeader('Content-Type', 'text/html; charset=utf-8')
  // 向客户端响应内容
  res.end(str)
})

server.listen(8080, function () {
  console.log('server running at http://127.0.0.1:8080')
})
```