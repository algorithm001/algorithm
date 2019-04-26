/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
   
    //排序好的链表 所以解题思路变得简单了
    //每一个和他的next对比，如果有相同的，就直接把当前的换成下一个node
    //如果传进来为空，或者传进来的下一个为空就没有必要继续循环了
    //[1,2,1,3,3]
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null||head.next==null){
            return head;
        }
        
        
       if(head.next!=null){
            head.next=deleteDuplicates(head.next);
        }
        
        if(head.val==head.next.val){
            head=head.next;
        }

        return head;
    }
}