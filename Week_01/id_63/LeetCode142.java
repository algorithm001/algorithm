/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode node = head;
        ListNode node2 = head;
        while (true) {
            node = node.next;
            node2 = node2.next;
            if (node2 == null) {
                return null;
            } else {
                node2 = node2.next;
                if (node2 == null) {
                    return null;
                }
                if (node2 == node) {
                    break;
                }
            }
        }
        node = head;
        while (node != node2) {
            node = node.next;
            node2 = node2.next;
        }
        return node;
    }
}
