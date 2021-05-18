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