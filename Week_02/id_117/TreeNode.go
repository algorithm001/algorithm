package solution

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func createNode(num int) *TreeNode {
	return &TreeNode{
		Val: num,
	}
}
