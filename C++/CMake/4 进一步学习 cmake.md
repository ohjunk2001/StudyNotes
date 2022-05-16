前面我们用 cmake 编译的项目结构很简单，日常是用不到的，下面我们要用 cmake 编译一个结构更复杂的项目。

- 为工程添加一个子目录 src，用来放置工程源代码
- 添加一个子目录 doc，用来放置这个工程的文档 hello.txt
- 在工程目录添加文本文件 COPYRIGHT, README
- 在工程目录添加一个 [runhello.sh](http://runhello.sh/) 脚本，用来调用 hello 二进制
- 将构建后的目标文件放入构建目录的 bin 子目录
- 将 doc 目录 的内容以及 COPYRIGHT/README 安装到/usr/share/doc/cmake/
- 每一个子目录中都要有一个 CMakeLists.txt

```cpp
yanghao@OS:~/Test$ tree
.
├── build
├── CMakeLists.txt
└── src
    ├── CMakeLists.txt
    └── main.cpp

2 directories, 3 files
```

Test 目录下 CMakeLists.txt 的内容

```cmake
cmake_minimum_required(VERSION 3.16)
PROJECT(HELLO)
set(CMAKE_CXX_STANDARD 11)
ADD_SUBDIRECTORY(src bin)
```

src 目录下 CMakeLists.txt 的内容

```cmake
ADD_EXECUTABLE(hello main.cpp)
```

下面开始编译

```bash
yanghao@OS:~/Test/build$ cmake ..
-- The C compiler identification is GNU 9.4.0
-- The CXX compiler identification is GNU 9.4.0
-- Check for working C compiler: /usr/bin/cc
-- Check for working C compiler: /usr/bin/cc -- works
-- Detecting C compiler ABI info
-- Detecting C compiler ABI info - done
-- Detecting C compile features
-- Detecting C compile features - done
-- Check for working CXX compiler: /usr/bin/c++
-- Check for working CXX compiler: /usr/bin/c++ -- works
-- Detecting CXX compiler ABI info
-- Detecting CXX compiler ABI info - done
-- Detecting CXX compile features
-- Detecting CXX compile features - done
-- Configuring done
-- Generating done
-- Build files have been written to: /home/yanghao/Test/build
yanghao@OS:~/Test/build$ make
Scanning dependencies of target hello
[ 50%] Building CXX object bin/CMakeFiles/hello.dir/main.cpp.o
[100%] Linking CXX executable hello
[100%] Built target hello
```

最终的目录结构

```bash
yanghao@OS:~/Test$ tree
.
├── build
│   ├── bin      // 编译放置的文件
│   │   ├── CMakeFiles
│   │   │   ├── CMakeDirectoryInformation.cmake
│   │   │   ├── hello.dir
│   │   │   │   ├── build.make
│   │   │   │   ├── cmake_clean.cmake
│   │   │   │   ├── CXX.includecache
│   │   │   │   ├── DependInfo.cmake
│   │   │   │   ├── depend.internal
│   │   │   │   ├── depend.make
│   │   │   │   ├── flags.make
│   │   │   │   ├── link.txt
│   │   │   │   ├── main.cpp.o
│   │   │   │   └── progress.make
│   │   │   └── progress.marks
│   │   ├── cmake_install.cmake
│   │   ├── hello   //  可执行文件
│   │   └── Makefile
│   ├── CMakeCache.txt
│   ├── CMakeFiles
│   │   ├── 3.16.3
│   │   │   ├── CMakeCCompiler.cmake
│   │   │   ├── CMakeCXXCompiler.cmake
│   │   │   ├── CMakeDetermineCompilerABI_C.bin
│   │   │   ├── CMakeDetermineCompilerABI_CXX.bin
│   │   │   ├── CMakeSystem.cmake
│   │   │   ├── CompilerIdC
│   │   │   │   ├── a.out
│   │   │   │   ├── CMakeCCompilerId.c
│   │   │   │   └── tmp
│   │   │   └── CompilerIdCXX
│   │   │       ├── a.out
│   │   │       ├── CMakeCXXCompilerId.cpp
│   │   │       └── tmp
│   │   ├── cmake.check_cache
│   │   ├── CMakeDirectoryInformation.cmake
│   │   ├── CMakeOutput.log
│   │   ├── CMakeTmp
│   │   ├── Makefile2
│   │   ├── Makefile.cmake
│   │   ├── progress.marks
│   │   └── TargetDirectories.txt
│   ├── cmake_install.cmake
│   └── Makefile
├── CMakeLists.txt
└── src
    ├── CMakeLists.txt
    └── main.cpp

12 directories, 37 files
```

### ADD_SUBDIRECTORY 指令

`ADD_SUBDIRECTORY(source_dir [binary_dir] [EXCLUDE_FROM_ALL])`

- 这个指令用于向当前工程添加存放源文件的子目录，并可以指定中间二进制和目标二进制存放的位置
- EXCLUDE_FROM_ALL 编译中忽略的某些文件夹
- `ADD_SUBDIRECTORY(src bin)`
  - 将 src 子目录加入工程并指定编译输出(包含编译中间结果)路径为bin 目录
  - 如果不进行 bin 目录的指定，那么编译结果(包括中间结果)都将存放在build/src 目录

### 更改二进制的保存路径

SET 指令重新定义 `EXECUTABLE_OUTPUT_PATH` 和 `LIBRARY_OUTPUT_PATH` 变量来指定最终的目标二进制的位置

```cmake
SET(EXECUTABLE_OUTPUT_PATH ${PROJECT_BINARY_DIR}/bin)
SET(LIBRARY_OUTPUT_PATH ${PROJECT_BINARY_DIR}/lib)
```
思考：加载哪个CMakeLists.txt当中

哪里要改变目标存放路径，就在哪里加入上述的定义，所以应该在 src 下的 CMakeLists.txt 下写

- 一种是从代码编译后直接 make install 安装
- 一种是打包时的指定 目录安装。
    - 简单的可以这样指定目录：make install DESTDIR=/tmp/test
    - 稍微复杂一点可以这样指定目录：./configure –prefix=/usr

## 安装编译的可执行文件

- 使用CMAKE一个新的指令：INSTALL
- INSTALL的安装可以包括：二进制、动态库、静态库以及文件、目录、脚本等
- 使用CMAKE一个新的变量：CMAKE_INSTALL_PREFIX

```cpp
// 目录树结构
[root@localhost cmake]# tree
.
├── build
├── CMakeLists.txt
├── COPYRIGHT
├── doc
│   └── hello.txt
├── README
├── runhello.sh
└── src
    ├── CMakeLists.txt
    └── main.cpp

3 directories, 7 files
```
