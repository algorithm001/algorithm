package HashTable

import "math"
//Finished
var res = -1
func findSecondMinimumValue(root *TreeNode) int {
	min := minValue(root)
	res = math.MaxInt64
	helpFind(root,min)
	if res == math.MaxInt64{
		return -1
	}
	return res
}

func helpFind(root *TreeNode, min int)  {
	if root != nil{
		if root.Val > min && root.Val < res{
			res = root.Val
		}
		helpFind(root.Left,min)
		helpFind(root.Right,min)
	}
}

func minValue(root *TreeNode) int {
	if root.Left == nil && root.Right == nil{
		return root.Val
	}
	if root.Left == nil{
		return minValue(root.Right)
	}
	if root.Right == nil{
		return minValue(root.Left)
	}
	if root.Left.Val < root.Right.Val{
		return minValue(root.Left)
	}else {
		return minValue(root.Right)
	}
}
