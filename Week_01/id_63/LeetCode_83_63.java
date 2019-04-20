/*
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            if (next != null && node.val == next.val) {
                node.next = next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
