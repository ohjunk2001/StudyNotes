
## 下载 Maven

官网下载 https://archive.apache.org/

> 自己选一个合适的 maven 版本，我选的是 3.6.1 。

## 解压安装

```shell
$ sudo tar -zxvf xxxxx.tar.gz -C /usr/local/bin/
```

### 查看解压后的文件

```
$ cd /usr/local/bin/apache-maven-3.6.1
$ tree
.
├── bin
│   ├── m2.conf
│   ├── mvn # 提供了 liunx 下与 Maven 相关的命令。 
│   ├── mvn.cmd # 提供了 Windows 下与 Maven 相关的命令。
│   ├── mvnDebug 
│   ├── mvnDebug.cmd
│   └── mvnyjp
├── boot
│   ├── plexus-classworlds-2.6.0.jar
│   └── plexus-classworlds.license
├── conf
│   ├── logging
│   │   └── simplelogger.properties
│   ├── settings.xml // 配置文件
│   └── toolchains.xml // 工具链配置文件
├── lib
│   # 忽略 lib 中的文件
├── LICENSE
├── NOTICE
└── README.txt

```

## 添加环境变量

在 /etc/profile.d 中修改自己的环境变量。

```bash
export M2_HOME=/usr/local/bin/apache-maven-3.6.3
export CLASSPATH=$CLASSPATH:$M2_HOME/lib
export PATH=$PATH:$M2_HOME/bin
```

## 添加镜像

- 在解压目录下的 conf 文件夹中找到 setting.xml 

- 在 setting.xml 中找到 `<mirrors> ` 添加下面的内容

```xml

<mirror>  
    <id>alimaven</id>  
    <name>aliyun maven</name>  
    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>  
    <mirrorOf>central</mirrorOf>          
</mirror>  

```

## 自定义本地仓库

- maven 下载的 jar 包都会放到默认的文件夹 `${user.home}/.m2/repository` 中，这个存放 jar 包文件夹可以自行设置。
- 修改 setting.xml 文件中的 `<localRepository>` 。
- 现在把文件夹 `/home/sunny/FILE/maven_repository` 当做本地仓库，那么 setting.xml 就修改成下面这样。

```xml
 <!-- localRepository
   | The path to the local repository maven will use to store artifacts.
   |
   | Default: ${user.home}/.m2/repository
   -->
  <localRepository>/home/sunny/FILE/maven_repository</localRepository>
```

## 检查配置

- 先自己检查一遍各项配置有没有搞错
- 输入命令 `mvn help:system` 检查有没有错误
- 如果成功，你会看到 `BUILD SUCCESS`  这期间会下载一些 jar 包到仓库里
