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
        ListNode head = new ListNode(0);
        ListNode pos = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pos.next = l1;
                l1 = l1.next;
            }else{
                pos.next = l2;
                l2 = l2.next;
            }
            pos = pos.next;
        }
        if(l1 == null && l2 != null){
            pos.next = l2;
        }else if(l1 != null && l2 == null){
            pos.next = l1;
        }
        return head.next;

    }
}