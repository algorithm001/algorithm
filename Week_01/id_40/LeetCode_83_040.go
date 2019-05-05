func deleteDuplicates(head *ListNode) *ListNode {
        current := head
        for current != nil && current.Next != nil {
                if current.Next.Data == current.Data {
                        current.Next = current.Next.Next
                } else {
                        current = current.Next
                }
        }
        return head
}
