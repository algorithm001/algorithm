package solution

import (
	"testing"
)

func initializeTree2() *TreeNode {
	// root = [3,5,1,6,2,0,8,null,null,7,4]
	root := createNode(3)
	node1 := createNode(5)
	node2 := createNode(1)
	node3 := createNode(6)
	node4 := createNode(2)
	node5 := createNode(0)
	node6 := createNode(8)
	node7 := createNode(7)
	node8 := createNode(4)

	root.Left = node1
	root.Right = node2
	node1.Left = node3
	node1.Right = node4
	node2.Left = node5
	node2.Right = node6
	node4.Left = node7
	node4.Right = node8

	return root
}
func _838Test(t *testing.T, root *TreeNode) {
	pNode := createNode(5)
	K := 1
	list := distanceK(root, pNode, K)
	t.Log("_838Test: list Value 1: ", list)

	pNode = createNode(5)
	K = 2
	list = distanceK(root, pNode, K)
	t.Log("_838Test: list Value 2: ", list)

	pNode = createNode(5)
	K = 3
	list = distanceK(root, pNode, K)
	t.Log("_838Test: list Value 3: ", list)
}
func TestLeetCode_838_117(t *testing.T) {
	root := initializeTree2()
	_838Test(t, root)
}
