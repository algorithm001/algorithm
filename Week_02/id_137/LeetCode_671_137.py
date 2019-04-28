"https://leetcode-cn.com/problems/arranging-coins/"
"Author : Shaodong Song" 
"Date : 2019-04-20"

"""
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input: 
    2
   / \
  2   5
     / \
    5   7

Example 2:

Input: 
    2
   / \
  2   2


"""

# Definition for a binary tree node.
class TreeNode(object):
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

class Solution(object):
        
    def findSecondMinimumValueCore(self, root, value):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return -1 
        
        if root.val > value:
            return root.val
        
        left = self.findSecondMinimumValueCore(root.left, value)
        right = self.findSecondMinimumValueCore(root.right, value)
        
        if left >= 0 and right >= 0:
            return min(left, right)
        
        return max(left, right)

    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.findSecondMinimumValueCore(root, root.val)


root = TreeNode(2)

root.left = TreeNode(2)
root.right = TreeNode(5)

right_root = root.right
right_root.left = TreeNode(5)
right_root.right = TreeNode(7)

""" case 2:
root.left = TreeNode(2)
root.right = TreeNode(2)
"""

so = Solution()

print "In a Binary Tree, The second minimum = %d " % so.findSecondMinimumValue(root)



