//https://leetcode.com/problems/remove-duplicates-from-sorted-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = head, cur = head.next;
        while (cur != null) {
            if (cur.val == prev.val) {
                prev.next = cur.next;
                cur.next = null;
                cur = prev.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return head;
    }
}