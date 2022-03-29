
**定义**：无孤立点的图 $ G $，若存在一条经过 $ G $ 中所有边一次且仅一次的回路，则称该回路为欧拉回路，具有欧拉回路的图称为 Eulerian Graph

边只能走一次，点可以重复

**定理**：连通图 $ G $ 是 Eulerian Graph 的充要条件是 $ G $ 的所有结点的度数都是偶数

Proof:
充分性：
必要性：

**定义**：给定图 $ G $,若有一条路通过G中每一个结点恰好一次，则这样的路被称作 Hamilitionian Graph

**定义**：若有一个圈，通过 $ G $ 中每一个结点恰好一次，这样的圈被称作 Hamilitionian circuit

**定理**：设图 $ G=<V,E> $ 是 Hamilitonian Graph ,则对于每一个 $ V $ 的非空子集 $ S $，均有
$ \qquad W(G−S)≤ |S| $

成立，其中 $ W(G−S) $ 是图 $ G−S $ 的连通分支支数

**定理**：设 $ G=<V,E> $ 是具有 $ n $ 个结点的简单图

- 如果对于任意两个结点 $ u,v ∈ V $,均有 $ deg⁡(u)+deg⁡(v)≥n−1 $
- 如果对于任意两个结点 $ u,v ∈ V $,均有 $ deg⁡(u)+deg⁡(v)≥n $,则 $ G $ 是 Hamiliton Graph