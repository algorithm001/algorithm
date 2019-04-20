class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        prev = head
        while(prev):
            while(prev.next):
                if prev.val == prev.next.val:
                    prev.next = prev.next.next
                else:
                    break
            prev = prev.next
        return head
