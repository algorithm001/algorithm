/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author hewei
 * @date 2019/4/19 23:26
 */
public class LeetCode_83_53 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
