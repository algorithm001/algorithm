# Definition for singly-linked list.
class ListNode(object):

    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):

    def deleteDuplicates(self, head):

        current = head
        if current is None:
            return head
        while current.next is not None:
            if current.val == current.next.val:
                if current.next.next is not None:
                    current.next = current.next.next
                    # current = current.next
                else:
                    current.next = None
            else:
                current = current.next
        return head


