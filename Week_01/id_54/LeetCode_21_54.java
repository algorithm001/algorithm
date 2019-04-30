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
        ListNode Newlist = new ListNode(0);
        ListNode l11 = l1;
        ListNode l22 = l2;
        ListNode newlist = Newlist;
        while(l11 != null && l22 != null){
            if(l11.val <= l22.val){
                newlist.next = l11;
                l11 = l11.next;
            }else {
                newlist.next = l22;
                l22 = l22.next;
            }
            newlist = newlist.next;
        }
        
        while(l11 != null){
            newlist.next = l11;
            l11 = l11.next;
            newlist = newlist.next;
        }
        
        while(l22 != null){
            newlist.next = l22;
            l22 = l22.next;
            newlist = newlist.next;
        }
        return Newlist.next;
    }
}