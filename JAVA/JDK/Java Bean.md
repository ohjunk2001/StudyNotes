
Java Bean 是一种 Java 语言写成的可重用组件。

所谓 JavaBean，是指符号如下标准的 Java 类

- 类是公共的。
- 有一个无参的公共构造器。
- 有属性，且有对应的 get、set 方法。

用户可以使用 JavaBean 将功能、处理、值、数据库访问和其他任何可以用 Java 代码创造的对象进行打包，并且其他的开发者可以通过内部的 JSP 页面、Servlet、其他 JavaBean 、applet 程序或者应用来使用这些对象。用户可以认为 JavaBean 提供了一种随时随地的复制和粘贴功能，而不用关心任何改变。

```java
package demo05;

public class Customer {
    private int id;
    private String Name;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }
}
```

