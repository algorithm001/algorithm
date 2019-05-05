/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        ListNode L1Node = new ListNode(0);
        L1Node.next = l1;
        l1 = L1Node;
    
        while (L1Node.next != null && l2 != null) {
            if (l2.val <= L1Node.next.val) {
                // 将l2当前节点插入l1
                ListNode tmpN = l2.next;
                l2.next = L1Node.next;
                L1Node.next = l2;
                
                L1Node = L1Node.next;
                l2 = tmpN;
            } else {
                L1Node = L1Node.next;
            }
        }
        if (l2 != null) {
            L1Node.next = l2;
        }
        return l1.next;
    }
}