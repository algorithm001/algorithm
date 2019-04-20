/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;
        while(current!=null&&current.next!=null){
            ListNode next=current.next;
            if(current.val==next.val){
                current.next=next.next;
            }else{
                current=current.next;
            }  
        }
        return head;
    }
}