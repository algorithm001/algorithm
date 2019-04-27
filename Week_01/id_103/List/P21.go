package List

//Finish
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	res := ListNode{}
	temp := &res
	for l1 != nil || l2 != nil {
		if l1 == nil {
			temp.Next = l2
			break
		}
		if l2 == nil {
			temp.Next = l1
			break
		}
		if l1.Val < l2.Val {
			temp.Next = l1
			l1 = l1.Next
		} else {
			temp.Next = l2
			l2 = l2.Next
		}
		temp = temp.Next
	}
	return res.Next
}
