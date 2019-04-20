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
        ListNode node = head;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            if (next != null && node.val == next.val) {
                node.next = next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
