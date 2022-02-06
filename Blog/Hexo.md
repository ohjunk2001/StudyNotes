# Hexo

安装 Node.js ，版本尽量选高版本。

> https://nodejs.org

安装 Nginx

```bash
$ apt-get install nginx
$ sudo apt autoremove
```



安装 Hexo

```bash
npm install -g hexo-cli
hexo init

如果
/home/ubuntu/.nvm/versions/node/v14.12.0/lib/node_modules/hexo-cli/lib/console

```





安装主题

```bash
npm install hexo-renderer-pug --save
npm install hexo-renderer-sass --save
 https://github.com/sass/node-sass/releases/download/v4.14.1/linux-x64-83_binding.node
git clone https://gitee.com/hd2098101/hexo-theme-book.git themes/book
```

```bash
解决方法：
1、首先安装淘宝镜像

$ npm install -g cnpm --registry=https://registry.npm.taobao.org
2、 用cnpm重新安装一次

cnpm install node-sass --save-dev

cnpm install sass-loader --save-dev

这样就可以把问题解决了（^_^）
```

```bash
# 左侧目录
* [Home](/hexo-theme-book-demo)
* [Changelog](/hexo-theme-book-demo/changelog)

# Test

## hexo-unit-test

* [Categories](/hexo-theme-book-demo/test/hexo-unit-test/categories)
* [Elements](/hexo-theme-book-demo/test/hexo-unit-test/elements)
* [Excerpts](/hexo-theme-book-demo/test/hexo-unit-test/excerpts)
* [Gallery Post](/hexo-theme-book-demo/test/hexo-unit-test/gallery-post)
* [Hello World](/hexo-theme-book-demo/test/hexo-unit-test/hello-world)
* [Images](/hexo-theme-book-demo/test/hexo-unit-test/images)
* [Untitled](/hexo-theme-book-demo/test/hexo-unit-test/link-post-without-title)
* [Link Post](/hexo-theme-book-demo/test/hexo-unit-test/link-post)
* [Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam justo turpis, tincidunt ac convallis id.](/hexo-theme-book-demo/test/hexo-unit-test/long-title)
* [Untitled](/hexo-theme-book-demo/test/hexo-unit-test/no-title)
* [Tag Plugins](/hexo-theme-book-demo/test/hexo-unit-test/tag-plugins)
* [Tags](/hexo-theme-book-demo/test/hexo-unit-test/tags)
* [Videos](/hexo-theme-book-demo/test/hexo-unit-test/videos)
* [中文測試](/hexo-theme-book-demo/test/hexo-unit-test/中文測試)
* [日本語テスト](/hexo-theme-book-demo/test/hexo-unit-test/日本語テスト)

## bugfix

* [list test](/hexo-theme-book-demo/test/bugfix/list-test)
* [blockquote position](/hexo-theme-book-demo/test/bugfix/blockquote-position)
* [checkbox list](/hexo-theme-book-demo/test/bugfix/checkbox-list)

## lots of post in submenu 

* .
* Fix bug:
* .
* The default setting of spectre.css's accordion 
* is `max-height: 50rem`
* .
* Override the value to `max-height: unset` in this theme
* .
* Fix in [ce5be1d](https://github.com/kaiiiz/hexo-theme-book/commit/ce5be1d7500722b8bcdc367fc79186c0cfe8ac56)
* .
* Test 11
* Test 12
* Test 13
* Test 14
* Test 15
* Test 16
* Test 17
* Test 18
* Test 19
* Test 20
* Test 21
* Test 22
* Test 23
* Test 24
* Test 25
* Test 26
* Test 27
* Test 28
* Test 29
* Test 30
* Test 31
* Test 32
* Test 33
* Test 34
* Test 35

# Demo

* [Menu Realtime Demo](/hexo-theme-book-demo/demo/menu-realtime)

## Render

* [markdown-it demo](/hexo-theme-book-demo/demo/render/markdown-it-demo)
* [katex demo](/hexo-theme-book-demo/demo/render/katex-demo)
* [footnotes demo](/hexo-theme-book-demo/demo/render/footnotes-demo)
* [markdown-container](/hexo-theme-book-demo/demo/render/md-container)

## Lorem Ipsum

* [English](/hexo-theme-book-demo/demo/lorem-ipsum/en-demo)
* [Japanese](/hexo-theme-book-demo/demo/lorem-ipsum/jp-demo)
* [Korean](/hexo-theme-book-demo/demo/lorem-ipsum/kr-demo)
* [Traditional Chinese](/hexo-theme-book-demo/demo/lorem-ipsum/tc-demo)
* [Simplified Chinese](/hexo-theme-book-demo/demo/lorem-ipsum/sc-demo)
```

