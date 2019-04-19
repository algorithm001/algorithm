/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {

            ListNode p0 = head;
            ListNode p1 = p0.next;

            ListNode newHead = new ListNode(0);
            ListNode result = newHead;

            while (p0 != null && p1 != null) {
                p0.next = p1.next;
                newHead.next = p1;
                p1.next = p0;

                newHead = p0;
                p0 = p0.next;
                p1 = p0 == null ? null : p0.next;
            }
            return result.next;
        } else {
            return head;
        }
    }
}