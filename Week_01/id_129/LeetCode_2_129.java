public class LeetCode_2_129 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cursor = head;
        while (cursor != null && cursor.next != null) {
            if (cursor.val == cursor.next.val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }
        return head;
    }
}
