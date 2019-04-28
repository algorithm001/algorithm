package id_123

import "math"

func minDiffInBST(root *TreeNode) int {
	array := make([]int, 0)
	inOrder(root, &array)
	minValue := math.MaxInt32

	for i := 0; i < len(array)-1; i++ {
		value1 := array[i]
		value2 := array[i+1]
		diffValue := value2 - value1
		if diffValue < minValue {
			minValue = diffValue
		}
	}

	return minValue
}

func inOrder(root *TreeNode, array *[]int) {
	if root == nil {
		return
	}

	inOrder(root.Left, array)
	*array = append(*array, root.Val)
	inOrder(root.Right, array)
}
