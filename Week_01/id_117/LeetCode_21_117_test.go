package solution

import (
	"testing"
)

func TestLeetCode_21_117(t *testing.T) {
	node01 := &ListNode{Val: 1}
	node02 := &ListNode{Val: 3}
	node03 := &ListNode{Val: 3}
	node01.Next = node02
	node02.Next = node03

	node11 := &ListNode{Val: 1}
	node12 := &ListNode{Val: 1}
	node13 := &ListNode{Val: 2}
	node11.Next = node12
	node12.Next = node13

	newNode := mergeTwoLists(node01, node11)
	temNode := newNode
	for temNode != nil {
		t.Log(temNode.Val)
		temNode = temNode.Next
	}
}
