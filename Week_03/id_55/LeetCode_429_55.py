# Definition for a Node.


class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        level = []
        if not root:
            return []
        level.append((0, root))
        res = []
        while level:
            depth, root = level.pop(0)
            if depth >= len(res):
                res.append([])
            res[depth].append(root.val)
            for node in root.children:
                level.append((depth+1, node))
        return res