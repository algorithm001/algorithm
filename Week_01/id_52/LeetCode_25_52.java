/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        for(int i=0;i<k;i++){
            if(curr==null){
                return head;
            }
            curr=curr.next;
        }
        curr = head;
        ListNode next = null;
        ListNode perv = null;
        ListNode nextHead =curr;
        for(int i=0;i<k;i++){
            nextHead=nextHead.next;
        }
        for(int i=0;i<k;i++){
            next=curr.next;
            if(i==0){
                curr.next = (reverseKGroup(nextHead,k));
            }else{
                curr.next=perv;
            }
            if(i==k-1){
                head=curr;
            }
            perv=curr;
            curr=next;
        }
        return head;
    }
}
