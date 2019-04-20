/*
https://leetcode-cn.com/problems/linked-list-cycle-ii/
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
说明：不允许修改给定的链表。
*/
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
        if (head == null || head.next == null) {
            return null;
        }
        ListNode node = head;
        ListNode node2 = head;
        while (true) {
            node = node.next;
            node2 = node2.next;
            if (node2 == null) {
                return null;
            } else {
                node2 = node2.next;
                if (node2 == null) {
                    return null;
                }
                if (node2 == node) {
                    break;
                }
            }
        }
        node = head;
        while (node != node2) {
            node = node.next;
            node2 = node2.next;
        }
        return node;
    }
}
