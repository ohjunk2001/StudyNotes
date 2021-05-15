# sizeof 运算符

sizeof 是一种单目运算符，以字节为单位返回某些类型的长度

Case
```c
int main() {
    int n=0;
    int int_size=sizeof (int);
    printf("int sizeof is %d bytes",int_size);
    return 0;
}
```

result
```
int sizeof is 4 bytes
```