package solution

import "reflect"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type TreeNodeMul struct {
	Val      int
	Children []*TreeNodeMul
}

func StringSliceReflectEqual(a, b []int) bool {
	return reflect.DeepEqual(a, b)
}
