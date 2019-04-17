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

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode mergeCur = null;
        ListNode mergeHead = null;

        if (cur1.val <= cur2.val) {
            mergeCur = cur1;
            mergeHead = cur1;
            cur1 = cur1.next;
        } else {
            mergeCur = cur2;
            mergeHead = cur2;
            cur2 = cur2.next;
        }

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                mergeCur.next = cur1;
                cur1 = cur1.next;
            } else {
                mergeCur.next = cur2;
                cur2 = cur2.next;
            }
            mergeCur=mergeCur.next;
        }

        if (cur1 != null) {
            mergeCur.next = cur1;
        }

        if (cur2 != null) {
            mergeCur.next = cur2;
        }

        return mergeHead;
    }

    /**
     * 递归思路没有想到，参考网上的相关答案，理解之后写出
     */
    public ListNode mergeTowListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;


        if (l1.val <= l2.val) {
            ListNode head = l1;
            head.next = mergeTowListsRecursive(l1.next, l2);
            return head;
        } else {
            ListNode head = l2;
            head.next = mergeTowListsRecursive(l1, l2.next);
            return head;
        }
    }
}