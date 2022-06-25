Qt 提供了功能更加强大的 QString 字符串。

- QString 类保存 16 位 Unicode 值
- 提供大量功能丰富的函数
- 使用隐式共享 (implicit sharing)
- 高效的内存分配策略

## 操作字符串

QString 提供两个操作符 `+` 和 `+=` 用于拼接字符串

```
QString str1="Yang";
QString str2=" Hao";
QString str3=str1+str2;
QString str1+=str2; // 这时 str1 与 str3 相同

// QString::append() 有 += 相同的功能 

str1.append(str2);
```

函数 `QString::sprintf()` 与 C++ 标准库中的 sprintf 功能一致。

```
QString str;
str.sprintf("%s"," Welcome "); // str="Welcome"

```

函数 `QString::arg()` 用于处理字符串，比 `QString::sprintf` 更好用

- 类型安全
- 完全支持 Unicode
- 允许改变 `%n` 参数顺序

```
QString str;
str=QString("%l was born in %2.").arg("John").arg(1998)
    
str="John was born in 1998."
```

 QString 提供的一些其他操作字符串的函数，具体用法看 Qtcreator 中的自带的官方文档

| 函数      | 功能                                   |
| --------- | -------------------------------------- |
| insert()  | 在一个字符串的特定位置插入另一个字符串 |
| prepend() | 在原字符串的开头插入                   |
| replace() | 用指定的字符串代替原字符串中的某些字符 |

### 去除字符串两端的空白字符

空白字符包括：回车字符 `\n` 、换行字符 `\r` 制表字符 `\t` 空格字符 ` ` （中英文空格没有区别）

- `QString::trimmed()` 去除字符串两端的空白字符

- `QString::simplified()` 移除字符串两端的空白字符并使用单个空格字符代替

