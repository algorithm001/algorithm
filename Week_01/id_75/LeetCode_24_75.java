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
        if(head == null || head.next == null) return head;
        ListNode list = head.next;
        head.next = swapPairs(list.next);
        list.next = head;
        return list;
    }
}