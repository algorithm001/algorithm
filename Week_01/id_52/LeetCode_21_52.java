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
        ListNode r=new ListNode(0);
        ListNode curr=r;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        if(l1!=null){
            curr.next=l1;
        }
        if(l2!=null){
            curr.next=l2;
        }
        r=r.next;
        return r;
    }
}
