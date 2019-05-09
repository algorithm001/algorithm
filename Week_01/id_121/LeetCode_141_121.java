/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
            if(fast == null){
                return null;
            }

            fast = fast.next;
            if(fast == slow){
                meet = fast;
                break;
            }
        }
        while(meet != null && head != null){
            if(meet == head){
                return meet;
            }
            meet = meet.next;
            head = head.next;
        }
        return null;


    }
}