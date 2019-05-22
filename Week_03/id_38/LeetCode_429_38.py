from collections import deque


class Solution:
    def levelOrder(self, root):
        result = []
        if not root:
            return result
        queue = deque()
        queue.append(root)
        while queue:
            items = []
            for _ in range(len(queue)):
                node = queue.popleft()
                items.append(node.val)
                for item in node.children:
                    queue.append(item)
            result.append(items)
        return result


