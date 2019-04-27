package List

//Finish
func swapPairs(head *ListNode) *ListNode {
	for p1 := head; p1 != nil && p1.Next != nil; {
		p2 := p1.Next
		p1.Val, p2.Val = p2.Val, p1.Val
		p1 = p2.Next
	}
	return head
}
