/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
    head1 := head
    for head1 != nil && head1.Next != nil {
        if head1.Val == head1.Next.Val {
            head1.Next = head1.Next.Next
        } else {
            head1 = head1.Next
        } 
    }
    return head
}
