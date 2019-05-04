package solution

import "reflect"

/**
 * Definition for a binary tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func StringSliceReflectEqual(a, b []int) bool {
	return reflect.DeepEqual(a, b)
}
