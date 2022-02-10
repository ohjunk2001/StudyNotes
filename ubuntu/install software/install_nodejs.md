# 安装 Nodejs

https://cloud.tencent.com/document/product/213/38237

https://jingyan.baidu.com/article/6181c3e080f979152ef15387.html

- 系统 Centos 7.6

## 安装 nodejs 二进制包

```bash
# 下载二进制包并解压
$ wget https://mirrors.tuna.tsinghua.edu.cn/nodejs-release/v14.9.0/node-v14.9.0-linux-x64.tar.xz
$ tar xvf node-v14.9.0-linux-x64.tar.xz

# 将解压后的目录改名为 node 并移动到 /usr/local 目录下
$ sudo mv node-v14.9.0-linux-x64/bin/node ./node
$ sudo mv node /usr/local

# 给 node 目录赋予权限

$ sudo chmod 755 -R ./node/*

# 在 node/bin 目录下验证版本信息
$ ./npm -v
$ ./node -v

# 添加 node 的环境变量

$ vim ~/.bashrc

export NODE=/usr/local/node
export PATH=${NODE}/bin:$PATH

$ source ~/.bashrc

# 给 npm 换个源
$ npm config set registry=http://registry.npm.taobao.org


```



## 通过 nvm 安装 nodejs

```bash
# 通过 nvm 安装 nodejs

# 安装 nvm

$ git clone git://github.com/cnpm/nvm.git ~/.nvm && cd ~/.nvm && git checkout `git describe --abbrev=0 --tags`

# 修改 .nvm 下的 nvm.sh 
# Setup mirror location if not already set
if [ -z "$NVM_NODEJS_ORG_MIRROR" ]; then
  export NVM_NODEJS_ORG_MIRROR="https://mirrors.tuna.tsinghua.edu.cn/nodejs-release/"
fi

if [ -z "$NVM_IOJS_ORG_MIRROR" ]; then
  export NVM_IOJS_ORG_MIRROR="http://npm.taobao.org/mirrors/iojs"
fi
if [ -z "$NVM_IOJS_ORG_VERSION_LISTING" ]; then
  export NVM_IOJS_ORG_VERSION_LISTING="$NVM_IOJS_ORG_MIRROR/index.tab"
fi

# 添加环境变量
$ echo "source ~/.nvm/nvm.sh" >> /etc/profile
$ vim /etc/profile 
$ source /etc/profile


nvm list-remote # 列出可以安装的 nodejs 版本

nvm install v16.13.1 # 安装 v16.13.1 版本的 nodejs
nvm install v14.12.0 # 安装 v14.12.0 版本的 nodejs

nvm use v14.12.0 # 使用 v14.12.0 版本的 nodejs

nvm ls # 显示已经安装的 nodejs 和正在使用的 nodejs

->     v14.12.0
       v16.13.1
stable -> 14.12 (-> v14.12.0) (default)
unstable -> 16.13 (-> v16.13.1) (default)


/home/ubuntu/.nvm/versions/node/v14.12.0/lib/node_modules/hexo-cli/lib/console

wget https://mirrors.tuna.tsinghua.edu.cn/nodejs-release/v14.9.0/node-v14.9.0-linux-x64.tar.xz

```

使用 `nvm` 时，默认的 `prefix` 是当前激活的 Node.js 版本的安装路径。

带来一个问题是：切换版本之后，之前安装全局命令模块需要重新安装，非常不方便。

解决方案是配置统一的全局模块安装路径。

新建`npm_global`和`npm_cache`文件夹，分别用于npm包的全局安装路径和全局cache路径

### npm 查看各种全局路径的命令

- **查看当前npm包的全局安装路径**

```shell
npm prefix -g 
复制代码
```

- **查看当前npm包的全局cache路径**

```shell
npm config get cache
复制代码
```

- **查看配置列表**

```shell
npm config ls
复制代码
```

- **查看配置列表的全部信息**

```shell
npm config ls -l
复制代码
```

**【注】每次使用nvm切换node版本，最好都查看一下npm全局配置路径是否失效**

### npm 修改全局路径命令

- **修改npm的包的全局安装路径**

```shell
npm config set prefix "E:\NodeJs\npm\npm_global"
复制代码
```

- **修改npm的包的全局cache位置**

```shell
npm config set cache "E:\NodeJs\npm\npm_cache"
复制代码
```

### 配置环境变量

将`npm`包全局安装路径配置在环境变量中

此电脑 -> 属性 -> 高级系统设置 -> 环境变量 -> 系统变量 -> path ->编辑 - > 新增路径 -`E:\NodeJs\npm\npm_global`（路径可以根据npm prefix -g查看）

## yarn 管理

- **安装yarn**

```shell
npm install yarn -g
yarn -v
复制代码
```

**【注】如果首次安装`yarn`后，运行`yarn -v`不能显示`yarn`的版本，可以重启一下终端再尝试**

yarn的默认缓存和存储包的路径都在C盘，所以最好在安装后也进行修改

### yarn查看各种路径命令

- **查看 yarn 全局bin位置(prefix)**

```bash
yarn global bin
复制代码
```

- **查看 yarn 全局安装位置(folder)**

```shell
yarn global dir
复制代码
```

- **查看 yarn 全局cache位置(cache)**

```shell
yarn cache dir
复制代码
```

- **查看配置列表**

```shell
yarn config list
复制代码
```

### yarn修改路径命令

- **改变 yarn 全局bin位置(prefix)**

```shell
yarn config set prefix "E:\NodeJs\npm\yarn_bin"
复制代码
```

- **改变 yarn 全局安装位置(folder)**

```shell
yarn config  set global-folder "E:\NodeJs\npm\yarn_dir"
复制代码
```

- **改变 yarn 全局cache位置(cache)**

```shell
yarn config set cache-folder "E:\NodeJs\npm\npm_cache"
复制代码
```

### 配置环境变量

将`E:\NodeJs\npm\yarn_bin`添加到环境变量的path变量中，若该目录下自动生成了`bin`目录，则添加`E:\NodeJs\npm\yarn_bin\bin`到环境变量中

