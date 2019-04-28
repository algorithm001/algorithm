class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def findSecondMinimumValue(self, root: TreeNode) -> int:
        val_set = set([])

        def findRun(root):
            if not root:
                return
            val_set.add(root.val)
            if (root.left):
                findRun(root.left)
            if (root.right):
                findRun(root.right)

        findRun(root)
        a = list(val_set)
        a.sort()
        if len(a) < 2:
            return -1
        return a[1]