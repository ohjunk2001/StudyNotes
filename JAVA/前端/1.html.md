# HTML

## 1.基本元素

### 标签

HTML是Hyper Text Markup Language 超文本标记语言 的缩写

HTML是由一套标记标签 （markup tag）组成，通常就叫标签

标签由开始标签和结束标签组成

```
<p> 这是一个开始标签
</p> 这是一个结束标签
<p> Hello World </p> 标签之间的文本叫做内容
```

### 元素

元素指的是从开始标签到结束标签之间所有的代码，比如 `<p>HelloWord</p>`

### 属性

属性用来修饰标签的

比如要设置一个标题居中

```
<h1 align="center">居中标题</h1>
```

- 写在开始标签里的 **align="center"** 就叫属性
- align 是**属性名**
- center 是**属性值**
- 属性值应该使用双引号括起来

### 注释

html 使用` <!-- -->` 注释



### 中文乱码问题
可以在浏览器上设置编码方式为GB2312
或者在html的最前面加上编码设置

```html
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
</head> 
```

如果 GB2312 不行，换成 UTF-8 试试。

## 2.HTML 的页面效果

### 2.1 标题

标题会粗写、大写内容，并且具有换行的效果，一般使用 `<h1>` 到 `<h6>` 来表示不同大小的标题。

```html
<h1>标题1</h1>
<h2>标题2</h2>
<h3>标题3</h3>
<h4>标题4</h4>
<h5>标题5</h5>
<h6>标题6</h6>
```

### 2.2 段落

`<p>` 标签代表段落，是 paragraph 的缩写，自带换行的效果。

```html
<p>段落1</p>
<p>段落2</p>
<p>段落3</p>
<p>段落4</p>
```

### 2.3 粗体

`<b>` 和 `<strong>` 都可以表示粗体。

> 区别：b是bold的缩写，仅仅表示该文本是粗体的，**并不暗示这段文字的重要性**
> strong虽然也是粗体，但是更多的是强调语义上的加重，提醒用户该文本的重要性。 在SEO（搜索引擎优化）的时候，也更加容易帮助用户找到重点的内容
> 推荐使用strong

```html
<p>无粗体效果</p>
<b>b标签粗体效果</b>
<br/>
<strong>strong标签粗体效果</strong>
```

### 2.4 斜体

`<i>` 和 `<em>` 都可以表示斜体效果。

> i 是 italic 的缩写，仅仅表示该文本是斜体的，并不暗示这段文字的重要性
>
> em 是 Emphasized 的缩写，虽然也是斜体，但是更多的是强调语义上的加重，提醒用户该文本的重要性。 常常用于引入新的术语的时候使用。

```html
<p>无斜体效果</p>

<i>使用 i 标签带来的斜体效果</i>
<br/>

<em>使用 em 标签带来的斜体效果</em>
```

### 2.5 预格式 

有时需要在网上显示代码，为了更好的显示效果，我们需要用到预格式 ，对应的标签`pre`。

```
这里是没有用预格式的情况：

public class HelloWorld { public static void main(String[] args) { System.out.println("Hello World"); } }

使用预格式的情况:

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
```

对应的代码

```html
<p>这里是没有用预格式的情况：</p>

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}

<br/>
<br/>

<p>使用预格式的情况:</p>

<pre>
public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}

</pre>
```

### 2.6 删除效果

删除效果（在文字上画一条横线）使用标签 `<del>` 。

> 标签 `<s>` 也可以实现删除效果，但是不推荐使用，因为许多浏览器不支持 `<s>` 标签。

```html
<p>无删除效果</p>
<del>使用del标签实现的删除效果</del>
<br/>
<s>使用s标签实现的删除效果，但是不建议使用，因为很多浏览器不支持s标签</s>
```

### 2.7 下划线

下划线标签 `<ins>` 

```html
<ins>使用ins标签实现的下划线效果</ins>

<br/>

<u>使用u标签实现的下划线效果，但是不建议使用</u>
```

### 2.8 插入图片

要想在 html 页面上插入图片，就需要使用 `<img>` 标签，同时设置其属性 `src` 。

<img src="https://how2j.cn/example.gif">

```html
<img src="https://how2j.cn/example.gif">
```

#### 2.8.1 src 怎么设置

（1）图片 与 html 页面在同一目录下

这样的情况只写图片的文件名。

（2）图片在 html 页面的上级目录下

使用 `../` 来指代上级目录

（3）图片在其他目录下

这种情况使用图片的绝对路径前面再加上 `file:\\`

#### 2.8.2 图片大小设置

设置图片的大小需要用到属性 width 和 height 。

```html
<img width="200" height="200" src="https://how2j.cn/example.gif">
```

#### 2.8.3 图像居中

标签 img 不能将图片居中，需要与其他支持居中的标签，配合使用才能让图片居中。

与之相配合的标签是 `<div>`

```html
<div align="left">
  <img src="https://how2j.cn/example.gif"/>
</div>

<div align="center">
  <img src="https://how2j.cn/example.gif"/>
</div>

<div align="right">
  <img src="https://how2j.cn/example.gif"/>
</div>
```

#### 2.8.4 图片缺失

如果图片不存在，默认会显示一个缺失的图片，这非常难看。

所以可以使用 alt 属性，当图片存在的时候 alt 不会显示，图片不存在的时候才会显示。

```html
  <img src="https://how2j.cn/example_not_exist.gif" />

  <br/>

  <img src="https://how2j.cn/example.gif" alt="这个是一个图片" />

  <br/>
  <img src="https://how2j.cn/example_not_exist.gif" alt="这个是一个图片" />
```

### 2.9 超链接

在 html 页面中插入超链接，需要用到标签 `<a>` 。

```html
<a href="跳转的页面地址">显示超链接的文本</a>
```

#### 2.9.1 页面跳转

点击一个超链接，如果想要在新的窗口访问就需要使用属性 target

```html
<a href="http://www.12306.cn" target="_blank">http://www.12306.cn</a>
```

#### 2.9.2在超链上显示文字

当鼠标放在超链上，就会弹出文字，这种效果要用到属性 title

```html
<a href="http://www.12306.cn" target="_blank" title="跳转到 www.12306.cn">http://www.12306.cn</a>
```

#### 2.9.3 使用图片作为超链

使用图片作为超链，你点击这个图片就相当于点击这个超链。

```html
<a href="http://www.12306.cn">
<img src="https://how2j.cn/example.gif"/>
</a>
```

### 2.10 表格

在 html 中插入表格需要使用标签 `<table>` 。

另外还需要标签 `<tr>` 表示行，`<td>` 表示列又叫单元格。

#### 2.10.1 示例

<table>
  <tr>
      <td>1</td>
      <td>2</td>
  </tr>
  <tr>
      <td>3</td>
      <td>4</td>
  </tr>
  <tr>
      <td>a</td>
      <td>b</td>
  </tr>
</table>
```html
<table>
  <tr>
      <td>1</td>
      <td>2</td>
  </tr>

  <tr>
      <td>3</td>
      <td>4</td>
  </tr>

  <tr>
      <td>a</td>
      <td>b</td>
  </tr>

</table>
```

#### 2.10.2 带边框的表格

要想表格带表框，就需要使用标签 `<table>` 的属性 border 。

```html
<table border="1">
  <tr>
      <td>1</td>
      <td>2</td>
  </tr>

  <tr>
      <td>3</td>
      <td>4</td>
  </tr>

  <tr>
      <td>a</td>
      <td>b</td>
  </tr>

</table>
```

#### 2.10.3 设置表格的宽度

设置宽度需要用到标签 `<table>` 的属性 width

```html
<table border="1" width="200px">
  <tr>
      <td>1</td>
      <td>2</td>
  </tr>

  <tr>
      <td>3</td>
      <td>4</td>
  </tr>

  <tr>
      <td>a</td>
      <td>b</td>
  </tr>

</table>
```

> px 即像素的意思，比如你的屏幕是 1024x768 意思是屏幕横向有 1024 个像素。

#### 2.10.4 设置每一列的宽度

同样使用属性 width

```html
<table border="1" width="200px">
  <tr>
      <td width="50px">1</td>
      <td>2</td>
  </tr>
  <tr>
      <td>3</td>
      <td>4</td>
  </tr>
  <tr>
      <td>a</td>
      <td>b</td>
  </tr>
</table>
```

> - 第一行的单元格设置宽度后，下面所有的单元格如果没有另外的设置，会自动继承宽度。
>
> - 这里 width 后的值除了可以写 px 还可以使用百分比。

```html
<table border="1" width="200px">
  <tr>
      <td width="80%">1</td>
      <td>2</td>
  </tr>
  <tr>
      <td>3</td>
      <td>4</td>
  </tr>
  <tr>
      <td>a</td>
      <td>b</td>
  </tr>
</table>
```

#### 2.10.5 设置单元格的水平对齐

使用属性 align 就可以设置单元格对齐方式。

```html
<table border="1" width="200px">
  <tr>
      <td width="50%" align="left">1</td>
      <td>2</td>
  </tr>
  <tr>
      <td align="center">3</td>
      <td>4</td>
  </tr>
  <tr>
      <td align="right">a</td>
      <td>b</td>
  </tr>
</table>
```

#### 2.10.6 设置单元格垂直对齐

使用属性 valign 可以设置单元格的垂直对齐方式。

```html
<table border="1" width="200px">
  <tr>
      <td width="50%" valign="top" >1</td>
      <td>
             2   <br/>
             2   <br/>
             2   <br/>
      </td>
  </tr>
  <tr>
      <td valign="middle"  >3</td>
      <td>
             4   <br/>
             4   <br/>
             4   <br/>
      </td>
  </tr>
  <tr>
      <td valign="bottom" >a</td>
      <td>
             b   <br/>
             b   <br/>
             b   <br/>
      </td>
  </tr>
</table>
```



#### 2.10.7 合并单元格

设置标签 `<td>` 的属性 `colspan ` 可以合并单元格。

```html
<table border="1" width="200px">
    <tr>
        <td colspan="2">1,2</td>
    </tr>
    <tr>
        <td>3</td>
        <td>4</td>
    </tr>
    <tr>
        <td>a</td>
        <td>b</td>
    </tr>
</table>
```

#### 2.10.8 合并列

设置标签 `<td>` 的属性 rowspan 就可以合并行。

```html
<table border="1" width="200px">
  <tr>
      <td rowspan="2">1,3</td>
      <td>2</td>
  </tr>
  <tr>
      <td>4</td>
  </tr>
  <tr>
      <td>a</td>
      <td>b</td>
  </tr>
</table>
```

#### 2.10.9 设置背景色

设置标签 `<tr>` `<td>` 的属性 bgcolor

```html
<table border="1" width="200px">
  <tr bgcolor="gray">
      <td width="50%">1</td>
      <td>2</td>
  </tr>
  <tr>
      <td>3</td>
      <td>4</td>
  </tr>
  <tr>
      <td>a</td>
      <td  bgcolor="pink">b</td>
  </tr>
</table>
```

### 2.11 列表

html 中的列表分为有序列表和无序列表两种。

无序列表

<ul>
<li>DOTA</li>
<li>LOL</li>
</ul>

```html
<ul>
<li>DOTA</li>
<li>LOL</li>
</ul>
```

有序列表

<ol>
<li>地卜师</li>
<li>卡尔</li>
</ol>

```html
<ol>
<li>地卜师</li>
<li>卡尔</li>
</ol>
```

### 2.12 块

标签 `<div>` 和 `<span>` 都是用于布局的，这两种标签本身没有任何显示效果，需要配合 CSS 一起使用。

```html
这没有标签
<div> 这是一个div </div>
<span>这是一个span</span>
```

#### 2.12.1 使用 div 布局图片

一个简单的div布局的例子

> 注： 这里使用了style外边距样式，margin-left:50px 指的是左边距50个像素

需要对两个图片进行左边距控制
如果不使用div,则需要对每一个图像设置边距
使用了div后，先把两个图像都放在一个div里
只需要设置div的边距，就可以达到两个图片都移动的效果

 <img style="margin-left:50px" src="https://how2j.cn/example.gif"/>
   <img style="margin-left:50px" src="https://how2j.cn/example.gif"/>

<div style="margin-left:100px" >
 <img src="https://how2j.cn/example.gif"/>
  <br/>
 <img src="https://how2j.cn/example.gif"/>
</div>
```html
 <img style="margin-left:50px" src="https://how2j.cn/example.gif"/>
  <br/>
 <img style="margin-left:50px" src="https://how2j.cn/example.gif"/>
<div style="margin-left:100px" >
 <img src="https://how2j.cn/example.gif"/>
  <br/>
 <img src="https://how2j.cn/example.gif"/>
</div>
```

#### 2.12.1 div 和 span 的区别

- div是块元素，即自动换行
- 常见的块元素还有h1,table,p
- span是内联元素，即不会换行
- 常见的内联元素还有img,a,b,strong

```html
<div>
 第一个div
</div>
<div>
 第二个div
</div>
<span>
 第一个span
</span>
<span>
 第二个span
</span>
```

### 2.13 字体

font 常用的属性有 color 和 size ，分别表示颜色和大小。

<font color="green">绿色默认大小字体</font>
<br>
<font color="blue" size="+2">蓝色大2号字体</font>
<br>
<font color="red" size="-2">红色小2号字体</font>

```html
<font color="green">绿色默认大小字体</font>
<br>
<font color="blue" size="+2">蓝色大2号字体</font>
<br>
<font color="red" size="-2">红色小2号字体</font>
```

#### 2.13.1 属性 color 的设置

- 直接写颜色名 bule red；
- 颜色对应的 16 进制，比如 #ff0000 就表示红色；

#### 2.13.2 颜色对应表

颜色名	十六进制颜色值	颜色
Red	#FF0000	rgb(255, 0, 0)
Yellow	#FFFF00	rgb(255, 255, 0)
Blue	#0000FF	rgb(0, 0, 255)
Green	#008000	rgb(0, 128, 0)
Orange	#FFA500	rgb(255, 165, 0)
Indigo	#4B0082	rgb(75, 0, 130)
Purple	#800080	rgb(128, 0, 128)
AliceBlue	#F0F8FF	rgb(240, 248, 255)
AntiqueWhite	#FAEBD7	rgb(250, 235, 215)
Aqua	#00FFFF	rgb(0, 255, 255)
Aquamarine	#7FFFD4	rgb(127, 255, 212)
Azure	#F0FFFF	rgb(240, 255, 255)
Beige	#F5F5DC	rgb(245, 245, 220)
Bisque	#FFE4C4	rgb(255, 228, 196)
Black	#000000	rgb(0, 0, 0)
BlanchedAlmond	#FFEBCD	rgb(255, 235, 205)
BlueViolet	#8A2BE2	rgb(138, 43, 226)
Brown	#A52A2A	rgb(165, 42, 42)
BurlyWood	#DEB887	rgb(222, 184, 135)
CadetBlue	#5F9EA0	rgb(95, 158, 160)
Chartreuse	#7FFF00	rgb(127, 255, 0)
Chocolate	#D2691E	rgb(210, 105, 30)
Coral	#FF7F50	rgb(255, 127, 80)
CornflowerBlue	#6495ED	rgb(100, 149, 237)
Cornsilk	#FFF8DC	rgb(255, 248, 220)
Crimson	#DC143C	rgb(220, 20, 60)
Cyan	#00FFFF	rgb(0, 255, 255)
DarkBlue	#00008B	rgb(0, 0, 139)
DarkCyan	#008B8B	rgb(0, 139, 139)
DarkGoldenRod	#B8860B	rgb(184, 134, 11)
DarkGray	#A9A9A9	rgb(169, 169, 169)
DarkGreen	#006400	rgb(0, 100, 0)
DarkKhaki	#BDB76B	rgb(189, 183, 107)
DarkMagenta	#8B008B	rgb(139, 0, 139)
DarkOliveGreen	#556B2F	rgb(85, 107, 47)
Darkorange	#FF8C00	rgb(255, 140, 0)
DarkOrchid	#9932CC	rgb(153, 50, 204)
DarkRed	#8B0000	rgb(139, 0, 0)
DarkSalmon	#E9967A	rgb(233, 150, 122)
DarkSeaGreen	#8FBC8F	rgb(143, 188, 143)
DarkSlateBlue	#483D8B	rgb(72, 61, 139)
DarkSlateGray	#2F4F4F	rgb(47, 79, 79)
DarkTurquoise	#00CED1	rgb(0, 206, 209)
DarkViolet	#9400D3	rgb(148, 0, 211)
DeepPink	#FF1493	rgb(255, 20, 147)
DeepSkyBlue	#00BFFF	rgb(0, 191, 255)
DimGray	#696969	rgb(105, 105, 105)
DodgerBlue	#1E90FF	rgb(30, 144, 255)
Feldspar	#D19275	rgb(209, 146, 117)
FireBrick	#B22222	rgb(178, 34, 34)
FloralWhite	#FFFAF0	rgb(255, 250, 240)
ForestGreen	#228B22	rgb(34, 139, 34)
Fuchsia	#FF00FF	rgb(255, 0, 255)
Gainsboro	#DCDCDC	rgb(220, 220, 220)
GhostWhite	#F8F8FF	rgb(248, 248, 255)
Gold	#FFD700	rgb(255, 215, 0)
GoldenRod	#DAA520	rgb(218, 165, 32)
Gray	#808080	rgb(128, 128, 128)
GreenYellow	#ADFF2F	rgb(173, 255, 47)
HoneyDew	#F0FFF0	rgb(240, 255, 240)
HotPink	#FF69B4	rgb(255, 105, 180)
IndianRed	#CD5C5C	rgb(205, 92, 92)
Ivory	#FFFFF0	rgb(255, 255, 240)
Khaki	#F0E68C	rgb(240, 230, 140)
Lavender	#E6E6FA	rgb(230, 230, 250)
LavenderBlush	#FFF0F5	rgb(255, 240, 245)
LawnGreen	#7CFC00	rgb(124, 252, 0)
LemonChiffon	#FFFACD	rgb(255, 250, 205)
LightBlue	#ADD8E6	rgb(173, 216, 230)
LightCoral	#F08080	rgb(240, 128, 128)
LightCyan	#E0FFFF	rgb(224, 255, 255)
LightGoldenRodYellow	#FAFAD2	rgb(250, 250, 210)
LightGrey	#D3D3D3	rgb(211, 211, 211)
LightGreen	#90EE90	rgb(144, 238, 144)
LightPink	#FFB6C1	rgb(255, 182, 193)
LightSalmon	#FFA07A	rgb(255, 160, 122)
LightSeaGreen	#20B2AA	rgb(32, 178, 170)
LightSkyBlue	#87CEFA	rgb(135, 206, 250)
LightSlateBlue	#8470FF	rgb(132, 112, 255)
LightSlateGray	#778899	rgb(119, 136, 153)
LightSteelBlue	#B0C4DE	rgb(176, 196, 222)
LightYellow	#FFFFE0	rgb(255, 255, 224)
Lime	#00FF00	rgb(0, 255, 0)
LimeGreen	#32CD32	rgb(50, 205, 50)
Linen	#FAF0E6	rgb(250, 240, 230)
Magenta	#FF00FF	rgb(255, 0, 255)
Maroon	#800000	rgb(128, 0, 0)
MediumAquaMarine	#66CDAA	rgb(102, 205, 170)
MediumBlue	#0000CD	rgb(0, 0, 205)
MediumOrchid	#BA55D3	rgb(186, 85, 211)
MediumPurple	#9370D8	rgb(147, 112, 216)
MediumSeaGreen	#3CB371	rgb(60, 179, 113)
MediumSlateBlue	#7B68EE	rgb(123, 104, 238)
MediumSpringGreen	#00FA9A	rgb(0, 250, 154)
MediumTurquoise	#48D1CC	rgb(72, 209, 204)
MediumVioletRed	#C71585	rgb(199, 21, 133)
MidnightBlue	#191970	rgb(25, 25, 112)
MintCream	#F5FFFA	rgb(245, 255, 250)
MistyRose	#FFE4E1	rgb(255, 228, 225)
Moccasin	#FFE4B5	rgb(255, 228, 181)
NavajoWhite	#FFDEAD	rgb(255, 222, 173)
Navy	#000080	rgb(0, 0, 128)
OldLace	#FDF5E6	rgb(253, 245, 230)
Olive	#808000	rgb(128, 128, 0)
OliveDrab	#6B8E23	rgb(107, 142, 35)
OrangeRed	#FF4500	rgb(255, 69, 0)
Orchid	#DA70D6	rgb(218, 112, 214)
PaleGoldenRod	#EEE8AA	rgb(238, 232, 170)
PaleGreen	#98FB98	rgb(152, 251, 152)
PaleTurquoise	#AFEEEE	rgb(175, 238, 238)
PaleVioletRed	#D87093	rgb(216, 112, 147)
PapayaWhip	#FFEFD5	rgb(255, 239, 213)
PeachPuff	#FFDAB9	rgb(255, 218, 185)
Peru	#CD853F	rgb(205, 133, 63)
Pink	#FFC0CB	rgb(255, 192, 203)
Plum	#DDA0DD	rgb(221, 160, 221)
PowderBlue	#B0E0E6	rgb(176, 224, 230)
RosyBrown	#BC8F8F	rgb(188, 143, 143)
RoyalBlue	#4169E1	rgb(65, 105, 225)
SaddleBrown	#8B4513	rgb(139, 69, 19)
Salmon	#FA8072	rgb(250, 128, 114)
SandyBrown	#F4A460	rgb(244, 164, 96)
SeaGreen	#2E8B57	rgb(46, 139, 87)
SeaShell	#FFF5EE	rgb(255, 245, 238)
Sienna	#A0522D	rgb(160, 82, 45)
Silver	#C0C0C0	rgb(192, 192, 192)
SkyBlue	#87CEEB	rgb(135, 206, 235)
SlateBlue	#6A5ACD	rgb(106, 90, 205)
SlateGray	#708090	rgb(112, 128, 144)
Snow	#FFFAFA	rgb(255, 250, 250)
SpringGreen	#00FF7F	rgb(0, 255, 127)
SteelBlue	#4682B4	rgb(70, 130, 180)
Tan	#D2B48C	rgb(210, 180, 140)
Teal	#008080	rgb(0, 128, 128)
Thistle	#D8BFD8	rgb(216, 191, 216)
Tomato	#FF6347	rgb(255, 99, 71)
Turquoise	#40E0D0	rgb(64, 224, 208)
Violet	#EE82EE	rgb(238, 130, 238)
VioletRed	#D02090	rgb(208, 32, 144)
Wheat	#F5DEB3	rgb(245, 222, 179)
White	#FFFFFF	rgb(255, 255, 255)
WhiteSmoke	#F5F5F5	rgb(245, 245, 245)
YellowGreen	#9ACD32	rgb(154, 205, 50)

### 2.14 内联框架

使用标签 `<iframe>` 可以实现内联框架，允许你在网页中插入“网页”。

iframe 相当于浏览器中有一个小浏览器，在这个小浏览器中打开另一个网页。

```html
<iframe src="https://how2j.cn/" width="600px" height="400px">
</iframe>
```

### 2.15 一个综合的例子

```html
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
	</head> 
	
  <h2>英雄技能</h2>
  <table border="1" >
    <tr  bgcolor="#ddd">
        <td width="115"><strong>技能名</strong></td>
        <td width="48"><strong>触发</strong></td>
        <td width="98"><strong>技能属性</strong></td>
        <td width="445"><strong>技能效果</strong></td>
        <td width="65">图标</td>
    </tr>
    <tr>
        <td><strong>坚韧</strong></td>
        <td><strong>被动</strong></td>
        <td colspan="2">盖伦如果在9秒内不受到任何伤害，之后的每秒都会回复自己最大生命值的0.4%。小兵的伤害不会中断坚韧效果。</td>
        <td><img src="skill1.png" width="65" height="65" /></td>
    </tr>
    <tr>
      <td><strong>致命打击</strong></td>
      <td><strong>Q</strong></td>
      <td>冷却时间：8</td>
      <td>盖伦移除身上的所有减速效果，并获得30%移动速度加成，持续1.5/2/2.5/3/3.5秒。<br />
      在接下来的4.5秒内，他的下次普通攻击会造成30/55/80/105/130(+1.4AD)物理伤害，并沉默目标1.5秒。</td>
      <td><img src="skill2.png" width="64" height="64" /></td>
    </tr>
    <tr>
      <td><strong>勇气</strong></td>
      <td><strong>W</strong></td>
      <td>冷却：24/23/22/21/20</td>
      <td><strong>被动：</strong>击杀一个单位会永久提供0.25护甲和魔法抗性加成，最大值：30<br />
        <strong>主动：</strong>盖伦获得一个持续2/3/4/5/6秒的防御护盾，减少即将到来的30%伤害。</td>
      <td><img src="skill3.png" width="64" height="65" /></td>
    </tr>
    <tr>
      <td><strong>审判</strong></td>
      <td><strong>E</strong></td>
      <td>冷却：9</td>
      <td>盖伦快速地旋舞大剑，持续3秒，在持续期间对周围敌人总共造成物理伤害——14/18/22/26/30加上他总攻击力的34/35/36/37/38%，5次(英雄每升3级加1次)。<br />
        E【审判】会在攻击单个敌人时造成33%额外伤害。<br />
        取消E【审判】会返还相当于剩余持续时长的冷却时间。<br />
      E【审判】可以暴击，并造成额外伤害。</td>
      <td><img src="skill4.png" width="64" height="64" /></td>
    </tr>
    <tr>
      <td><strong>德玛西亚正义</strong></td>
      <td><strong>R</strong></td>
      <td>冷却：120/100/80</td>
      <td><strong>被动：</strong>最近获得最多击杀数的敌人会成为<strong>大反派</strong>。盖伦的E【审判】和普攻会对<strong>大反派</strong>造成额外真实伤害，伤害值为<strong>大反派</strong>1%的最大生命值。<br />
        <strong>主动：</strong>盖伦召唤德玛西亚之力，试图斩杀一名敌方英雄，目标损失的生命越多，则此技能造成的伤害越高。造成175/350/525魔法伤害加上目标已损失生命值的28/33/40%。对<strong>大反派</strong>造成真实伤害。</td>
      <td><img src="skill5.png" width="64" height="64" /></td>
    </tr>
  </table>
</html>
```



## 3. 单表元素

### 3.1 文本框

`<input type="text">` 表示文本框，并且只能输入一行。

> 如果要输入很多行就需要使用文本域 `<textarea>`
>
> `<input>` 标签很特别，一般是不需要写成 `<input></input>`

#### 3.1.1 设置文本框的长度

```html
<input type="text" size="10">
```

#### 3.1.2 设置文本框的初始值

```html
<input type="text" size="10" value="文本框的初始值">
```

#### 3.1.3 设置文本框的背景

使用属性 placeholder，placeholder 是 html5 的特性

```html
<input type="text" placeholder="请输入账号">
```

### 3.2 密码框

密码框，输入的内容会自动变成星号。

```html
<input type="password">
```

### 3.3 单表

标签 `<form>` 用于向服务器提交数据。

```html
action="/study/login.jsp" <!--表示吧账号数据提交到 login.jsp 这个文件中-->
```

#### 3.3.1 method="get"

使用 `method="get"` 提交数据，是常用的提交数据方式；

- 如果 form 没有提供 method 属性，默认就是 get 方式提交数据；
- get 方式的一个特点就是可以在浏览器的地址栏看到提交的参数，即便是密码也看得到。

```html
<form method="get" action="https://how2j.cn/study/login.jsp">
账号：<input type="text" name="name"> <br/>
密码：<input type="password" name="password" > <br/>
<input type="submit" value="登陆">
</form>
```



#### 3.3.2 method="post"

- 使用 method="post" 提交数据，post 不会在地址栏显示提交的参数。

- 如果提交的二进制数据，比如上传文件，必须采用 post 方式。

```html
<form method="post" action="https://how2j.cn/study/login.jsp">
账号：<input type="text" name="name"> <br/>
密码：<input type="password" name="password" > <br/>
<input type="submit" value="登陆">
</form>
```

#### 3.3.3 get 和 post 的区别

get

- 是 form 的默认提交方式
- 通过一个超链访问某个地址，是 get 方式
- 如果在地址栏直接输入某个地址，是 get 方式
- 提交数据会在浏览器显示出来
- 不可以提交二进制数据，比如文件

post 

- 必须在 form 上通过 method="post" 显示指定；
- 提交数据不会在浏览器显示出来；
- 可以用于提交二进制数据。

### 3.4 单选框

两个单选框，都可以同时选中，为了达到，同一时间只能选中一个的效果，需要使用分组。

```html
单选1 <input type="radio">
单选2 <input type="radio">
```

#### 3.4.1 默认选中

```html
<input type="radio" checked="checked">
```

#### 3.4.2 分组

分组：在一个分组里有多个单选框，同一时间只能选中一个。

```html
<p>今天晚上做什么？</p>

学习java<input type="radio" name="activity" value="学习java" > <br/>
东京热<input type="radio" checked="checked"  name="activity" value="tokyohot" > <br/>
dota<input type="radio" name="activity" value="dota" > <br/>
LOL<input type="radio" name="activity"  value="lol"> <br/>
```

实现分组使用属性 name，name 值相同的单选框即为一组

### 3.5 下拉表

`<select>` 即下拉表，需要配合 `<option>` 一起使用。

```html
<select>
    <option>苍老师</option>
    <option>三上悠亚</option>
    <option>枫可怜</option>
</select>
```

#### 3.5.1 设置高度

```html
<select size="2">
    <option>苍老师</option>
    <option>三上悠亚</option>
    <option>枫可怜</option>
</select>
```

#### 3.5.2 设置可以多选

使用 ctrl 或者 shift

```html
<select size="2" multiple="multiple">
    <option>苍老师</option>
    <option>三上悠亚</option>
    <option>枫可怜</option>
</select>
```

#### 3.5.3 默认选中

```html
<select size="2" mutiple="mutiple">
    <option>苍老师</option>
    <option selected="selected">三上悠亚</option>
    <option selected="selected">枫可怜</option>
</select>
```

### 3.6 文本域

`<textarea>` 表示文本域，可以输入多行文本，并且可以有滚动条。

```html
<textarea>
    qwer
    asdf
    zxcv
</textarea>
```

#### 3.6.1 设置宽度和行数

使用属性 cols 和 rows

```html
<textarea cols="40" rows="10">
    12345678901223344556778901
    1122334566778889995321156a
    asgdjhiugsjslosaiuhwsdjdxhsdiu
    asdf
    zxcv
</textarea>
```

### 3.7 按钮

```html
<input type="button" value="一个按钮">
```

示例

```html
普通按钮不能提交
<form action="/study/login.jsp" method="get">
账号：<input type="text" name="name"> <br/>
密码：<input type="password" name="password" > <br/>
<input type="button" value="登陆">
</form>
```

### 3.8 提交按钮

```html
<input type="submit">
```

提交按钮用于提交 form ,把数据提交到服务端。

```html
<form action="/study/login.jsp" method="get">
账号:<input type="text" name="name"><br/>
密码:<input type="password" name="password"><br/>
<input type="submit" value="登录">
</form>
```

### 3.9 重置按钮

`<input type="reset">`重置按钮可以把输入框的改动复原。

```html
<form action="/study/login.jsp" method="get">
    账号:<input type="text" name="name"><br/>
    密码:<input type="password" name="password"><br/>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
```

### 3.10 图像提交

设置 src 属性

```html
<form action="/study/login.jsp" method="get">
账号：<input type="text" name="name"> <br/>
密码：<input type="password" name="password" > <br/>
<input type="submit" value="登陆">
</form>
```

 login.jsp

```javascript
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	
%>

您提交的账号名是 :<%=name%> <br/>
您提交的密码是 :<%=password%>
<br>
<a href="javascript:history.back()">返回</a>
```

### 3.11 按钮

`<button></button>` 即按钮标签与 `<input type="button">` 不同的是，`<button>` 标签功能更加丰富。

- 标签的内容可以是文字也可以是图像。

- 如果 button 的属性 type="submit" 那么它也具有提交 foem 的功能。

#### 3.11.1 按钮中是文字

```html
<button>按钮</button>
```

#### 3.11.2 按钮中是图像

```html
<button><img src="https://how2j.cn/example.gif"></button>
```

#### 3.11.3 提交数据

```html
<form action="study/login/login.jsp">
    账号:<input type="text" name="name"><br/>
    密码:<input type="pssword" name="password"></br>
<button type="submit">按钮</button>
</form>
```

### 3.12 一个综合的例子

```html
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
	</head> 
	<body>
		
		
		<table width="100%" >
  <tr>
    <td align="right"><font color="#FF0000">*</font>用户名:</td>
    <td><input type="text" size="30"/> <font color="red">用户名不得小于3个字符</font></td>
  </tr>
  <tr>
    <td align="right"><font color="#FF0000">*</font>密码:</td>
    <td><input name="text" type="text" size="30"/></td>
  </tr>
  <tr>
    <td align="right"><font color="#FF0000">*</font>确认密码:</td>
    <td><input name="text2" type="text" size="30"/></td>
  </tr>
  <tr>
    <td align="right"><font color="#FF0000">*</font>Email:</td>
    <td><input name="text3" type="text" size="30"/></td>
  </tr>
  <tr>
    <td align="right"><font color="#FF0000">*</font>真实姓名:</td>
    <td><input name="text4" type="text" size="30"/></td>
  </tr>
  <tr>
    <td align="right"><font color="#FF0000">*</font>性别:</td>
    <td>
		<select>
			<option>男</option>
			<option>女</option>			
		</select>
	</td>
  </tr>
  <tr>
    <td align="right"><font color="#FF0000">*</font>生日:</td>
    <td><select name="select">
      <option>1980</option>
      <option>1981</option>
      <option>1982</option>
      <option>1983</option>
      <option>1984</option>
      <option>1985</option>
      <option>1986</option>
      <option>1987</option>
      <option>1988</option>
      <option>1989</option>
      <option>1990</option>
      <option>1991</option>	  	  	  	  	  	  	  	  
    </select>
      <select name="select2">
        <option>1</option>
        <option>2</option>
        <option>...</option>
        <option>12</option>				
      </select>
      <select name="select3">
        <option>1</option>
        <option>2</option>
        <option>...</option>
        <option>31</option>						
      </select></td>
  </tr>
  <tr>
    <td align="right"><font color="#FF0000">*</font>手机:</td>
    <td><input name="text7" type="text" size="30"/></td>
  </tr>
  <tr>
    <td align="right"><font color="#FF0000">*</font>居住地:</td>
    <td><select name="select4">
      <option>四川省</option>
      <option>河南省</option>
      <option>广东省</option>
      <option>河北省</option>
      <option>黑龙江省</option>
      <option>海南省</option>
      <option>安徽省</option>
      <option>内蒙古省</option>
      <option>广西省</option>
      <option>湖南省</option>
      <option>湖北省</option>
      <option>浙江省</option>
    </select>
      <select name="select5">
        <option>成都市</option>
        <option>重庆市</option>
        <option>...</option>
        <option>北京市</option>
      </select> <select name="select6">
        <option>成华区</option>
        <option>龙泉驿区</option>
        <option>...</option>
        <option>金牛区</option>
      </select> <select name="select7">
        <option>三圣乡</option>
        <option>星辉路</option>
        <option>...</option>
        <option>蜀都大道</option>
      </select></td>
  </tr>
  <tr>
    <td align="right"><font color="#FF0000">*</font>QQ:</td>
    <td><input name="text9" type="text" size="30"/>
	<br />
		<font size="-1" color="#0099FF">设置我的QQ在线状态</font>
	</td>
  </tr>
</table>

		
	</body>
</html>
```

