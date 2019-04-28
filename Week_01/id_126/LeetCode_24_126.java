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
        //判断当前值和下一个值是否为空
        //不为空 交换
        //为空 不动
        
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode listNode=new ListNode(0);
        listNode.val=head.val;
        listNode.next=swapPairs(head.next.next);
        head=head.next;
        head.next=listNode;
        return head;
        
    }
}