hardcode 一些基础样式在主文档里面。 比如loading动画或者基础背景色。

在bundle.js请求没有回来之前，有较好的等待效果，而这段样式无需异步加载。



加载慢原因：

1、bundle太大，没有压缩混淆。

2、bundle没有使用异步模块加载。

3、bundle没有拆分css样式或者base64了图片。



以上都可以对症下药。



我上述提到的内置加载样式是指。


```
<html>

    <style>

   

  body {

    background-color: #EEE;

   }

  

  .loading {

    // .... loading动画样式

    background-image: url("./loading.gif");
}

  </style>

  <body>

        <div class="loading"></div>

  </body>

</html>
```

这样页面请求回来的时候 就已经有一个加载动画，在缓解加载等待体验。 而不是单纯的白屏。