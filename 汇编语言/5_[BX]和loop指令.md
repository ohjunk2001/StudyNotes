# [BX] 和 loop 指令

- [bx] 表示一个内存单元，它的偏移地址在 bx 中，段地址在 ds 中
- loop 与循环有关
- ()  表示一个寄存器或者内存单元中的内容

## [BX]

分析下面程序

> inc 是 bx 内容加 1 的意思

```
mov ax,2000H
mov ds,ax
mov bx,1000H
mov ax,[bx]
inc bx
inc bx
mov [bx],ax
inc bx
inc bx
mov [bx],ax
inc bx
mov [bx],ax
inc bx
mov [bx],al

```

## loop

loop 指令的格式是：loop 标号

CPU 执行指令的时候，进行两步操作

- (cx)=(cx)-1
- 判断 (cx) 中的值，不为零则转至标号处执行程序，为零则向下执行

编程计算 2^2，结果保存在 ax 中

```
assume cs:code
code segment
mov ax,2
add ax,ax
mov ax,4c00h
int 21h
code ends
end
```