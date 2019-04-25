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
        if (head==null) return head;
        //相当于指针 
        ListNode data = head ;
        
        while(data.next != null && data != null){
            if (data.val == data.next.val){
                data.next = data.next.next;
            } else {
                data = data.next; 
            }
        }
        return head ; 
    }
}
