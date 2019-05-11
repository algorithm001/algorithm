package geekcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	l0 := maxDepth(root.Left)
	l1 := maxDepth(root.Right)
	if l0 > l1 {
		return l0 + 1
	} else {
		return l1 + 1
	}
}
