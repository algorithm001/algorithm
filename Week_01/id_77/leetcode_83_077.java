/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;

       while(pointer!=null){
            if(pointer.next!=null && pointer.val== pointer.next.val){
                pointer.next = pointer.next.next;
            }else{
               pointer = pointer.next; 
            } 
           
       }
        return head;
    }
}