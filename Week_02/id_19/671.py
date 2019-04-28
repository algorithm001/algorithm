def findSecondMinimumValue(self,root):
    self.ans = float('inf')
    min1 = root.val
    def dfs(node):
        if nod:
            if min < node.val < self.ans:
                self.ans = node.val
            elif node.val == min1:
                dfs(node.left)
                dfs(node.right)
    dfs(root)
    return self.ans if self.ans < float('inf') else -1
