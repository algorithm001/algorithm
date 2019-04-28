package id_123

const MaxUint = ^uint(0)
const MaxInt = int(MaxUint >> 1)

func minDiffInBST(root *TreeNode) int {
	minValue := MaxInt
	calcMinDiff(root, &minValue)
	return minValue
}

func calcMinDiff(root *TreeNode, minValue *int) {
	if root.Left != nil {
		diffValue := root.Val - findRightLeafValue(root.Left)
		if diffValue < *minValue {
			*minValue = diffValue
		}
		calcMinDiff(root.Left, minValue)
	}
	if root.Right != nil {
		diffValue := findLeftLeafValue(root.Right) - root.Val
		if diffValue < *minValue {
			*minValue = diffValue
		}
		calcMinDiff(root.Right, minValue)
	}
}

func findLeftLeafValue(root *TreeNode) int {
	if root.Left == nil {
		return root.Val
	}

	return findLeftLeafValue(root.Left)
}

func findRightLeafValue(root *TreeNode) int {
	if root.Right == nil {
		return root.Val
	}

	return findRightLeafValue(root.Right)
}
