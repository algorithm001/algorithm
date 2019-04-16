package Recursion

var ans = 0
func longestUnivaluePath(root *TreeNode) int {

	arrowLength(root)
	return ans
}

func arrowLength(root *TreeNode) int{
	if root == nil{
		return 0
	}
	left := arrowLength(root.Left)
	right := arrowLength(root.Right)

	arrowLeft,arrowRight := 0, 0
	if root.Left != nil && root.Left.Val == root.Val{
		arrowLeft += left + 1
	}
	if root.Right != nil && root.Right.Val == root.Val{
		arrowRight += right +1
	}
	if ans < arrowRight + arrowLeft{
		ans = arrowLeft + arrowRight
	}
	if arrowRight > arrowLeft{
		return arrowRight
	}else{
		return arrowLeft
	}
}
