## 环境信息

- 电脑系统 Ubuntu 20.04
- cmake 版本 3.16.3

## 编写源文件和 CMakeLists.txt

- 创建一个文件夹 `HELLO`
- 在文件夹 `HELLO` 中创建文件 `main.cpp` 和 `CMakeLists.txt`

两个文件对应内容

```cpp
// main.cpp
#include <iostream>

int main(){
	std::cout <<  "hello word" << std::endl;
}
```

```cmake
// CMakeLists.txt
cmake_minimum_required(VERSION 3.16)
PROJECT (HELLO)
set(CMAKE_CXX_STANDARD 11)
SET(SRC_LIST main.cpp)

MESSAGE(STATUS "This is BINARY dir " ${HELLO_BINARY_DIR})

MESSAGE(STATUS "This is SOURCE dir "${HELLO_SOURCE_DIR})

ADD_EXECUTABLE(hello ${SRC_LIST})
```

完成后的目录结构

```shell
yanghao@OS:~/Test$ tree
.
├── CMakeLists.txt
└── main.cpp
```

下面开始编译，先输入命令 `cmake .` 再输入命令 `make`

```she
yanghao@OS:~/Test$ cmake .

CMake Warning (dev) at CMakeLists.txt:7:
  Syntax Warning in cmake code at column 37

  Argument not separated from preceding token by whitespace.
This warning is for project developers.  Use -Wno-dev to suppress it.

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
-- This is BINARY dir /home/yanghao/Test
-- This is SOURCE dir /home/yanghao/Test
-- Configuring done
-- Generating done
-- Build files have been written to: /home/yanghao/Test

yanghao@OS:~/Test$ make 
Scanning dependencies of target hello
[ 50%] Building CXX object CMakeFiles/hello.dir/main.cpp.o
[100%] Linking CXX executable hello
[100%] Built target hello
```

最终 Test 中的目录结构

```shell
yanghao@server:~/Test$ tree
.
├── CMakeCache.txt
├── CMakeFiles
│   ├── 3.16.3
│   │   ├── CMakeCCompiler.cmake
│   │   ├── CMakeCXXCompiler.cmake
│   │   ├── CMakeDetermineCompilerABI_C.bin
│   │   ├── CMakeDetermineCompilerABI_CXX.bin
│   │   ├── CMakeSystem.cmake
│   │   ├── CompilerIdC
│   │   │   ├── a.out
│   │   │   ├── CMakeCCompilerId.c
│   │   │   └── tmp
│   │   └── CompilerIdCXX
│   │       ├── a.out
│   │       ├── CMakeCXXCompilerId.cpp
│   │       └── tmp
│   ├── cmake.check_cache
│   ├── CMakeDirectoryInformation.cmake
│   ├── CMakeOutput.log
│   ├── CMakeTmp
│   ├── hello.dir
│   │   ├── build.make
│   │   ├── cmake_clean.cmake
│   │   ├── CXX.includecache
│   │   ├── DependInfo.cmake
│   │   ├── depend.internal
│   │   ├── depend.make
│   │   ├── flags.make
│   │   ├── link.txt
│   │   ├── main.cpp.o
│   │   └── progress.make
│   ├── Makefile2
│   ├── Makefile.cmake
│   ├── progress.marks
│   └── TargetDirectories.txt
├── cmake_install.cmake
├── CMakeLists.txt
├── hello                         /// 可执行文件
├── main.cpp
└── Makefile
```

跑一下，可执行程序

```shell
yanghao@OS:~/Test$ ./hello
hello word
```

下面我们来解释一下 CMakeLists.txt 中的内容

### cmake_minimum_required

cmake_minimum_required 用于设置 cmake 的版本

### PROJECT关键字

可以用来指定工程的名字和支持的语言

- `PROJECT (HELLO)`   指定了工程的名字

- `PROJECT (HELLO CXX)`  指定了工程的名字，并且支持语言是 C++

- `PROJECT (HELLO C CXX)`  指定了工程的名字，并且支持语言是 C 和 C++
- 除了 C 和 C++ 还支持其他的语言，具体是哪些，怎么写，自己去查

这种写法隐式定义的变量

- `PROJECT_NAME` 项目的名字这里是 HELLO

- `<projectname>_BINARY_DIR`，本例中是 HELLO_BINARY_DIR
- `<projectname>_SOURCE_DIR`，本例中是 HELLO_SOURCE_DIR

这两个变量是有用的，MESSAGE 关键字就可以直接使用者两个变量，当前都指向当前的工作目录，后面续会用到

**隐式定义有不好的地方，如果改了工程名，这两个变量名也会改变。如果在 CMakeLists.txt 中其他的地方用到了这两个变量，要一个一个的去改。**

所以，定义两个预定义变量：PROJECT_BINARY_DIR 和 PROJECT_SOURCE_DIR，这样不怕改名了。

### SET关键字

用来指定某些变量的值

- `SET(SRC_LIST main.cpp)`    SRC_LIST 变量包含了main.cpp

- `SET(SRC_LIST main.cpp t1.cpp t2.cpp)` SRC_LIST 包含了  main.cpp t1.cpp t2.cpp

- `CMAKE_CXX_STANDARD` 变量指定项目使用的 C++ 语言版本，这里是 C++11

### MESSAGE关键字

向终端输出用户自定义的信息

主要包含三种信息：

- SEND_ERROR，产生错误，生成过程被跳过。
- SATUS，输出前缀为`—`的信息。
- FATAL_ERROR，立即终止所有 cmake 过程.

### ADD_EXECUTABLE关键字

用于生成可执行文件

- `ADD_EXECUTABLE(hello ${SRC_LIST})`  生成的可执行文件名是 hello，源文件读取变量 SRC_LIST 中的内容

- 也可以直接写 ADD_EXECUTABLE(hello main.cpp)

## 语法的基本原则（一）

- 变量使用 `${}` 方式取值，但是在 IF 控制语句中可以直接使用变量名
- `指令(参数1 参数2...)` 参数使用括弧括起，参数之间使用空格或分号分开。
  - `SET(SRC_LIST main.cpp)` 可以写成 `SET(SRC_LIST “main.cpp”)`，如果源文件名中含有空格，就必须要加双引号
- 指令是大小写无关的，参数和变量是大小写相关的，但，推荐你全部使用大写指令
- `ADD_EXECUTABLE(hello main)` 后缀可以不行，他会自动去找 .c 和 .cpp，最好不要这样写，可能会有这样的两个文件main.c 和 main.cpp

## 内部构建和外部构建

- 上述例子就是内部构建，他生产的临时文件特别多，不方便清理
- 外部构建，就会把生成的临时文件放在 build 目录下，不会对源文件有任何影响强烈使用外部构建方式

## 尝试进行外部构建

先把刚才编译产生的文件删干净，再创建一个 build 目录，最终目录结构如下

```cpp
yanghao@OS:~/Test$ tree
.
├── build
├── CMakeLists.txt
└── main.cpp
```
进入 build 目录运行命令 `cmake ..` 再运行命令 `make` ，操作过程如下

```cpp
yanghao@OS:~/Test/build$ cmake ..
CMake Warning (dev) at CMakeLists.txt:7:
  Syntax Warning in cmake code at column 37

  Argument not separated from preceding token by whitespace.
This warning is for project developers.  Use -Wno-dev to suppress it.

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
-- This is BINARY dir /home/yanghao/Test/build
-- This is SOURCE dir /home/yanghao/Test
-- Configuring done
-- Generating done
-- Build files have been written to: /home/yanghao/Test/build
yanghao@OS:~/Test/build$ make
Scanning dependencies of target hello
[ 50%] Building CXX object CMakeFiles/hello.dir/main.cpp.o
[100%] Linking CXX executable hello
[100%] Built target hello
```

编译后的目录结构

```cpp
yanghao@OS:~/Test$ tree
.
├── build
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
│   │   ├── hello.dir
│   │   │   ├── build.make
│   │   │   ├── cmake_clean.cmake
│   │   │   ├── CXX.includecache
│   │   │   ├── DependInfo.cmake
│   │   │   ├── depend.internal
│   │   │   ├── depend.make
│   │   │   ├── flags.make
│   │   │   ├── link.txt
│   │   │   ├── main.cpp.o
│   │   │   └── progress.make
│   │   ├── Makefile2
│   │   ├── Makefile.cmake
│   │   ├── progress.marks
│   │   └── TargetDirectories.txt
│   ├── cmake_install.cmake
│   ├── hello                    // 可执行文件
│   └── Makefile
├── CMakeLists.txt
└── main.cpp
```

从 cmake 的编译信息，可以知道在外部构建中 `HELLO_SOURCE_DIR` 和 `HELLO_BINARY_DIR` 对应的路径发生了变化

```
-- This is BINARY dir /home/yanghao/Test/build
-- This is SOURCE dir /home/yanghao/Test
```
