from collections import deque


class Solution:
    def minDiffInBST(self, root):
        if not root:
            return None
        if not root.left and not root.right:
            return None
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
        last_node = None
        minimum_value = None
        while visited:
            current_node = visited.pop()
            if last_node and last_node.val + 1 == current_node.val:
                return 1
            if last_node:
                space_value = abs(current_node.val - last_node.val)
            else:
                space_value = current_node.val
            last_node = current_node
            if not minimum_value or (minimum_value and minimum_value > space_value):
                minimum_value = space_value
        return minimum_value

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

