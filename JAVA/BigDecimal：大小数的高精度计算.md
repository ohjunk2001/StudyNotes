# BigDecimal：大小数的高精度计算

在 Java 中浮点数并不能准确的表示 0.1 这个十进制小数，它使用了 0.100000001490116119384765625 来代替 0.1 。

我们想要精确的表示这个小数就需要用到 BigDecimal 。

```java
BigDecimal BigDecimal(double d); //不允许使用，不能精准表示
BigDecimal BigDecimal(String s); //常用,推荐使用
static BigDecimal valueOf(double d); //常用,推荐使用


```

