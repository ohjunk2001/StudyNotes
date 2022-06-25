## 第一种

项目结构

```
.
├── build
├── CMakeLists.txt
└── src
    ├── CMakeLists.txt
    └── // 这里存放 main.cpp 和 其他源文件和头文件
```

项目目录下的 CMakeLists.txt

## 自动遍历头文件和源文件

遍历指定路径下的*.cpp *.c文件，将得到的文件列表使用add_library()加入工程。

 遍历指定路径下的*.hpp *.h文件，将得到的文件列表使用include_directories()指定头文件路径。

添加源文件

```
# 查找source目录下的所有*.cpp,*.c源文件,并将文件列表保存到 DIR_LIB_SRCS 变量
file(GLOB_RECURSE SRC_DIR_LIST "source/*.cpp" "source/*.c")	//遍历获取source/路径下所有的*.cpp和*.c文件列表

#将DIR_LIB_SRCS中文件列表以静态库的方式加入工程
add_library(
        ${PROJECT_NAME} STATIC
        ${SRC_DIR_LIST}										//将DIR_LIB_SRCS中文件列表以静态库的方式加入工程
) 

message(STATUS "SRC_DIR_LIST = ${SRC_DIR_LIST}")			//打印SRC_DIR_LIST中列表信息
```

添加头文件

```
#自动查找头文件路径函数(没有去重)
macro(FIND_INCLUDE_DIR result curdir)  //定义函数,2个参数:存放结果result；指定路径curdir；
    file(GLOB_RECURSE children "${curdir}/*.hpp" "${curdir}/*.h" )	//遍历获取{curdir}中*.hpp和*.h文件列表
    message(STATUS "children= ${children}")								//打印*.hpp和*.h的文件列表
    set(dirlist "")														//定义dirlist中间变量，并初始化
    foreach(child ${children})											//for循环
        string(REGEX REPLACE "(.*)/.*" "\\1" LIB_NAME ${child})			//字符串替换,用/前的字符替换/*h
        if(IS_DIRECTORY ${LIB_NAME})									//判断是否为路径
            LIST(APPEND dirlist ${LIB_NAME})							//将合法的路径加入dirlist变量中
        endif()															//结束判断
    endforeach()														//结束for循环
    set(${result} ${dirlist})											//dirlist结果放入result变量中
endmacro()																//函数结束


#查找include目录下的所有*.hpp,*.h头文件,并路径列表保存到 INCLUDE_DIR_LIST 变量中
FIND_INCLUDE_DIR(INCLUDE_DIR_LIST ${PROJECT_SOURCE_DIR}/source)			//调用函数，指定参数

#将INCLUDE_DIR_LIST中路径列表加入工程		
include_directories(   													//INCLUDE_DIR_LIST路径列表加入工程
        ${INCLUDE_DIR_LIST}
)

message(STATUS "INCLUDE_DIR_LIST = ${INCLUDE_DIR_LIST}")				//打印INCLUDE_DIR_LIST中列表信息
```

## 语法规则

```
//声明要求的cmake最低版本,终端输入cmake -version可查看cmake的版本
cmake_minimum_required( VERSION 2.8 )

//声明cmake工程名字
project(slam)

//设置使用g++编译器,这是添加变量的用法set(KEY VALUE)接收两个参数，用来声明变量。在camke语法中使用${KEY}这种写法来取到VALUE
set( CMAKE_CXX_COMPILER "g++")

//设置cmake编译模式有debug和release两种PROJECT_SOURCE_DIR项目根目录也就是是CmakeLists.txt的绝对路径
set( CMAKE_BUILD_TYPE "Release" )

//设定生成的可执行二进制文件存放的存放目录
set( EXECUTABLE_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/bin)

//设定生成的库文件的存放目录
set( LIBRARY_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/lib)

//参数CMAKE_CXX_FLAGS含义是： set compiler for c++ language
//添加c++11标准支持，*.CPP文件编译选项,-march=native指定目标程序的cpu架构来进行程序优化
//native就是相当于自检测cpu，-march是gcc优化选项,后面的-O3是用来调节编译时的优化程度的，最高为-O3,最低为-O0即不做优化
//-Ox这个参数只有在CMake -DCMAKE_BUILD_TYPE=release时有效
//因为debug版的项目生成的可执行文件需要有调试信息并且不需要进行优化,而release版的不需要调试信息但需要优化
set( CMAKE_CXX_FLAGS “-std=c++11 -march=native -O3”)

//调试手段message打印信息，类似于echo/printf，主要用于查cmake文件的语法错误
set(use_test ${SOURCES_DIRECTORY}/user_accounts.cpp)
message("use_test ： ${use_test}")

//在CMakeLists.txt中指定安装位置, 在编译终端指定安装位置:cmake -DCMAKE_INSTALL_PREFIX=/usr ..
set(CMAKE_INSTALL_PREFIX < install_path >)

//增加子文件夹，也就是进入源代码文件夹继续构建
add_subdirectory(${PROJECT_SOURCE_DIR}/src)

//添加依赖，去寻找该库的头文件位置、库文件位置以及库文件名称，并将其设为变量，返回提供给CMakeLists.txt其他部分使用。
//cmake_modules.cmake文件是把CMakeLists.txt里用来寻找特定库的内容分离出来,如果提示没有找到第三方依赖库可以尝试安装或者暴力指定路径
// 寻找OpenCV库
find_package( OpenCV REQUIRED )

//在CMakeLists.txt中使用第三方库的三部曲:find_package、include_directories、target_link_libraries
include_directories(${OpenCV_INCLUDE_DIRS})// 去哪里找头文件
link_directories()// 去哪里找库文件(.so/.lib/.ddl等)
target_link_libraries( ${OpenCV_LIBRARIES})// 需要链接的库文件
message("OpenCV_INCLUDE_DIRS: \n" ${OpenCV_INCLUDE_DIRS})
message("OpenCV_LIBS: \n" ${OpenCV_LIBS})

// find_package(Eigen3 REQUIRED), 假如找不到Eigen3库，我们就设置变量来指定Eigen3的头文件位置
set(Eigen3_DIR /usr/lib/cmake/eigen3/Eigen3Config.cmake)
include_directories(/usr/local/include/eigen3)
```

