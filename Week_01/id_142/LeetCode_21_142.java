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
        ListNode ret = null;
        ListNode l = null;
        while (l1 != null || l2 != null) {
            ListNode curr;
            if (l1 == null) {
                curr = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                curr = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                curr = l1;
                l1 = l1.next;
            } else {
                curr = l2;
                l2 = l2.next;
            }
            if (ret == null) {
                ret = new ListNode(curr.val);
                l = ret;
            } else {
                l.next = new ListNode(curr.val);
                l = l.next;
            }
        }
        return ret;
    }
}
