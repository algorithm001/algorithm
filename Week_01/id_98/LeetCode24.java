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
        ListNode first = head;
        ListNode second = first.next;
        first.next = second.next;
        second.next = first;
        head = second;
        ListNode pre = first;
        first = first.next;
        while(first != null && first.next != null){
            second = first.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
            first = first.next;
        }
        return head;
    }
}