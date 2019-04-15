package List

//Finish
func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	flag, move := head, head

	for move != nil {
		if flag.Val != move.Val {
			flag, flag.Next = move, move
		}
		move = move.Next
	}
	flag.Next = nil
	return head
}
