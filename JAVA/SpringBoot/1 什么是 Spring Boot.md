# 什么是 Spring Boot

官网 https://spring.io/

众所周知 Spring 应用需要进行大量的配置，各种 XML 配置和注解配置让人眼花缭乱，且极容易出错，因此 Spring 一度被称为“配置地狱”。

**为了简化 Spring 应用的搭建和开发过程，Pivotal 团队在 Spring 基础上提供了一套全新的开源的框架，它就是 Spring Boot。**

Spring Boot 具有 Spring 一切优秀特性，Spring 能做的事，Spring Boot 都可以做，而且使用更加简单，功能更加丰富，性能更加稳定而健壮。随着近些年来微服务技术的流行，Spring Boot 也成为了时下炙手可热的技术。

Spring Boot 提供了大量开箱即用（out-of-the-box）的依赖模块，例如 spring-boot-starter-redis、spring-boot-starter-data-mongodb 和 spring-boot-starter-data-elasticsearch 等。这些依赖模块为 Spring Boot 应用提供了大量的自动配置，使得 Spring Boot 应用只需要非常少量的配置甚至零配置，便可以运行起来，让开发人员从 Spring 的“配置地狱”中解放出来，有更多的精力专注于业务逻辑的开发。

- 快速创建独立运行的 Spring 项目以及主流的框架集成；
- 使用嵌入式的 Servlet 容器，应用无需打包成 WAR 包；
- starters 自动依赖与版本控制；
- 大量自动的配置，简化开发，也可以修改默认值；
- 无需配置 XML 。无代码生成，开箱即用；
- 准生产环境的运行应用监控；
- 与云计算的天然集成。

> Spring Boot 来简化 Spring 应用开发，约定大于配置。

Spring Boot -> J2EE 一站式解决方案。

Spring CLoud -> 分布式整体解决方案。

## 微服务

martin fowler 以一篇博客推动了微服务的发展。个人博客 https://martinfowler.com/

https://martinfowler.com/microservices/

- 微服务是一种架构风格；

- 一个应用，应该是一种小型服务；
- 可以通过 HTTP 的方式进行互通；
- 一个微服务架构把每个功能元素放进一个独立的服务中；
- 只有当需要的时候才会调用相关的服务，进行组合，提供给他人使用；

- 每一个服务都可以独立的升级替换。

> 详细的信息在这个人的博客中。

