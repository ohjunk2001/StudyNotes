# Hexo

Hexo 部署到自己的服务器设置自己的域名。

https://wiki.zthxxx.me/wiki/%E6%8A%80%E6%9C%AF%E5%BC%80%E5%8F%91/Linux/Vim/Vim-%E7%B2%98%E8%B4%B4%E6%A8%A1%E5%BC%8F/

## 服务器上的准备工作

服务器系统 Centos 7.6

### 安装 Nginx 、Git

```bash
yum install -y nginx
yum install -y git
```

### 添加一个 Git 用户

```bash
useradd git
passwd git

# 给git用户配置sudo权限
chmod 740 /etc/sudoers
vim /etc/sudoers
# 找到root ALL=(ALL) ALL，在它下方加入一行
git ALL=(ALL) ALL

chmod 400 /etc/sudoers
```

### 添加 ssh 密钥

```bash
su - git
mkdir -p ~/.ssh
touch ~/.ssh/authorized_keys
chmod 600 ~/.ssh/authorized_keys 
chmod 700 ~/.ssh
vim ~/.ssh/authorized_keys    #将ssh公钥粘贴进去,这个公钥就是你本地电脑上 github 的公钥
# 测试 ssh 链接
ssh -v git@42.193.120.165
```

### 创建 Git 仓库

切换到 root 用户

```bash
sudo mkdir -p /var/repo    #新建目录，这是git仓库的位置
sudo mkdir -p /var/www/hexo
cd /var/repo  #转到git仓库的文件夹
sudo git init --bare blog.git #创建一个名叫blog的仓库
sudo vim /var/repo/blog.git/hooks/post-update
```

post-update 内容如下

```bash
#!/bin/bash
git --work-tree=/var/www/hexo --git-dir=/var/repo/blog.git checkout -f
```

给 post-update 授权

```bash
cd /var/repo/blog.git/hooks/
sudo chown -R git:git /var/repo/
sudo chown -R git:git /var/www/hexo
sudo chmod +x post-update  #赋予其可执行权限
```

### 配置 nginx

```bash
cd /etc/nginx/conf.d/
sudo vim blog.conf
```

blog.conf 内容

```bash
server {
    listen    80 default_server;
    listen    [::] default_server;
    server_name    yanghao-blog.com;
    root    /var/www/hexo;
}
```

检查Nginx语法并重载nginx：

```bash
nginx -t
nginx -s reload
```

设置本地站点的 _config.yml

```yml
deploy:
  type: git
  repo: git@yanghao-blog.com:/var/repo/blog.git # IP填写自己服务器的IP即可
  branch: master
```



```bash


# 清除缓存
hexo clean

# 生成静态页面
hexo g

# 将本地静态页面目录部署到云服务器
hexo d
```

## 本地 Hexo 配置

### 安装 Hexo 和插件

```powershell
npm install hexo-cli hexo-server hexo-deployer-git -g
```

创建一个空文件夹 hexo-test

```powershell
hexo init hexo-test
cd hexo-test
npm install hexo-deployer-git --save
```

### 安装主题

```bash
cd hexo-test
git clone https://gitee.com/hd2098101/hexo-theme-Wikitten.git themes/Wikitten
```

#### 安装主题相关插件

```powershell
npm i -S hexo-autonofollow hexo-directory-category hexo-generator-feed hexo-generator-json-content hexo-generator-sitemap

hexo-autonofollow       // 打开非本站链接时自动开启新标签页
hexo-directory-category // 根据文章文件目录自动为文章添加分类
hexo-generator-feed     // 生成 RSS 源
hexo-generator-json-content // 生成全站文章 json 内容，用于全文搜索
hexo-generator-sitemap  // 生成全站站点地图 sitemap
```

#### 主题配置

##### 创建主题配置文件

```
# git clone 下的文件只有 _config.yml.example 
# 去掉后缀名就是配置文件 _config.yml
```

##### 配置mathjax渲染

如果你在博客中需要撰写数学公式，进行一下操作

```bash
npm un hexo-renderer-marked --save # 卸载自带的渲染器
npm install hexo-renderer-kramed --save # 安装新渲染器

# 把下面的内容添加到站点配置文件 _config.yml 中
math:
  enable: true
  engine: mathjax
```

因为 hexo-renderer-kramed 渲染器的缺陷，我们需要修改一个文件

```bash
vim node_modules\kramed\lib\rules\inline.js

# 把原本两行代码注释掉，换新的代码上去

//  escape: /^\\([\\`*{}\[\]()#$+\-.!_>])/,
  escape: /^\\([`*\[\]()#$+\-.!_>])/,

//  em: /^\b_((?:__|[\s\S])+?)_\b|^\*((?:\*\*|[\s\S])+?)\*(?!\*)/,
  em: /^\*((?:\*\*|[\s\S])+?)\*(?!\*)/,
```

##### 代码高亮

默认的是 monokai ，你可以自己选择，打开 

```
cd themes\Wikitten\source\css\_highlight 
# 这个文件下的是各种不同的代码风格，选择一个你认为好看的
```

其他的代码风格可以从[highlight.js/src/styles](https://github.com/highlightjs/highlight.js/tree/9.18.1/src/styles)中下载。 然后，复制文件名(不带`.css`后缀)到`theme`设置项中。

如要隐藏复制代码按钮，将`clipboard`设置为`false`。 如果你希望折叠或展开所有代码块，将`fold`设置为`"folded"`或`"unfolded"`。 你也可以将`fold`设置为空来禁止代码块折叠。

##### 主题最终的配置文件

```yml
# Menus
menu:
  首页: /
  归档: /archives
  分类: /categories
  标签: /tags
  关于: /about

# Customize
customize:
    logo:
        enabled: true
        width: 40
        height: 40
        url: /logo.png
    profile: # 右边出现一个页面显示下面信息，实在多余，关了
        enabled: false # Whether to show profile bar
        avatar: # css/images/avatar.png
        gravatar: tool2020@qq.com # Gravatar email address, if you enable Gravatar, your avatar config will be overriden
        author: yanghao
        author_title: Writer & Programmer
        location: Tianjin, China
        follow: https://github.com/yanghao9617/
    highlight: solarized-dark
    sidebar: left # sidebar position, options: left, right
    category_perExpand: false # enable article categories list per expanding
    thumbnail: true # enable posts thumbnail, options: true, false
    favicon: /favicon.ico # path to favicon
    default_index_file: index.md # if this, it will display at site index instead of default index page
    social_links: # 一些个人主页链接
        github: https://github.com/yanghao9617
        #stack-overflow: http://stackoverflow.com/users/7277090/zthxxx?tab=profile
        #codepen: http://codepen.io/zthxxx/
        #rss: /atom.xml
    social_link_tooltip: true # enable the social link tooltip, options: true, false

# Widgets
widgets: # default use category only
    - category
    # - recent_posts
    # - archive
    # - tag
    # - tagcloud
    # - links
    
# Excerpt 
## Auto creat excerpt with not <!--more-->
## Enable will truncate auto_excerpt.lines rows in post head to replace excerpt.
auto_excerpt:
    enable: true
    lines: 5

# Search
search:
    insight: true # you need to install `hexo-generator-json-content` before using Insight Search
    swiftype: # enter swiftype install key here
    baidu: false # you need to disable other search engines to use Baidu search, options: true, false

# History version 使你的博客可以看到源码，版本控制
history_control: # make you wiki has history version control in page
    enable: true
    server_link:  # recommend use GitHub https://github.com
    user: git
    repertory: Wiki-site
    branch: writing

# Comment
comment:
    disqus: # enter disqus shortname here
    duoshuo: # enter duoshuo shortname here
    youyan: # enter youyan uid here

# Share
share: default # options: jiathis, bdshare, addtoany, default

# Plugins
plugins:
    lightgallery: true # options: true, false
    justifiedgallery: true # options: true, false
    mathjax: true # options: true, false - to enable use Mathjax in your article
    google_analytics: # enter the tracking ID for your Google Analytics
    google_site_verification: # enter Google site verification code
    baidu_analytics: # enter Baidu Analytics hash key
    busuanzi_count: false # options: true, false - to enable busuanzi site pv statistics # 统计浏览人数没什么用，关了

# Miscellaneous
miscellaneous:
    open_graph: # see http://ogp.me
        fb_app_id:
        fb_admins:
        twitter_id:
        google_plus:
    links:
```



### 站点的配置文件

### 替换文件

```
# 复制主题文件里的两个文件夹到指定文件夹，不用 Hexo 的默认文件
themes/Wikitten/_source/ -> source/
themes/Wikitten/_scaffolds/ -> scaffolds/
```

### 最终的站点配置文件

```bash
# Hexo Configuration
## Docs: https://hexo.io/docs/configuration.html
## Source: https://github.com/hexojs/hexo/

# Site
title: Hexo
subtitle: ''
description: ''
keywords:
author: Yang Hao
language: zh-CN
timezone: 'Asia/Shanghai'

# URL
## Set your site url here. For example, if you use GitHub Page, set url as 'https://username.github.io/project'
url: http://yanghao-blog.com
permalink: notes/:title/ # 这里可以再研究研究
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
  - README.md
  - '_posts/**/embed_page/**'

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
theme: Wikitten

## Markdown
## https://github.com/hexojs/hexo-renderer-marked
marked:
  gfm: true

# 数学公式渲染
math:
  enable: true
  engine: mathjax

## Plugins: https://hexo.io/plugins/
### JsonContent
jsonContent:
  meta: false
  pages:
    title: true
    date: true
    path: true
    text: true
  posts:
    title: true
    date: true
    path: true
    text: true
    tags: true
    categories: true
  ignore:
    - 404.html
    
### Creat sitemap
sitemap:
  path: sitemap.xml

### Adds nofollow attribute to all external links in your hexo blog posts automatically.
nofollow:
  enable: true
  exclude:
    - <your site url domain> # eg: zthxxx.me

deploy:
  type: git
  repo: git@yanghao-blog.com:/var/repo/blog.git # IP填写自己服务器的IP即可
  branch: master

```



## 文章的格式

````bash
---
title: Git commit message 基本规范
date: 2017-01-23 04:14:54
tags: [Git]
---


# 首页
---
title: Welcome Zthxxx's Wiki Site
date: 2017-01-22 01:55:57
banner:
tags:
categories:
---

---
title: DISC 行为风格理论
toc: true
tags: [生活学习, DISC]
date: 2017-02-16 12:56:24
---

````

## 文章发布

```
hexo s 本地运行
hexo g 生成静态文件
hexo g --watch 
hexo d

systemctl status nginx
systemctl start nginx
systemctl stop nginx
systemctl restart nginx
```





