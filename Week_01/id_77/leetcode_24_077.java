/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head.next; 
        ListNode p=fastPointer.next;
        
        fastPointer.next = slowPointer;    
        slowPointer.next =p;
            
        if(p == null){
            return fastPointer;
        }
        head = fastPointer;
        ListNode headPointer = fastPointer.next;
        
        slowPointer = p;
        fastPointer = p.next;
        
        while(slowPointer != null && fastPointer !=null){
            p=fastPointer.next;
            fastPointer.next = slowPointer;    
            slowPointer.next =p;
            headPointer.next = fastPointer;
            headPointer = fastPointer.next;
            slowPointer = p;
            if(p!=null){               
                fastPointer = p.next;
            }else{
                fastPointer= null;
            }
        }
        return head;
    }
}