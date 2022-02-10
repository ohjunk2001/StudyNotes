# Hexo

## 准备工作

- 云服务器安装 Node.js ，版本尽量选高版本。

> https://nodejs.org

- 云服务器安装 Nginx

```bash
yum install -y nginx

```

## 安装 Hexo

```bash
npm install  hexo-cli -g
hexo init yanghao-blog.com
```

安装主题

```bash
cd yanghao-blog.com

wget https://github.com/sass/node-sass/releases/download/v4.14.1/linux-x64-83_binding.node # 预先下载好这个
npm install hexo-renderer-scss --save

就是说 npm 出于安全考虑不支持以 root 用户运行，即使你用 root 用户身份运行了，npm 会自动转成一个叫 nobody 的用户来运行，而这个用户几乎没有任何权限。这样的话如果你脚本里有一些需要权限的操作，比如写文件（尤其是写 /root/.node-gyp），就会崩掉了。

为了避免这种情况，要么按照 npm 的规矩来，专门建一个用于运行 npm 的高权限用户；要么加 --unsafe-perm 参数，这样就不会切换到 nobody 上，运行时是哪个用户就是哪个用户，即使是 root。


npm install hexo-renderer-pug --save

 
npm uninstall hexo-renderer-marked --save

npm install hexo-renderer-markdown-it --save
npm install markdown-it-abbr --save
npm install markdown-it-container --save
npm install markdown-it-deflist --save
npm install markdown-it-emoji --save
npm install markdown-it-footnote --save
npm install markdown-it-imsize --save
npm install markdown-it-ins --save
npm install markdown-it-mark --save
npm install markdown-it-regexp --save
npm install markdown-it-sub --save
npm install markdown-it-sup --save
npm install markdown-it-checkbox --save
npm install @iktakahiro/markdown-it-katex
 
git clone https://gitee.com/hd2098101/hexo-theme-book.git book
```

```bash
解决方法：
1、首先安装淘宝镜像

$ npm install -g cnpm --registry=https://registry.npm.taobao.org
2、 用cnpm重新安装一次

cnpm install node-sass --save-dev

cnpm install sass-loader --save-dev

$ npm install -g cnpm --registry=https://registry.npm.taobao.org
$ npm config set registry https://registry.npm.taobao.org



```

```bash
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

```markdown
home.md

# 杨浩的的笔记

## 目录

- Java
  - JDK
  - Test1
- Python
  - 数据结构与算法
- 高数
```

muen.md

```markdown
# Test
## JDK
* [1.1.数组](/Notes/Test/JDK/1.1.数组)
```

```json
# Hexo Configuration
## Docs: https://hexo.io/docs/configuration.html
## Source: https://github.com/hexojs/hexo/

# Site
title: Notes
subtitle: ''
description: ''
keywords:
author: Yang Hao
language: zh-CN
timezone: 'Shanghai'

# URL
## Set your site url here. For example, if you use GitHub Page, set url as 'https://username.github.io/project'
url: http://example.com
permalink: :year/:month/:day/:title/
permalink_defaults:
pretty_urls:
  trailing_index: true # Set to false to remove trailing 'index.html' from permalinks
  trailing_html: true # Set to false to remove trailing '.html' from permalinks

# Directory
source_dir: source
public_dir: public
tag_dir: tags
archive_dir: archives
category_dir: categories
code_dir: downloads/code
i18n_dir: :lang
skip_render:

# Writing
new_post_name: :title.md # File name of new posts
default_layout: post
titlecase: false # Transform title into titlecase
external_link:
  enable: true # Open external links in new tab
  field: site # Apply to the whole site
  exclude: ''
filename_case: 0
render_drafts: false
post_asset_folder: false
relative_link: false
future: true
highlight:
  enable: true
  line_number: true
  auto_detect: false
  tab_replace: ''
  wrap: true
  hljs: false
prismjs:
  enable: false
  preprocess: true
  line_number: true
  tab_replace: ''

# Home page setting
# path: Root path for your blogs index page. (default = '')
# per_page: Posts displayed per page. (0 = disable pagination)
# order_by: Posts order. (Order by date descending by default)
index_generator:
  path: ''
  per_page: 10
  order_by: -date

# Category & Tag
default_category: uncategorized
category_map:
tag_map:

# Metadata elements
## https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta
meta_generator: true

# Date / Time format
## Hexo uses Moment.js to parse and display date
## You can customize the date format as defined in
## http://momentjs.com/docs/#/displaying/format/
date_format: YYYY-MM-DD
time_format: HH:mm:ss
## updated_option supports 'mtime', 'date', 'empty'
updated_option: 'mtime'

# Pagination
## Set per_page to 0 to disable pagination
per_page: 10
pagination_dir: page

# Include / Exclude file(s)
## include:/exclude: options only apply to the 'source/' folder
include:
exclude:
ignore:

# Extensions
## Plugins: https://hexo.io/plugins/
## Themes: https://hexo.io/themes/
theme: book

# Deployment
## Docs: https://hexo.io/docs/one-command-deployment
deploy:
  type: ''
# 主题设置
markdown:
  render:
    html: true # Doesn't escape HTML content so the tags will appear as html.
    xhtmlOut: false # Parser will not produce XHTML compliant code.
    breaks: true # Parser produces `<br>` tags every time there is a line break in the source document.
    linkify: true # Returns text links as text.
    typographer: true # Substitution of common typographical elements will take place.
    quotes: '“”‘’' # "double" will be turned into “single”
                   # 'single' will be turned into ‘single’
  plugins:
    - markdown-it-abbr
    - markdown-it-container
    - markdown-it-deflist
    - markdown-it-emoji
    - markdown-it-footnote
    - markdown-it-imsize
    - markdown-it-ins
    - markdown-it-mark
    - markdown-it-regexp
    - markdown-it-sub
    - markdown-it-sup
    - markdown-it-checkbox
    - '@iktakahiro/markdown-it-katex'
  anchors:
    # Minimum level for ID creation. (Ex. h2 to h6)
    level: 1
    # A suffix that is prepended to the number given if the ID is repeated.
    collisionSuffix: 'v'
    # If `true`, creates an anchor tag with a permalink besides the heading.
    permalink: false
    # Class used for the permalink anchor tag.
    permalinkClass: header-anchor
    # The symbol used to make the permalink
    permalinkSymbol: '# '

```

config.yml

```yaml
home_page: Notes/home.md        # filepath under /source/
menu_page: Notes/menu.md        # filepath under /source/
author_img:               # filepath of author image
favicon_url: favicon.png  # filepath of favicon

zoom_image: true
codeblock:
  # Code Highlight theme
  # Available values: normal | night | night eighties | night blue | night bright | solarized | solarized dark | galactic
  highlight_theme: night

comments:
  utterances:
    enable: false
    user: # your github user name
    repo: # your github repo name
    theme: github-light # github-light | github-dark | github-dark-orange | icy-dark | dark-blue | photon-dark
  disqus:
    enable: false
    shortname: # your disqus shortname
  gitalk:
    enable: false
    githubID: # your github id
    repo: # GitHub repository e.g. kaiiiz.github.io
    ClientID: # GitHub Application Client ID
    ClientSecret: # GitHub Application Client Secret
    adminUser: # GitHub repository owner and collaborators
    labels: 'gitalk' # GitHub issue labels
    distractionFreeMode: true

google_analytics: # UA-XXXXX-Y
```

设置

```json
ubuntu@VM-0-2-ubuntu:~/yanghao/themes/book/source$ tree
.
├── css
│   ├── _components
│   │   ├── brand.scss
│   │   ├── comments.scss
│   │   ├── highlight
│   │   │   ├── diff.scss
│   │   │   ├── highlight.scss
│   │   │   └── theme.scss
│   │   ├── menu.scss
│   │   ├── post-meta.scss
│   │   ├── post.scss
│   │   ├── sidebar-toggle.scss
│   │   └── toc.scss
│   ├── _partials
│   │   ├── book-archive.scss
│   │   ├── book-content.scss
│   │   ├── book-navbar.scss
│   │   └── book-sidebar.scss
│   ├── _variables.scss
│   └── book.scss
├── favicon.png
└── js
    ├── book-menu.js
    ├── book-post.js
    ├── book-toc.js
    └── book.js

@import "variables";

.book-container {
  width: 103%;
  height: 100%;
}

html {
  margin: 0;
  height: 100%;
  font-size: $font-size-base;
}

// 字体大小
body {
  font-size: $font-size-smaller; 
}

a {
  color: $book-link-color;
}

a:visited {
  color: $book-link-visited-color;
}

a:hover {
  color: $book-link-hover-color;
  text-decoration: none;
}

img {
  max-width: 100%;
  max-height: 100%;
}

.right {
  text-align: right;
}

.left {
  text-align: left;
}

.off-canvas-overlay {
  background: rgba(0, 0, 0, 0.2);
  position: fixed;
  display: none;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 499;

  &.show {
    display: block;
  }

  @media all and (min-width: $pc-media) {
    display: none !important;
  }
}

.off-canvas-content {
  height: 100%;
  font-family: $content-font-family;
  transition: margin 200ms;

  @import "_partials/book-content";

  &.extend {
    margin-left: 0;
  }

  @media all and (min-width: $pc-media) {
    margin-left: $sidebar-width;
    padding: $content-padding-xl $content-padding-xl;
  }

  @media all and (min-width: $pad-media) and (max-width: $pcs-media) {
    padding: $content-padding-xl $content-padding-lg;
  }

  @media all and (max-width: $pads-media) {
    padding: $content-padding-xl $content-padding-md;
  }
}

@import "_partials/book-navbar";
@import "_partials/book-sidebar";
@import "_partials/book-archive";

```

## Nginx 设置

```bash
$ sudo vim /etc/nginx/nginx.conf

# For more information on configuration, see:
#   * Official English Documentation: http://nginx.org/en/docs/
#   * Official Russian Documentation: http://nginx.org/ru/docs/

user root; # 这里需要修改
worker_processes auto;
error_log /var/log/nginx/error.log;
pid /run/nginx.pid;

# Load dynamic modules. See /usr/share/doc/nginx/README.dynamic.
include /usr/share/nginx/modules/*.conf;

events {
    worker_connections 1024;
}

http {
    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;

    sendfile            on;
    tcp_nopush          on;
    tcp_nodelay         on;
    keepalive_timeout   65;
    types_hash_max_size 4096;

    include             /etc/nginx/mime.types;
    default_type        application/octet-stream;

    # Load modular configuration files from the /etc/nginx/conf.d directory.
    # See http://nginx.org/en/docs/ngx_core_module.html#include
    # for more information.
    include /etc/nginx/conf.d/*.conf;

    server {
        listen       80;
        listen       [::]:80;
        server_name  yanghao-blog.com; # 根据你的域名情况修改，不清楚的去谷歌
        root         /root/Hexo/yanghao-blog.com/public; # 这里需要修改，改成博客的面板

        # Load configuration files for the default server block.
        include /etc/nginx/default.d/*.conf;

        error_page 404 /404.html;
        location = /404.html {
        }

        error_page 500 502 503 504 /50x.html;
        location = /50x.html {
        }
    }

# Settings for a TLS enabled server.
#
#    server {
#        listen       443 ssl http2;
#        listen       [::]:443 ssl http2;
#        server_name  _;
#        root         /usr/share/nginx/html;
#
#        ssl_certificate "/etc/pki/nginx/server.crt";
#        ssl_certificate_key "/etc/pki/nginx/private/server.key";
#        ssl_session_cache shared:SSL:1m;
#        ssl_session_timeout  10m;
#        ssl_ciphers HIGH:!aNULL:!MD5;
#        ssl_prefer_server_ciphers on;
#
#        # Load configuration files for the default server block.
#        include /etc/nginx/default.d/*.conf;
#
#        error_page 404 /404.html;
#            location = /40x.html {
#        }
#
#        error_page 500 502 503 504 /50x.html;
#            location = /50x.html {
#        }
#    }

}

sudo chmod 777 dirname -R

systemctl start nginx
```

