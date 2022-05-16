# 安装 jdk

## 1. 安装 OpenJDK 8

```
sudo apt install openjdk-8-jdk
```
运行时会发生错误，**如果使用的是国外的源没有这些乱七八糟的东西**

## 2. 安装 java 11

```c
sudo apt install openjdk-11-jdk
```


## 3. 修改版本版本

如果你在你的 Ubuntu 系统上安装了多个 Java 版本，你可以输入下面的命令，修改版本。

- java -version  修改命令: sudo update-alternatives --config java
- javac -version 修改命令: sudo update-alternatives --config javac 
- javadoc -version 修改命令: sudo update-alternatives --config javadoc

```shell
$ sudo update-alternatives --config java
  
$ sudo update-alternatives --config javac  

$ sudo update-alternatives --config javadoc

```

## 4. 配置环境变量

> 如果是用 IDE 的开发，没有必要配置，只需知道 Java 被安装到哪里 `/usr/lib/jvm/`。

在一些 Java 应用中，环境变量JAVA_HOME被用来表示 Java 安装位置。想要设置 JAVA_HOME 变量，首先使用update-alternatives找到 Java 安装路径

~~~shell
$ sudo update-alternatives --config java 
~~~
找到你要配置环境变量的 JDK 安装地址。编辑 /etc/profile.d/env.sh 

```shell
$ vim /etc/profile.d/env.sh
->
#java
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64# 这里要注意目录要换成自己解压的jdk 目录
export JRE_HOME=${JAVA_HOME}/jre  
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib  
export PATH=${JAVA_HOME}/bin:$PATH  
# /usr/lib/jvm/java-8-openjdk-amd64"
# /usr/lib/jvm/java-11-openjdk-amd64
```

## 5. 卸载 

Java你可以使用 apt 卸载 Java，就像卸载任何软件包一样。例如，想要卸载default-jdk软件包，输入：`sudo apt remove openjdk-11-jdk`

```shell
sudo apt remove openjdk-11-jdk 
```

https://www.cnblogs.com/bovenson/p/4088461.html
