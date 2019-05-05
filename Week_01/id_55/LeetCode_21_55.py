# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        cur1, cur2 = l1, l2
        new = ListNode(0)
        cur = new
        while cur1 != None and cur2 != None:
            # print(cur1.val)
            # print(cur2.val)
            if cur1.val <= cur2.val:
                cur.next = cur1
                cur1 = cur1.next
            else:
                cur.next = cur2
                cur2 = cur2.next
            cur = cur.next
        
        # 循环有先后最后会有一个数组没有循环完另一个空了，剩下就继续写入cur即可
        if cur1 != None:
            cur.next = cur1

        if cur2 != None:
            cur.next = cur2

        return new.next

    # 递归的方法
    def recursionMergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1: return l2
        if not l2: return l1
        if l1.val < l2.val:
            l1.next =  self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2


# 创建链表
a = ListNode(1)
b = ListNode(3)
c = ListNode(5)
d = ListNode(5)
e = ListNode(7)
a.next = b
b.next = c
c.next = d
d.next = e

f = ListNode(2)
g = ListNode(2)
h = ListNode(4)
i = ListNode(6)
l = ListNode(8)
f.next = g
g.next = h
h.next = i
i.next = l
# 实例化
demo = Solution()
# print(demo.mergeTwoLists(a, f))
print(demo.recursionMergeTwoLists(a, f))