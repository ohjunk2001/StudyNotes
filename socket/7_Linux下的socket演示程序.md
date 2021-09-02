# Linux下的socket演示程序

本节演示了 Linux 下的代码，server.cpp 是服务器端代码，client.cpp 是客户端代码，要实现的功能是：客户端从服务器读取一个字符串并打印出来。

server.cpp 

```c
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>

int main(){
    // 创建 socket
    /*
    1) AF_INET 表示使用 IPV4 地址
    2) SOCK_STREAM 表示使用流格式的套接字
    3) IPPROTO_TCP 表示使用 TCP 协议
    */
    int socket=socket(AF_INET,SOCK_STREAM,IPPROTO_TCP);

    // 将套接字和IP，端口绑定
    struct sockaddr_in serv_addr;
    // 每一个字节都用 o 来填充
    memset(&serv_addr,0,sizeof (serv_addr));
    // 使用 IPV4 地址
    serv_addr.sin_famlily=AF_INET;
    // 具体的 IP 地址
    serv_addr.sin_addr.s_addr=inet_addr("127.0.0.1");
    // 端口
    serv_addr.sin_port=host(1234);
    /*
    1) bind() 函数将套接字 serv_sock 与特点的 IP 地址和端口绑定。
    2) IP 地址和端口都保存在 sockaddr_in 结构体中。
    3) socket() 函数确定了套接字的各种属性，bind() 函数让套接字与特定的 IP 地址和端口对应起来，这样客户端才能连接到该套接字。
    */
    bind(serv_sock,(struct sockaddr*)&clnt_addr,&clnt_size);

    //进入监听状态，等待用户发起请求
    listen(serv_sock,20);

    // 接受客户端的请求
    struct sockaddr_in clnt_addr;
    socklen_t clnt_addr_size=sizeof(clnt_addr);
    int clnt_sock=accept(serv_sock,(struct sockaddr*)&clnt_addr,&clnt_addr_size);

    //向客户端发送数据
    char str[]="尼玛死了";
    write(clnt_sock,str,sizeof(str));

    // 关闭套接字
    close(clnt_sock);
    close(serv_sock);

    return 0;
}
```

client.cpp

```c
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>

int main(){
    int sock=socket(AF_INET,SOCK_STREAM,0);

    // 向服务器（特定的 IP 和端口）发起请求。
    struct sockaddr_in serv_addr;
    // 每个字节用 0 填充。
    memset(&serv_addr,0,sizeof(serv_addr));
    // 使用 IPV4 地址
    serv_addr.sin_famlily=AF_INET;
    // 具体的 IP 地址。
    serv_addr.sin_addr.s_addr=inet_addr("127.0.01");
    // 端口
    serv_addr.sin_port=htons(1234);

    connect(sock,(struct sockaddr*)&serv_addr,sizeof(serv_addr));

    // 读取服务器传回来的数据。
    char buffer[40];
    read(sock,buffer,sizeof(buffer)-1);
    printf("Message from server::%s\n",buffer);

    // 关闭套接字
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
