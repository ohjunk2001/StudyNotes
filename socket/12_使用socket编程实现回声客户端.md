# 使用socket编程实现回声客户端

所谓“回声”，是指客户端向服务器发送一条数据，服务器再将数据原样返回给客户端，就像声音一样，遇到障碍物会被“反弹回来”。

对！客户端也可以使用 write() / send() 函数向服务器发送数据，服务器也可以使用 read() / recv() 函数接收数据。

以下在 Liunx 上例子

服务器端 server.c：

```c
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<unistd.h>
#include<arpa/inet.h>
#include<sys/socket.h>
#define BUF_SIZE 100

// server 创建了两个 socket 

int main(){
    int sock=socket(AF_INET,SOCK_STREAM,IPPROTO_TCP); // ipv4 流格式的套接字，TCP 协议
    
    struct sockaddr_in server_address;
    memset(&server_address,0,sizeof(server_address));// 用 0 填充。

    server_address.sin_family=AF_INET;
    server_address.sin_port=htons(1234);
    server_address.sin_addr.s_addr=inet_addr("127.0.0.1");

    bind(sock,(struct sockaddr*)&server_address,sizeof(server_address)); // 将套结字与特定的 ip 和 端口绑定。

    listen(sock,20); // 进入监听状态，等待用户发起请求监听状态， 20 是消息队列的数量。
    printf("准备接受客户端的请求！\n");

    struct sockaddr_in client_addr;
    socklen_t clnt_addr_size=sizeof(client_addr); // 这一步就是在求 client_addr 的长度。你也可以直接在参数中填 sizeof(clnt_addr)
    int client_socket=accept(sock,(struct sockaddr*)&client_addr,&clnt_addr_size);  // aceept 接受并返回一个新的 socket 即 client_socket。

    char buffer[BUF_SIZE];//定义缓冲区

    int strlen=read(client_socket,buffer,BUF_SIZE);
    // read() 若无错误发生，read()返回读入的字节数。如果连接已中止，返回 0。如果发生错误，返回 -1 。

    // 将客户端发送的数据返回
    write(client_socket,buffer,strlen);

    // 关闭套结字
    close(client_socket);
    close(sock);

    return 0;
}
```

客户端 client.c

```c
#include <stdio.h>
#include<string.h>
#include<stdlib.h>
#include<unistd.h>
#include<arpa/inet.h>
#include<sys/socket.h>
#define BUF_SIZE 100

// client 只创建了一个 socket

int main(){
    int sock=socket(AF_INET,SOCK_STREAM,0);

    struct sockaddr_in server_addr;
    memset(&server_addr,0,sizeof(server_addr));

    // 写入特定的 IP 和端口号。
    server_addr.sin_family=AF_INET;
    server_addr.sin_port=htons(1234);
    server_addr.sin_addr.s_addr=inet_addr("127.0.0.1");

    connect(sock,(struct sockaddr*)&server_addr,sizeof(server_addr)); // 与远程服务器建立连接。

    // 向服务器发送数据。
    char BufferSend[BUF_SIZE]={0};
    printf("Input a string:");
    scanf("%s",BufferSend);
    write(sock,BufferSend,strlen(BufferSend));

    // 接受服务器传回的数据。
    char BufferRecv[BUF_SIZE]={0};
    read(sock,BufferRecv,BUF_SIZE);

    // 输出接受的信息。
    printf("Receive message:%s\n",BufferRecv);

    // 关闭套结字。
    close(sock);
    return 0;
}
```

先运行服务器端，再运行客户端，执行结果为：

```
Input a string: yanghao
Receive message: yanghao
```

scanf() 读取到空格时认为一个字符串输入结束，所以只能读取到“c-language”；如果不希望把空格作为字符串的结束符，可以使用 gets() 函数。

通过本程序可以发现，客户端也可以向服务器端发送数据，这样服务器端就可以根据不同的请求作出不同的响应，http 服务器就是典型的例子，请求的网址不同，返回的页面也不同。