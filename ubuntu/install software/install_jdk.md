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


## 3. 设置默认版本

如果你在你的 Ubuntu 系统上安装了多个 Java 版本，你可以输入下面的命令，检测哪个版本被设置成了默认值：java -version想要修改默认的版本，使用update-alternatives命令：s

`sudo update-alternatives --config java`

输出像下面这样：
```
root@yanghao-X550VC:/# sudo update-alternatives --config java
链接组 java (提供 /usr/bin/java)中只有一个候选项：/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java
无需配置。
```

## 4. 配置环境变量

在一些 Java 应用中，环境变量JAVA_HOME被用来表示 Java 安装位置。想要设置 JAVA_HOME 变量，首先使用
update-alternatives找到 Java 安装路径
`sudo update-alternatives --config java`
~~~
root@yanghao-X550VC:/# sudo update-alternatives --config java
链接组 java (提供 /usr/bin/java)中只有一个候选项：/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java
无需配置。
~~~
一旦你发现你偏好的 Java 安装路径，打开/etc/environment文件：

`sudo nano /etc/environment`

假设你想设置 JAVA_HOME 指定到 OpenJDK 8，在文件的末尾，添加下面的行：

JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64"

运行下面的命令激活变量
`source /etc/environment`

验证 JAVA_HOME 环境变量被正确设置：

`echo $JAVA_HOME`

你应该可以看到 Java 安装路径：/usr/lib/jvm/java-11-openjdk-amd64

## 5. 卸载 

Java你可以使用 apt 卸载 Java，就像卸载任何软件包一样。例如，想要卸载default-jdk软件包，输入：`sudo apt remove openjdk-11-jdk`

