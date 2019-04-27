"https://leetcode-cn.com/problems/longest-univalue-path/"
"Author : Shaodong Song" 
"Date : 2019-04-20"

"""
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

--> Example 1:

Input:

              1
             / \
            2   1

Output: 1

--> Example 2:

Input:

              1
             / \
            1   1

Output: 2
"""

"Definition for a binary tree node."
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    
    max_path = 0;
    
    def findUnivaluePathCore(self, root, val):
        if root == None:
            return 0
        
        left = self.findUnivaluePathCore(root.left, root.val)
        right = self.findUnivaluePathCore(root.right, root.val)
        
        self.max_path = max(self.max_path, left + right)
        
        " when the current node and the parent node are the same,"
        " return longest univalue path length that can be formed by the current node."
        " otherwise return 0."

        if root.val == val:
            return max(left, right) + 1
        
        return 0

    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        
        self.findUnivaluePathCore(root, root.val)
        
        return self.max_path


root = TreeNode(1)

"case 1"
"""
root.left = TreeNode(2)
root.right = TreeNode(1)
"""

"case 2"
root.left = TreeNode(1)
root.right = TreeNode(1)

"case n"
"..."

so = Solution()

print "longestUnivaluePath = %d" % so.longestUnivaluePath(root)

