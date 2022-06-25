
- 电脑系统 win10
- 使用 Vscode 作为开发环境只适合一些小的工程，大工程还得是 IDE
- 使用了 Cmake 

## 打开一个目录

用 Vscode 打开一个目录作为工作区

## 安装 VScode 和插件

VScode 怎么装，不用我说了，插件选择这个整合插件

![](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/C%2B%2B/dev/2/images_20220420080031.png)

## 安装 CMkae

[https://cmake.org/](https://cmake.org/) 

在官网找到 Binary distributions ，用 zip 的免安装

![](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/C%2B%2B/dev/2/images_20220420080928.png)

下载后，解压到合适的目录

## 环境变量的添加

把相应的 bin 目录添加到 环境变量中

## Vscode 设置

### 插件 Microsoft C/C++ Extension 设置

- ctrl+shift+P 输入 C/C++ 找到 Edit configurations(UI) 那一项。
- 设置 Complier path 指定 `g++.exe` 路径
- 设置语言版本
- 设置 configration provider 设置成 `ms-vscode.cmake-tools` 这个一定要设置，设置完这个你的的项目就由 Camke 管理了。

![](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/C%2B%2B/dev/2/images_20220420093936.png)

![](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/C%2B%2B/dev/2/images_20220420102913.png)

### 插件 CMake Tools 设置

ctrl+shift+P 输入 Cmake 找到 configure，之后找到 Cmake Path 这一项，设置 CMake 路径

![](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/C%2B%2B/dev/2/images_20220420103822.png)

我的 CMake 路径是

```
C:/tool/tool/cmake-3.23.1-windows-x86_64/cmake-3.23.1-windows-x86_64/bin/cmake.exe
```

安装完插件后，左侧会出一个带有三角形的 CMake 选项图标，找到 Edit Cmake Cache(UI) 

在这里你可以看到设置的一些信息

![](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/C%2B%2B/dev/2/images_20220420103344.png)

## 编译运行及 Debug

## 编译运行

首先打开一个目录作为工作区目录，在这个目录下创建 `.vscode` 文件夹和如下的三个文件。

![](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/C%2B%2B/dev/2/images_20220507120748.png)



- 这里的思路是，先用 CMake 去编译出来一个可执行文件（.exe）。

- 然后，设置断点，去跑这个文件，看各种变量的值。
- 这已经能满足大部分情况下需求，剩下需要你手动调试了

> 还是要学会在黑窗窗上，一行行敲命令编译调试这个很有必要
