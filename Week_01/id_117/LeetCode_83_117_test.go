package solution

import "testing"

func TestLeetCode_83_117(t *testing.T) {
	node01 := &ListNode{Val: 1}
	node02 := &ListNode{Val: 3}
	node03 := &ListNode{Val: 3}
	node01.Next = node02
	node02.Next = node03
	newNode := deleteDuplicates(node01)
	temNode := newNode
	for temNode != nil {
		t.Log(temNode.Val)
		temNode = temNode.Next
	}
}
