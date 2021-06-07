# Matrix Notation of Graph

## 邻接矩阵

定义：设 $G=<V,E>$ 是有 $n$ 个结点的简单图，则 $n$ 阶方阵 $A=(a_{ij})$ 称为 $G$ 的邻接矩阵，其中

$$
a_{ij}=\begin{cases}
	1 \quad v_i \text{与} v_j \text{邻接}\\
	0 \quad others\\
\end{cases}
$$

设G是一个具有n个结点的 ${v_1,v_2,…,v_n }$ 的图，其中邻接矩阵为 $A$，则 $A^k$  $(k=1,2,3,…,n)$ 的第 $(i,j)$ 项元素 $a_{ij}^k$ 是从 $v_i$ 到 $v_j$ 长度为 $k$ 的路的总数

## 可达性矩阵

**定义**：设 $G=<V,E>$ 是一个简单有向图 $V={v_1,v_2,v_3,… ,v_n }$ , $n$ 阶方阵 $P=(p_{ij} )$ 称为 $G$ 的可达性矩阵，其中

$$
P_{ij}=\begin{cases}
	1 \quad \text{从} v\_i\ \text{到}v\_j\ \text{至少有一条路}\\
	0 \quad others\\
\end{cases}
$$

利用邻接矩阵得到可达性矩阵

- 令 $B_n=A+A^2+A^3+…+A^n$
- 将矩阵 $B_n$ 中所有不为零的矩阵改为 1 ，所得矩阵就是可达性矩阵

矩阵的乘法加法改为布尔运算

$A^2=A∧A$
$A^3=A^2∧A$
$\dots$
$A^n=A^{n−1}∧A$
$P=A∧A^2∧A^3∧A^n$

利用 Warshall 算法来求


定理：有向图 $G$ 是强连通当且仅当其可达性矩阵的每一个元素为 1

