package solution

/*
938. Range Sum of BST

Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.



Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23


Note:

The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.

*/

func rangeSumBST(root *TreeNode, L int, R int) int {
	sum := 0
	rangeSumBSTCell(root, L, R, &sum)
	return sum
}

func rangeSumBSTCell(root *TreeNode, L int, R int, sum *int) {
	if root == nil {
		return
	}
	if root.Val >= L && root.Val <= R {
		*sum += root.Val
	}
	// 左子树 减少时间复杂度
	if root.Val == L && root.Left != nil {
		rangeSumBSTCell(root.Right, L, R, sum)
		return
	}
	// 右子树 减少时间复杂度
	if root.Val == R && root.Right != nil {
		rangeSumBSTCell(root.Left, L, R, sum)
		return
	}
	rangeSumBSTCell(root.Right, L, R, sum)
	rangeSumBSTCell(root.Left, L, R, sum)
}
