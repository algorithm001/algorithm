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
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr = head;
        int i=1;
        head=head.next;
        while(curr.next!=null){
            if(curr.next.next==null&&i%2==0){
                return head;
            }
            ListNode node = curr.next;
            curr.next=curr.next.next;
            if(i%2==1){
                node.next=curr;
            }else{
                curr=node;
            }
            i++;
        }
        return head;
    }
}
