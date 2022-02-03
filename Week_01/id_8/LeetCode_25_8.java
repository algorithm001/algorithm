/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode preGroupLastest = null;
        ListNode begin = null;
        ListNode end = null;
        ListNode result = null;
        ListNode n = head;
        int i = 0;
        while (n != null) {
            ++i;
            if (i == 1) {
                begin = n;
            } else if (i == k) {
                end = n;
                ListNode groupHead = reverseLinked(begin, end);
                if (preGroupLastest != null) {
                    preGroupLastest.next = groupHead;
                }
                preGroupLastest = begin;
                if (result == null) {
                    result = groupHead;
                }
                n = begin.next;
                i = 0;
                continue;
            }
            n = n.next;
        }

        return result == null ? head : result;
    }


    public ListNode reverseLinked(ListNode begin, ListNode end) {
        ListNode pre = end.next;
        ListNode tmp = null;
        while (begin != end) {
            tmp = begin.next;
            begin.next = pre;
            pre = begin;
            begin = tmp;
        }
        begin.next = pre;

        return end;
    }
}