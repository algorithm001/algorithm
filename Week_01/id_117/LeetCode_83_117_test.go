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

	rights := []int{1, 3}
	news := []int{}

	for temNode != nil {
		news = append(news, temNode.Val)
		temNode = temNode.Next
	}
	if len(rights) != len(news) {
		t.Fatalf("False")
	}
	for i := 0; i < len(rights); i++ {
		if news[i] != rights[i] {
			t.Fatalf("False")
			break
		}
	}
	t.Log("True")
}
