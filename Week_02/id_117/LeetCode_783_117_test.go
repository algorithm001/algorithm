package solution

import (
	"testing"
)

func initializeTree3() *TreeNode {
	// root = [4,2,6,1,3,null,null]
	root := createNode(10)
	node1 := createNode(6)
	node2 := createNode(11)
	node3 := createNode(2)
	node4 := createNode(8)

	root.Left = node1
	root.Right = node2
	node1.Left = node3
	node1.Right = node4

	return root
}
func _783Test(t *testing.T, root *TreeNode) {
	min := minDiffInBST(root)
	t.Log("_783Test: min Value: ", min)
}
func TestLeetCode_783_117(t *testing.T) {
	root := initializeTree3()
	_783Test(t, root)
}
