/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode result = new ListNode(0);
        ListNode n0 = result;
        while (n1 != null && n1 != null) {
            //System.out.println("n1-----" + n1.val + "--------n2-------" + n2.val
             if (n1.val < n2.val) {
                n0.next = new ListNode(n1.val);
                n1 = n1.next;
             } else {
                n0.next = new ListNode(n2.val);
                n2 = n2.next; 
            }
            
            n0 = n0.next;
        }
        if(n1 != null) n0.next = n1;
        else n0.next = n2;
        return result.next;
    }
}
