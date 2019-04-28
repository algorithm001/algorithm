# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDiffInBST(self, root: TreeNode) -> int:
        if root is None:
            return 0
        self.minDiffInBST(root.left)
        res = min(root.val - self.last, self.res)
        self.last = root.val
        self.minDiffInBST(root.right)
        return res
    
    def __init__(self):
        self.last = -2**31
        self.res = 2**31