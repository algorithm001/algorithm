from collections import deque


class Solution:
    def findSecondMinimumValue(self, root):
        if not root:
            return -1
        if not root.left or not root.right:
            return -1
        minimum_value = None
        queue = deque()
        queue.append(root)
        while queue:
            for _ in range(len(queue)):
                node = queue.popleft()
                if node.left:
                    if not minimum_value:
                        queue.append(node.left)
                    elif node.left.val <= root.val + 1:
                        queue.append(node.left)
                if node.right:
                    if not minimum_value:
                        queue.append(node.right)
                    if node.right.val <= root.val + 1:
                        queue.append(node.right)
                if node.val - 1 == root.val:
                    return node.val
                if not minimum_value and root.val < node.val:
                    minimum_value = node.val
                elif minimum_value and node.val != root.val:
                    minimum_value = min(minimum_value, node.val)
        if not minimum_value:
            return -1
        return minimum_value

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
