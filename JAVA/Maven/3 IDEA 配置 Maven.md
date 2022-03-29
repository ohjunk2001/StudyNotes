
在 IDEA 中内置了 Maven ，我们不使用这个 Maven 因为这个 Maven 设置起来不方便。

- 使用自己安装的 Maven 需要修改 IDEA 中默认的设置。

- 需要更改两个地方，settings 和 new project settings 

- 一个是当前项目的设置，另一个是新项目的设置。

![no.1](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/Java/maven/images_20220329223747.svg)

- Maven home path : Maven 的安装目录；
- User settings file :Maven 的配置文件；
- Local repository: 使用的代码仓库。

> 注意这些目录中不要包含中文目录。

除此之外你还可以在 Runner 中设置两个地方

![no.2](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/Java/maven/images_20220329223755.svg)

- VM Options 添加命令 -DarchetypeCatalog=internal 不加这个命令会下载一个文件，拖慢项目构建过程；
- JRE 指定要使用的 JRE 版本。