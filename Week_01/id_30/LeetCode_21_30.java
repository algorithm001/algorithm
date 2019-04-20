package com.shufeng.algorithm.d0_;

import com.shufeng.algorithm.dto.ListNode;

/**
 * @author gsf
 */
public class LeetCode_21_30 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode first = node;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        node.next = l1 != null ? l1 : l2;
        return first.next;
    }
}
