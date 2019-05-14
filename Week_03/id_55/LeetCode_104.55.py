# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 深度优先搜索DFS递归解法：
    def maxDepthDFS(self, root: TreeNode) -> int:
        # print("root val:%d" % (root.val))
        print("root:%s" % (root))
        if root == None:  # 递归边界
            return 0
        else:
            depth_l = self.maxDepthDFS(root.left)
            if depth_l:
                print("depth_l:%d" % (depth_l))
            depth_r = self.maxDepthDFS(root.right)
            if depth_r:
                print("depth_r:%d" % (depth_r))
            return max(depth_l, depth_r) + 1
    
    def maxDepthBFS(self, root):
        stack = []
        if root is not None:
            stack.append((1, root))  # 如果root不是空就把root加入stack，深度为1

        depth = 0
        while stack != []:  # 开始循环stack
            print("stack before pop :%s" % (stack))  # 打印pop前的栈
            current_depth, root = stack.pop()  # 先取出最后放进去的
            print("current_depth:%d" % (current_depth))  # 打印当前深度从1开始
            print("stack after pop :%s" % (stack))  # 打印pop后的栈
            if root:
                print("root.val:%d" % (root.val))
            if root is not None:
                depth = max(depth, current_depth)
                stack.append((current_depth + 1, root.left))
                stack.append((current_depth + 1, root.right))
        return depth