# 学习笔记

- 深度优先遍历(DFS)和广度优先遍历(BFS)

| 项目 | DFS | BFS |
| ----- | -----| ----- |
| 数据结构          |  栈 |  队列 |
| 顶点顺利的种类     |  两种顺序 | 一种顺序  |
| 边的类型（无向图）  |  树两边和同边 | 树两边的交叉边  |
| 应用             | 连通性，五环性，关节点  |  连通性，五环性，最少边路径 |
| 邻接矩阵的效率     |  O(V^2) |  O(V^2) |
| 邻接表的效率      | O(V + E)  |  O(V + E) |


- 动态规划
  - 自底向上
  - 通过求子问题的最优解， 可以获得原问题的最优解
  - 有重叠子问题 + 最优子结构，还必须记忆搜索，即可用动态规划

## 常用数据结构的小结及 ADT API
- Heap 大小堆, 用于优化优先队列, 用数组保存
  - insert(node), 1. add node to the end of the array, 2. siftUp untile parent > node
  - findMax(), return the index = 0 of the array
  - extratMax(), return the index = 0 and remove it, 1. swap(0, size -1), 2. remove index = size -1, 3. siftDown()
  - remove(), remove the root node
  - sort(), return a sorted array
  - replace(index), replace the root node
  - heapify(array), transform an array into a heap, 1. add node to the end of the array, 2. siftDown()
  - siftUp(index), sift up a node, make sure parent > left & parent > right
  - siftDown(index), sift down a node, make sure parent > left & parent > right
  - parent(index), return a node's parent index in the array
  - left(index), return a node's left index in the array
  - right(index), return a node's right index in the array

# 书本笔记

![11](https://user-images.githubusercontent.com/49065208/56456618-2c8f8b00-63a1-11e9-93d1-654ccc441e98.jpeg)

![14](https://user-images.githubusercontent.com/49065208/56456621-2d282180-63a1-11e9-8963-a9a0973c9871.jpeg)

![15](https://user-images.githubusercontent.com/49065208/56456622-2d282180-63a1-11e9-8fce-87bc1c45cd7d.jpeg)

![16](https://user-images.githubusercontent.com/49065208/56456623-2dc0b800-63a1-11e9-82ae-8f0bb87a3b18.jpeg)

![19](https://user-images.githubusercontent.com/49065208/56456626-2e594e80-63a1-11e9-8221-6f16f373f14c.jpeg)