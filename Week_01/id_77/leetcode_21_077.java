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
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode listNew ;
        if(p1.val<p2.val){
            listNew = new ListNode(p1.val);
            p1 = p1.next;
        }else{
            listNew = new ListNode(p2.val);
            p2 = p2.next;
        }
        ListNode p=listNew;
        

        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            }else{
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p = p.next;
             
        }
        
        if(p1==null){
            p.next = p2;
        }else{
            p.next = p1;
        }
        
        return listNew;
        
    }
}