# 学习笔记

## 常用数据结构的小结及 ADT API
- Stack 栈，后进先出（LIFL）
  - push(val)
  - pop(), remove and return the top element
  - peek(), return the last element
- set 集合
  - add(val)
  - remove(val)
  - has(val)
  - values(), return the collection
  - size()
  - isEmpty()
  - union(anotherSet), return union of two sets
  - intersection(anotherSet), return intersection of two sets
  - difference(anotherSet), return the different of two sets
  - subset(subSet), return if subSet is a sub set of current set.
- Queue 队列，先进先出（FIFO）enqueue() -> font->1->2->...->end <- dequeue()
  - enquue(val), add 
  - dequeue(), remove and return the last element
  - font(), return the first element
  - size()
  - isEnpty()
- Binary search tree 二分搜索树
  - add(val), val < node.val -> add to left, val > node.val -> add to right, 
  - delete(val), left = null, remove right; right = null, remove left; otherwise find mimnNode = minNode(node.rigth), replace node with minNode and remove minNode.
  - inOrder()
  - preOrder()
  - postOrder()
  - levelOrder(), push node to a queue, dequeue -> enqueue left node -> enqueue right node, repeat until queue is empty
  - isBlance(), minHeight() <= maxHeight - 1
  - minHeight()
  - maxHeight()
  - minNode()
  - maxNode()
- Map 映射, 增删改查都是 O(1)
  - collection()
  - set(key, val)
  - get(key)
  - has(key)
  - delete(key)
  - clear()
  - size()
- Hash Table 哈希表
  - add(val)
  - remove(val)
  - lookup(val)
- Linked list 链表, 增删改查都是 O(n)
  - head()
  - tail()
  - addAt(index, val), O(n)
  - getAt(index), O(n)
  - remove(val), O(n)
  - has(val), O(n)
  - isEmpty()
- Trie 字典树, 每个节点都是 map, 根节点为空
  - add(val)
  - isWord(val)
  - contains(val)
  - isPrefix(val)
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
![1](https://user-images.githubusercontent.com/49065208/56456608-2ac5c780-63a1-11e9-9b5b-da7966da2a1b.jpeg)

![2](https://user-images.githubusercontent.com/49065208/56456609-2ac5c780-63a1-11e9-8876-e529d5b1c58a.jpeg)

![3](https://user-images.githubusercontent.com/49065208/56456610-2ac5c780-63a1-11e9-8fa7-7bd8397b5f9d.jpeg)

![4](https://user-images.githubusercontent.com/49065208/56456611-2b5e5e00-63a1-11e9-9ce6-4df39825b3c8.jpeg)

![5](https://user-images.githubusercontent.com/49065208/56456612-2b5e5e00-63a1-11e9-9d28-7699e32d2f59.jpeg)

![6](https://user-images.githubusercontent.com/49065208/56456613-2b5e5e00-63a1-11e9-9e84-37c56f230e05.jpeg)

![7](https://user-images.githubusercontent.com/49065208/56456614-2bf6f480-63a1-11e9-8bae-865eaeecdca3.jpeg)

![8](https://user-images.githubusercontent.com/49065208/56456615-2bf6f480-63a1-11e9-9cac-2e5c2d51a6f9.jpeg)

![9](https://user-images.githubusercontent.com/49065208/56456616-2bf6f480-63a1-11e9-88c7-b21411b3972a.jpeg)

![10](https://user-images.githubusercontent.com/49065208/56456617-2c8f8b00-63a1-11e9-90f8-f9aa8e4a1eb8.jpeg)

![11](https://user-images.githubusercontent.com/49065208/56456618-2c8f8b00-63a1-11e9-93d1-654ccc441e98.jpeg)

![12](https://user-images.githubusercontent.com/49065208/56456619-2c8f8b00-63a1-11e9-8203-c1ec7f8f2658.jpeg)

![13](https://user-images.githubusercontent.com/49065208/56456620-2d282180-63a1-11e9-8bf2-76c6c7881efc.jpeg)

![14](https://user-images.githubusercontent.com/49065208/56456621-2d282180-63a1-11e9-8963-a9a0973c9871.jpeg)

![15](https://user-images.githubusercontent.com/49065208/56456622-2d282180-63a1-11e9-8fce-87bc1c45cd7d.jpeg)

![16](https://user-images.githubusercontent.com/49065208/56456623-2dc0b800-63a1-11e9-82ae-8f0bb87a3b18.jpeg)

![17](https://user-images.githubusercontent.com/49065208/56456624-2dc0b800-63a1-11e9-96d2-55dff051db5b.jpeg)

![18](https://user-images.githubusercontent.com/49065208/56456625-2dc0b800-63a1-11e9-8514-9a0e44d06f24.jpeg)

![19](https://user-images.githubusercontent.com/49065208/56456626-2e594e80-63a1-11e9-8221-6f16f373f14c.jpeg)
