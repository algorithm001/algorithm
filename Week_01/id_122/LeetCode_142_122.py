# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None or head.next.next is None:
            return
        p1 = head.next
        p2 = head.next.next
        while(p2 is not None and p2.next is not None and p2.next.next is not None):
            p1 = p1.next
            p2 = p2.next.next
            if p1 is p2:
                p1 = head
                while p1 is not p2:
                    p1 = p1.next
                    p2 = p2.next
                return p1
        return