package com.shufeng.algorithm.d0_;

import com.shufeng.algorithm.dto.ListNode;

/**
 * @author gsf
 */
public class LeetCode_83_30 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode head1 = head;
        while (head1 != null) {
            if (head1.next != null && head1.val == head1.next.val) {
                head1.next = head1.next.next;
                continue;
            }
            head1 = head1.next;
        }
        return head;

    }
}
