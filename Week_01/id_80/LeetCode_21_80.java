/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 
 * Definition for singly-linked list. 
 * public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null)
            return l1;
        if (l1 == null)
            return l2;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode start;
        if (l1.val < l2.val) {
            start = l1;
        } else {
            start = l2;
        }
        do {
            if (p2.val <= p1.val) {
                while (p2.next != null && p2.next.val <= p1.val) {
                    p2 = p2.next;
                }
                l2 = p2.next;
                p2.next = p1;
            } else {
                while (p1.next != null && p1.next.val < p2.val) {
                    p1 = p1.next;
                }
                l2 = p2.next;
                p2.next = p1.next;
                p1.next = p2;
            }

            p2 = l2;
        } while (p2 != null);
        return start;
    }
}