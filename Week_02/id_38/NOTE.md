# 学习笔记
## 二叉查找树（Binary Search Tree）
二叉查找树有以下特点：
* 根节点的值大于左子树的值，小于等于右子树的值。
* 使用二叉树中序遍历的方式可以得到一个有序的数据集。
* 
## 二叉树（Binary Tree）

二叉树的遍历：前序遍历，中序遍历，后序遍历，以及广度优先遍历（DFS）和深度优先遍历（BFS）。

前序遍历，中序遍历，后序遍历的实现使用递归的方式很简单。如果用递归可以实现，那么也可以使用迭代的方式实现。

以下代码是用栈实现二叉树非递归的中序遍历。

```python
def in_order(self, root):
    stack = deque()
    visited = []
    stack.append(root)
    while stack:
        node = stack.pop()
        if node in visited:
            continue
        if node.right and node.right not in visited:
            stack.append(node.right)
        if not node.left or node.left in visited:
            visited.append(node)
        else:
            stack.append(node)
        if node.left and node.left not in visited:
            stack.append(node.left)

    for item in visited:
        print(item.val)
```

二叉树的按层遍历（DFS）算法代码实现如下：

```python
def dfs(self, root):
    if not root:
        return
    depth = 1
    queue = deque()
    queue.append(root)
    while queue:
        for _ in range(len(queue)):
            node = queue.popleft()
            print(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        print("*******************")
        depth += 1
```

