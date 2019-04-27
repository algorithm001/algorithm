package solution

/*
236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
*/

// 方法1思路
// 定义一个栈，将其中一个节点的遍历路径存入栈中
// 然后每出栈一个元素，遍历该节点的子节点，如果能够查到，则出栈节点则为最近祖先。

// 方法二思路
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	// 递归介绍条件
	if root == nil || root.Val == p.Val || root.Val == q.Val {
		return root
	}
	// 递归调用
	ll := lowestCommonAncestor(root.Left, p, q)
	lr := lowestCommonAncestor(root.Right, p, q)
	// 处理返回结果
	if ll == nil {
		return lr
	}
	if lr == nil {
		return ll
	}
	return root
}
