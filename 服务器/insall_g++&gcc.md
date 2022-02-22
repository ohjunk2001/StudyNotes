# install g++ & gcc

## 1.ubuntu下的安装

安装g++编译器的命令：

```
sudo apt-get install build-essential
```

执行完后，就完成了gcc,g++,make的安装。build-essential是一整套工具，gcc，libc等等。

通过 `g++ -v` 可以查看 g++ 是否安装成功。

通过 `gcc -version` 可以查看 gcc 是否安装成功。

注：“sudo apt-get install build-essential –fix-missing”，这个命令是修补安装build-essential，即已安装了部分build-essential，但没有安装完全，此时可以使用该命令继续安装 build-essential。

## 2.CentOS下g++的安装

Centos下的g++安装包的名字叫做gcc-c++，这是与Centos与Ubuntu不同的地方。安装命令如下：

`yum install gcc gcc-c++`

执行完该命令后，g++/gfortran都被安装成功了。

## 3.运行 cpp 程序

执行命令 `g++ -o hello hello.cpp`后，就会在当前目录下生成一个hello的 .o 文件

再执行 `./hello` 就会运行 cpp 程序了。
