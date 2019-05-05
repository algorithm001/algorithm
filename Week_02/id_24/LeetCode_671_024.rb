# https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/submissions/
# 671. 二叉树中第二小的节点
# 解题思路 首先阅读题干我们得到信息，该二叉树有一个特点，节点都为正数，如果有两个子节点则节点值不大于子节点的值
# 由此我们得出，求该二叉树第二小的节点值即为求该二叉树左右子树的最小节点值，因为根节点肯定是最小的节点
# 解题过程中遇到的第一个问题，递归代码不熟练，代码实现有卡壳的地方，第二个问题，刚开始做的时候虽然想到了遇到-1要取左右子树
# 中较大的那个返回值，还是在代码实现上没处理好，只处理了取最大值，来回改动的时候都是不对的，第三个问题，递归公式实现的时候
# 前期以为返回-1是左节点为空的时候，其实不是，应该是自身取值为空的时候返回-1，如果用左节点为空作为退出条件之一，递归会少往下
# 走一层，当出现 [2,2,5]这种时，结果会是-1.

# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Integer}
def find_second_minimum_value(root)
    find_minimum_value(root, root.val)
end
def find_minimum_value(root, val)
    return -1 if root.nil?
    return root.val if root.val > val
    left_value = find_minimum_value(root.left, val)  
    right_value = find_minimum_value(root.right, val)
    if left_value >=0 && right_value >= 0
      v = [left_value, right_value].min
    else
      v = [left_value, right_value].max 
    end
    return v
end
