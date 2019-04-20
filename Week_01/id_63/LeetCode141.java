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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        boolean result = false;
        ListNode node = head;
        ListNode node2 = head;
        while (node != null && node2 != null) {
            node = node.next;
            node2 = node2.next;
            if (node2 == null) {
                break;
            } else {
                node2 = node2.next;
                if (node2 == node) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
