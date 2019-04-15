package List

//Inprogress
func reverseKGroup(head *ListNode, k int) *ListNode {
	count := 1
	res := ListNode{}
	start, cur := head, head
	for cur != nil {
		if count == k {
			temp := cur.Next
			cur.Next = nil
			res.Next = ReverseGroup(start)
			start = temp
			count = 1
		} else {
			count++
		}
		cur = cur.Next
	}
	return res.Next
}

func ReverseGroup(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	prev, cur := head, head.Next
	head.Next = nil // head should be tail after reversing
	var next *ListNode
	for {
		next = cur.Next
		cur.Next = prev

		if next == nil {
			return cur
		}
		prev = cur
		cur = next
	}
	return nil // never reaches here
}
