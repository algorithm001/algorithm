# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def minDiffInBST(self, root: TreeNode) -> int:
        self.prev = None
        self.min_val = float('inf')
        self.inOrder(root)
        return self.min_val

    def inOrder(self, root):
        if not root:
            return
        self.inOrder(root.left)
        if self.prev:
            self.min_val = min(self.min_val, root.val - self.prev.val)
        self.prev = root
        self.inOrder(root.right)