public class LeetCode_24_129 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = swapPairs(head.next.next);
        ListNode cur = head.next;
        head.next = node;
        cur.next = head;
        return cur;
    }
}
