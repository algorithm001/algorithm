package List

//Finish
func detectCycle(head *ListNode) *ListNode {
	slow, fast := head, head
	hasCycle := false
	for slow != nil && fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
		if fast == slow {
			hasCycle = true
			break
		}
	}
	if !hasCycle {
		return nil
	}

	slow = head

	for fast != slow {
		fast, slow = fast.Next, slow.Next
	}
	return slow
}
