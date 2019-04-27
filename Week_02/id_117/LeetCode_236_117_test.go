package solution

import (
	"testing"
)

func initializeTree() *TreeNode {
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

func _242Test1(t *testing.T, root *TreeNode) {
	// p = 5, q = 4
	pNode := createNode(5)
	qNode := createNode(4)

	findNode := lowestCommonAncestor(root, pNode, qNode)
	t.Log("_242Test1: findNode Value: ", findNode.Val)
}

func _242Test2(t *testing.T, root *TreeNode) {
	// p = 5, q = 1
	pNode := createNode(5)
	qNode := createNode(1)
	findNode := lowestCommonAncestor(root, pNode, qNode)
	t.Log("_242Test2: findNode Value: ", findNode.Val)
}

func TestLeetCode_242_117(t *testing.T) {
	root := initializeTree()
	_242Test1(t, root)
	_242Test2(t, root)
}
