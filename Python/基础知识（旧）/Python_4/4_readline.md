# readline

readline 会一行一行的读取文件

```py
file=open("文件地址")

while True:
    text=file.readline()
    if not text:
        break
    
    # 每读取一行的末尾已经有了一个 `\n`
    print(text,end="")
file.close
```