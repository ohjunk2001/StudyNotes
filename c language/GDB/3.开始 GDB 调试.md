# 开始 GDB 调试

如果要使用 GDB 调试某个可执行文件，该文件中必须包含必要的调试信息（比如各行代码所在的行号、包含程序中所有变量名称的列表（又称为符号表）等），这些调试信息需要在编译时生成。

如何生成符合 GDB 调试要求的可执行文件呢？很简单，只需要使用 gcc -g 选项编译源文件，即可生成满足 GDB 要求的可执行文件。

```c
// temp.c
#include <stdio.h>
int main ()
{
    unsigned long long int n, sum;

    n = 1;
    sum = 0;

    while (n <= 100)
    {
        sum = sum + n;
        n = n + 1;
    }

    return 0;
}
```

开始调试

```shell
$ gcc temp.c -o temp -g // 生成可以进行 gdb 调试的可执行文件
$ 
```

