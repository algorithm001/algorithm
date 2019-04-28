package solution

/*
783. Minimum Distance Between BST Nodes

Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.

*/
func minDiffInBST(root *TreeNode) int {
	if root == nil {
		return 0
	}

	// 获取min初始值,这样就可以不用设置极大值
	min := 0
	if root.Left == nil {
		min = root.Right.Val - root.Val
	}
	if root.Right == nil {
		min = root.Val - root.Left.Val
	}
	leftDiff := root.Val - root.Left.Val
	rightDiff := root.Right.Val - root.Val
	if leftDiff > rightDiff {
		min = rightDiff
	} else {
		min = leftDiff
	}
	// 调用递归
	minDiffInBSTCell(root, &min)
	return min
}

func minDiffInBSTCell(root *TreeNode, min *int) {

	// 终止条件
	if root == nil {
		return
	}
	if root.Left != nil {
		// 值处理
		curMin := root.Val - root.Left.Val
		if curMin < *min {
			*min = curMin
		}
		// 继续下一层
		minDiffInBSTCell(root.Left, min)
	}

	if root.Right != nil {
		curMin := root.Right.Val - root.Val
		if curMin < *min {
			*min = curMin
		}
		minDiffInBSTCell(root.Right, min)
	}
}
