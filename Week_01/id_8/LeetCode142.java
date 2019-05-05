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

        Set<ListNode> set = new HashSet<>();
        ListNode listNode = head;

        while (listNode.next != null) {
            if (set.contains(listNode)) {
                return listNode;
            } else {
                set.add(listNode);
                listNode = listNode.next;
            }
        }
        return null;
        
    }
}