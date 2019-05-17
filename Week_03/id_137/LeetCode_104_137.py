"https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/"
"Author : Shaodong Song" 
"Date : 2019-05-17"

"""
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
                
        if root == None: return 0
        
        return max((self.maxDepth(root.left),self.maxDepth(root.right))) + 1


root = TreeNode(3)

root.left = TreeNode(9)
root.right = TreeNode(20)

right_root = root.right
right_root.left = TreeNode(15)
right_root.right = TreeNode(7)

""" case 2:
root.left = TreeNode(2)
root.right = TreeNode(2)
"""

so = Solution()

print "The binary maximum depth = %d " % so.maxDepth(root)



