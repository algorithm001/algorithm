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
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        while(l1 != null && l2 != null){
            ListNode tempNode = new ListNode(0);
            if(l1.val < l2.val){
                tempNode.val = l1.val;
                l1 = l1.next;
            } else {
                tempNode.val = l2.val;
                l2 = l2.next;
            }
            current.next = tempNode;
            current = tempNode;
        }
        if(l1 == null){
            current.next = l2;
        }
        if(l2 == null){
            current.next = l1;
        }
        return dummyHead.next;      
    }
}
