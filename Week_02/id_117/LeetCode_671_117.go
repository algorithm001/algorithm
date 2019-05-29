package solution

/*
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

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.


Example 2:

Input:
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
*/

func compare(left, right int) int {
	if left == -1 {
		return right
	}
	if right == -1 {
		return left
	}

	if left > right {
		return right
	}
	return left
}

func findBigerOne(node *TreeNode, smallest int) int {

	// 截止条件
	if node == nil {
		return -1
	}
	if node.Val > smallest {
		return node.Val
	}

	// 递归操作
	left := findBigerOne(node.Left, smallest)
	right := findBigerOne(node.Right, smallest)

	// 比较返回数据
	return compare(left, right)
}

func findSecondMinimumValue(root *TreeNode) int {
	if root == nil {
		return -1
	}
	if root.Right == nil && root.Left == nil {
		return -1
	}
	left := findBigerOne(root.Left, root.Val)
	right := findBigerOne(root.Right, root.Val)
	return compare(left, right)
}
