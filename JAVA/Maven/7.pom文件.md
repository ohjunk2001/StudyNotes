# pom 文件

pom 文件是 maven 的核心文件，管理着 maven 的的方方面面。

| 基本信息     | 描述                                                         |                                                          |
| ------------ | ------------------------------------------------------------ | -------------------------------------------------------- |
| modelVersion | maven 模型的版本，对于 Maven 2 和 Maven 3 来说，它只能是 4.0.0 |                                                          |
| groupId      | 组织 ID 一般是公司域名的缩写，格式可以为：                                                                                                                                                                       1. 域名倒写，例如 com.baidu                                                                                                                                                                                                       2.域名倒写 + 项目名称，例如 com.baidu.Hello | groupId artifactId   version  三个元素在一起就称为坐标。 |
| artifactId   | 项目名称，也是模块名称，对应 groupId 中项目的子项目。        |                                                          |
| version      | 项目的版本号，如果项目还在开发中，是不稳定版本，通常在版本后带 -SNAPSHOT                                                                                                     version 通常使用三位数标识，例如 1.1.0 |                                                          |
| packaging    | 项目打包的类型，可以使用 jar, war, rar, ear, pom 默认是 jar  |                                                          |
| dependencies | 使用 标签 dependencies 来配置依赖，其作用类似于java 程序中的 import |                                                          |
| properties   | 用来定义一些配置属性。例如 project.build.sourceEncoding （项目构建源码编码方式）可以设置 为 UTF-8 防止中文乱码，也可以定义相关构建版本号，便于日后统一升级。 |                                                          |
| build        | build 表示与构建相关的配置，例如 设置编译插件的 JDK 版本。   |                                                          |
| parent       | 继承 在 Maven 中，如果多个模块都需要声明相同的配置，例如：groupId, version, 相同的依赖，或者使用相同的组件配置，也有类似于 Java 的继承机制，用 parent 声明 要继承的父工程的 pom 配置。 |                                                          |
| modules      | 在 Maven 的多模块开发中，为了统一构建整个项目的所有模块，可以提供一个额外的模块，该模块的打包方式为 pom ,并且在其中使用 moudles 聚合的其他模块，这样通过本模块就可以一键自动识别模块的依赖关系来构建所有模块，叫做 Maven 的聚合。 |                                                          |

**坐标**：groupId artifactId   version  三个元素在一起就称为坐标，是唯一值，在互联网中唯一标识一个项目。

```
<groupId>公司域名的倒写</groupId>
<artifactId>自定义的项目名称<artifactId>
<version>自定义版本号</version>
```

作用当作索引在[中央仓库](https://mvnrepository.com/)中搜索项目

**依赖**：项目中你要使用

