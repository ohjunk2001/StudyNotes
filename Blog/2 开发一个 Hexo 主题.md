# 开发一个 Hexo 主题

```
wiki ➔  tree -L 1
.
├── _config.yml       // 总体的配置文件
├── node_modules      // NodeJs 所依赖的包，后期也可以自己添加插件
├── package-lock.json // 支持 hexo 运行的 NodeJs 包
├── package.json      // 自定义的 NodeJs 包
├── scaffolds         // Hexo Markdown 加载时的关键字，如data,title等,它会在启动的时候默认加载
├── source            // md 源文件目录
└── themes            // 主题文件夹
    └── landscape     // 默认主题        

```

