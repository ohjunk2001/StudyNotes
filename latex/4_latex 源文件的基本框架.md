# Latex 源文件的基本框架

```latex
\documentclass{article} % 指定文档类型

%
%导言区：全局设置，宏包调用
%

\begin{document}

% 正文部分

Hi, this is my first \LaTex{} file.

\end{document} % 结束
```

- Latex 源文件：正文+命令+注解
- 反斜杠开头的字符串：排版命令（简称 命令）
- 注释：百分号 %
- \documentclass{...} 指定文档类型（论文，书籍，幻灯片，海报）
- \begin{...} 和 \end{...} 构成一个环境