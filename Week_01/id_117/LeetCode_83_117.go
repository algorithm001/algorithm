package solution

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	if head.Next == nil {
		return head
	}
	p := head
	q := p.Next
	for q != nil {
		if p.Val == q.Val {
			p.Next = q.Next
			q = p.Next
			continue
		}
		p = p.Next
		q = p.Next

	}
	return head
}
