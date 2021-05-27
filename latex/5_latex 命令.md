# LaTeX 命令

```latex
\command
\command[option]{arguments}
```
- [] 方括号中的参数是可选的（称为 选项），花括号中的参数是必需的

```latex
例，一些常用的命令
\documentcallss,\title,\author,\date,\usepackage
\begin{环境名}, \end{环境名} 组成一个环境
```

## 定义新命令

```latex
\newcommand{新命令}{新命令内容}
\renewcommand{已有命令}{命令内容}
```

```latex
\newcommand{\eps}{varepsilon} % $\eps$  
```