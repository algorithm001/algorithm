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
        if(head == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            int temp = curr.next.val;
            curr.next.val = curr.val;
            curr.val = temp;
            if(curr.next.next == null){
                return head;
            } else {
                curr = curr.next.next;
            }
        }
        return head;
    }
}
