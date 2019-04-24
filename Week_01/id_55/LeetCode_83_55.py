# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        cur = head
        while cur:
            if cur.next and cur.val == cur.next.val:
                cur.next = cur.next.next
            else:
                cur = cur.next
        return head


# 创建链表
a = ListNode(1)
b = ListNode(2)
c = ListNode(3)
d = ListNode(3)
e = ListNode(4)
a.next = b
b.next = c
c.next = d
d.next = e

# 实例化
demo = Solution()
print(demo.deleteDuplicates(a))