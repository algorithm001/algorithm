# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        return self.traversal(root, root.val)
    def traversal(self, root, value):
        if root == None:
            return -1
        if root.val > value:
            return root.val
        l = self.traversal(root.left, value)
        r = self.traversal(root.right, value)
        
        if l >= 0 and r >= 0:
            return min(l, r)
        return max(l, r)