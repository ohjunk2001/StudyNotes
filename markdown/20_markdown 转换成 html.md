# markdown 转换成 html

html模板

```html
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1300px, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="author" content="Yaofeng">
        <title>文档</title>
        <link rel="stylesheet" href="./markdown.min.css">
        <style>
            
        </style>
    </head>
    <body>
        @markdown
    </body>
    <script></script>
</html>
```

js 脚本

```js
const fs = require('fs');
const marked = require('marked');
// 模板文件地址
fs.readFile('./template.html', 'utf8', (err, template)=>{  
    if(err){  
        throw err  
    }else{  
        // 源文件地址
        fs.readFile('./test.md', 'utf8', (err,markContent)=>{  
            if(err){  
                throw err  
            }else{  
                // 转化好的html字符串  
                let htmlStr = marked(markContent.toString())  
                // 将html模板文件中的 '@markdown' 替换为html字符串  
                template = template.replace('@markdown', htmlStr)  
                // 将新生成的字符串template重新写入到文件中==>模板文件地址  
                fs.writeFile('./test.html', template, err=>{  
                    if(err){  
                        throw err  
                    }else{  
                        console.log("success")  
                    }  
                })  
            }  
        })  
    }  
})
```

