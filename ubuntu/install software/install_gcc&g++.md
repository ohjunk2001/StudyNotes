# install gcc & g++

```bash
$ sudo apt install build-essential
```

```
obj-m := lkm.o

KDIR := /lib/modules/$(shell uname -r)/build

PWD := $(shell pwd)

default:

$(MAKE) -C $(KDIR) SUBDIRS=$(PWD) modules

按照教程写hello world模块make时出现

make[1]: *** No rule to make target `modules'.  Stop.
错误

原makefile为

#!/bin/bash
#通知编译器我们要编译模块的哪些源码
obj-m += mini_linux_module.o 


#源码目录变量，这里用户需要根据实际情况选择路径
#作者是将Linux的源码拷贝到目录/media/lichee/linux-3.4下并解压的
KDIR := /media/lichee/linux-3.4


#当前目录变量
PWD ?= $(shell pwd)
#make命名默认寻找第一个目标
#make -C就是指调用执行的路径
#$(KDIR)Linux源码目录，作者这里指的是/media/lichee/linux-3.4
#$(PWD)当前目录变量
#modules要执行的操作
all:
make -C $(KDIR) M=$(PWD) modules

#make clean执行的操作是删除后缀为o的文件
clean:
rm -rf *.o

改为


#!/bin/bash
#通知编译器我们要编译模块的哪些源码
obj-m += mini_linux_module.o 


#源码目录变量，这里用户需要根据实际情况选择路径
#作者是将Linux的源码拷贝到目录/media/lichee/linux-3.4下并解压的
KDIR := /media/lichee/linux-3.4


#当前目录变量
PWD ?= $(shell pwd)


#make命名默认寻找第一个目标
#make -C就是指调用执行的路径
#$(KDIR)Linux源码目录，作者这里指的是/media/lichee/linux-3.4
#$(PWD)当前目录变量
#modules要执行的操作

build: kernel_modules
kernel_modules:
make -C $(KDIR) M=$(PWD) modules

#make clean执行的操作是删除后缀为o的文件
clean:
rm -rf *.o

————————————————
版权声明：本文为CSDN博主「darren_chain」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/darren_chain/article/details/70175483

obj-m := lkm.oKDIR := /lib/modules/$(shell uname -r)/buildPWD := $(shell pwd)default:$(MAKE) -C $(KDIR) SUBDIRS=$(PWD) modules
```

