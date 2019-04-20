/*
https://leetcode-cn.com/problems/linked-list-cycle/
给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        boolean result = false;
        ListNode node = head;
        ListNode node2 = head;
        while (node != null && node2 != null) {
            node = node.next;
            node2 = node2.next;
            if (node2 == null) {
                break;
            } else {
                node2 = node2.next;
                if (node2 == node) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
