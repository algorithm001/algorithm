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
        ListNode pre = head;
        ListNode pre_next = pre.next;
        if(pre == null || pre_next == null){
            return head;
        }
        while(pre_next != null){
            if(pre.val == pre_next.val){
                pre_next = pre_next.next;
                pre = pre_next;
            }else{
                pre = pre_next;
                pre_next = pre_next.next;
            }
        }
        return head;
        
    }
}
