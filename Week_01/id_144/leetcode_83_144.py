# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head:
            return head
        p = head
        q = head.next
        while q:
            if q.val != p.val:
                p.next = q
                p = p.next
            q = q.next
        if p!= q:
            p.next = None
        return head