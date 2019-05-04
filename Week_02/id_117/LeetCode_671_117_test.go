package solution

import (
	"testing"
)

func _671Test1(t *testing.T) {
	root := createNode(2)
	node1 := createNode(2)
	node2 := createNode(5)
	node3 := createNode(5)
	node4 := createNode(7)
	root.Left = node1
	root.Right = node2
	node2.Left = node3
	node2.Right = node4

	target := findSecondMinimumValue(root)
	t.Log("_671Test1 target: ", target)
	if target == 5 {
		t.Log("TRUE")
	} else {
		t.Log("FALSE")
	}
}

func _671Test2(t *testing.T) {
	root := createNode(2)
	node1 := createNode(2)
	node2 := createNode(2)

	root.Left = node1
	root.Right = node2

	target := findSecondMinimumValue(root)
	t.Log("_671Test2 target: ", target)
	if target == 5 {
		t.Log("TRUE")
	} else {
		t.Log("FALSE")
	}
}

func TestLeetCode_671_117(t *testing.T) {
	_671Test1(t)
	_671Test2(t)
}
