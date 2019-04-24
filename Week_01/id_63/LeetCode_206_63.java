/*
https://leetcode-cn.com/problems/reverse-linked-list/
反转一个单链表。
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode node = head;
        ListNode next = null;
        while (true) {
            next = node.next;
            node.next = pre;
            if (next == null) {
                break;
            }
            pre = node;
            node = next;
        }
        return node;
    }
}
