//https://leetcode.com/problems/merge-two-sorted-lists/
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
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode master = new ListNode(0), slave = l2;
        master.next = l1;
        ListNode head = master, tmp = null;
        while (slave != null) {
            if (master.next == null) {
                tmp = slave.next;
                master.next = slave;
                slave.next = null;
                slave = tmp;
                master = master.next;
            } else if (slave.val < master.next.val) {
                tmp = slave.next;
                slave.next = master.next;
                master.next = slave;
                slave = tmp;
                master = master.next;
            } else {
                master = master.next;
            }
        }
        return head.next;
    }
}