//https://leetcode.com/problems/swap-nodes-in-pairs/
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
        if (head == null || head.next == null)
            return head;
        ListNode prev = head, cur = head.next, after = null;
        ListNode sentinel = new ListNode(0), ret = head.next;
        sentinel.next = head;
        while (prev != null && cur != null ) {
            after = cur.next;
            prev.next = cur.next;
            cur.next = prev;
            sentinel.next = cur;
            sentinel = sentinel.next.next;
            prev = after;
            if (after != null)
                cur = after.next;
        }
        return ret;
    }
}