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
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            ListNode temp = cur.next;

            cur.next = temp.next;
            temp.next = cur;
            pre.next = temp;

            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}