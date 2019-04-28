package id_123

func findSecondMinimumValue(root *TreeNode) int {
	return findBiggerThanValue(root, root.Val)
}

func findBiggerThanValue(root *TreeNode, minValue int) int {
	if root == nil {
		return -1
	}

	if root.Val > minValue {
		return root.Val
	}

	leftMinValue := findBiggerThanValue(root.Left, minValue)
	rightMinValue := findBiggerThanValue(root.Right, minValue)

	if leftMinValue == -1 && rightMinValue == -1 {
		return -1
	} else if leftMinValue != -1 && rightMinValue == -1 {
		return leftMinValue
	} else if leftMinValue == -1 && rightMinValue != -1 {
		return rightMinValue
	} else {
		return min(leftMinValue, rightMinValue)
	}
}

func min(x, y int) int {
	if x < y {
		return x
	}

	return y
}
