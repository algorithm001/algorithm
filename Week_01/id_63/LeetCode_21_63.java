/*
https://leetcode-cn.com/problems/merge-two-sorted-lists/
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = null;
        ListNode tail = null;
        ListNode node = null;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node = node1;
                node1 = node1.next;
            } else {
                node = node2;
                node2 = node2.next;
            }
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        if (node1 != null) {
            tail.next = node1;
            return head;
        }
        if (node2 != null) {
            tail.next = node2;
        }
        return head;
    }
}
