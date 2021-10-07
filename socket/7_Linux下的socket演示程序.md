# Linux下的socket演示程序

本节演示了 Linux 下的代码，server.cpp 是服务器端代码，client.cpp 是客户端代码，要实现的功能是：客户端从服务器读取一个字符串并打印出来。

server.cpp 

```c
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<unistd.h>
#include<arpa/inet.h>
#include<sys/socket.h>

int main(){
    int sock=socket(AF_INET,SOCK_STREAM,IPPROTO_TCP); // ipv4 流格式的套接字，TCP 协议
    
    struct sockaddr_in server_address;
    memset(&server_address,0,sizeof(server_address));// 用 0 填充。

    server_address.sin_family=AF_INET;
    server_address.sin_port=htons(1234);
    server_address.sin_addr.s_addr=inet_addr("127.0.0.1");

    bind(sock,(struct sockaddr*)&server_address,sizeof(server_address)); // 将套结字与特定的 ip 和 端口绑定。

    listen(sock,20); // 进入监听状态，等待用户发起请求监听状态， 20 是消息队列的数量。

    struct sockaddr_in client_addr;
    socklen_t clnt_addr_size=sizeof(client_addr); // 这一步就是在求 client_addr 的长度。你也可以直接在参数中填 sizeof(clnt_addr)
    int client_socket=accept(sock,(struct sockaddr*)&client_addr,&clnt_addr_size);  // aceept 接受并返回一个新的 socket。

    // 向客户端写数据。
    char str[]="hello!";
    write(client_socket,str,sizeof(str));

    // 关闭套结字
    close(client_socket);
    close(sock);

    return 0;
}
```

client.cpp

```c
#include <stdio.h>
#include<string.h>
#include<stdlib.h>
#include<unistd.h>
#include<arpa/inet.h>
#include<sys/socket.h>

int main(){
    int sock=socket(AF_INET,SOCK_STREAM,0);

    struct sockaddr_in server_addr;
    memset(&server_addr,0,sizeof(server_addr));

    // 写入特定的 IP 和端口号。
    server_addr.sin_family=AF_INET;
    server_addr.sin_port=htons(1234);
    server_addr.sin_addr.s_addr=inet_addr("127.0.0.1");

    connect(sock,(struct sockaddr*)&server_addr,sizeof(server_addr));

    char buffer[40];

    read(sock,buffer,sizeof(buffer)-1);

    printf("Message from server::%s\n",buffer);
    close(sock);
    return 0;
}
```

动一个终端（Shell），先编译 server.cpp 并运行：

```
[admin@localhost ~]$ g++ server.cpp -o server
[admin@localhost ~]$ ./server
#等待请求的到来
```
正常情况下，程序运行到 accept() 函数就会被阻塞，等待客户端发起请求。

接下再启动一个终端，编译 client.cpp 并运行：

```c
[admin@localhost ~]$ g++ client.cpp -o client
[admin@localhost ~]$ ./client
Message form server: http://c.biancheng.net/socket/
```

client 接收到从 server发送过来的字符串就运行结束了，同时，server 完成发送字符串的任务也运行结束了。大家可以通过两个打开的终端来观察。

client 运行后，通过 connect() 函数向 server 发起请求，处于监听状态的 server 被激活，执行 accept() 函数，接受客户端的请求，然后执行 write() 函数向 client 传回数据。client 接收到传回的数据后，connect() 就运行结束了，然后使用 read() 将数据读取出来。

> server 只接受一次 client 请求，当 server 向 client 传回数据后，程序就运行结束了。如果想再次接收到服务器的数据，必须再次运行 server，所以这是一个非常简陋的 socket 程序，不能够一直接受客户端的请求。
