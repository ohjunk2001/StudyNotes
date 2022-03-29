
## Walks

**定义**：给定图 $ G=<V,E>，v_0, v_1, … , v_k∈ V , e_1, e_2,…,e_k∈ E $ 其中 $ e_i $ 是关联结点 $ v_{i−1} $ 和 $ v_i $ 的边

**称交替序列**：$ v_0 e_1 v_1 e_2 v_2 e_3 v_3… e_k v_k $ 为连接 $ v_0 $ 到 $ v_k $ 的路

当 $ v_0=v_k $  时，称这条路为回路

![no.1](https://images-1302683597.cos.ap-nanjing.myqcloud.com/images/StudyNotes/Golang/basic/images_20220328120434.svg)

**定理**：设 G 是一个具有 n 个结点的图，如果从结点 v_1  到 v_2  存在一条路，则从结点 v_1  到 v_2 间必定存在一条长度不大于 n−1 的通路

**推论**：图 G 中任一圈的长度不大于 |V|

## The Connectivity of Graph

**无向图的连通**

**定义**：在一个无向图中，如果任两个结点都有一条路，那么我们称这个图是连通的，否则称是不连通的

**连通分支**

**定义**：图 G 的连通的子图 G′ 如果不包含在 G 的任何更大的连通子图中，则它被称作G的一个连通分支。

我们把图的连通分支个数记作 $ W(G) $

**定义**：在有向图中，若从结点 $ v_1 $ 到 $ v_2 $ 有一条路，则称 $ v_1 $ 可达 $ v_2 $

**定义**：设有向图 $ G $

- 若图 G 中任意两个结点中，至少从一个结点可达另一个结点，则称图 G 是单向连通的；

- 如果图G中任意两个结点都是相互可达的，则称图G是强连通的；

- 如果忽略掉边的方向得到的图是连通的无向图，则称图G是弱连通的。

**定理**:一个有向图 $ G $ 是强连通的，当且仅当 $ G $ 中有一个回路，它至少包含每一个结点一次。