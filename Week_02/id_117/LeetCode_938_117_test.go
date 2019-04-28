package solution

import (
	"testing"
)

func initializeTree938_01() *TreeNode {
	/*
		Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
		Output: 32
	*/
	root := createNode(10)
	node1 := createNode(5)
	node2 := createNode(15)
	node3 := createNode(3)
	node4 := createNode(7)
	node5 := createNode(18)

	root.Left = node1
	root.Right = node2
	node1.Left = node3
	node1.Right = node4
	node2.Right = node5

	return root
}

func initializeTree938_02() *TreeNode {
	/*
		Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
		Output: 23
	*/
	root := createNode(10)
	node1 := createNode(5)
	node2 := createNode(15)
	node3 := createNode(3)
	node4 := createNode(7)
	node5 := createNode(18)
	node6 := createNode(13)
	node7 := createNode(1)
	node8 := createNode(6)

	root.Left = node1
	root.Right = node2
	node1.Left = node3
	node1.Right = node4
	node2.Left = node6
	node2.Right = node5
	node3.Left = node7
	node4.Left = node8

	return root
}

func TestLeetCode_938_117(t *testing.T) {
	root01 := initializeTree938_01()
	root02 := initializeTree938_02()

	arrs := make(map[*TreeNode]int, 0)
	arrs[root01] = 32
	arrs[root02] = 23
	anwsers := make(map[*TreeNode][]int, 0)
	anwsers[root01] = []int{7, 15}
	anwsers[root02] = []int{6, 10}

	for k, v := range arrs {
		rangeSum := rangeSumBST(k, anwsers[k][0], anwsers[k][1])
		if rangeSum == v {
			t.Log("TRUE")
		} else {
			t.Error("FALSE")
		}
	}
}
