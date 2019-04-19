public class LeetCode_142_044 {
    public ListNode Solution(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode find = head;
                while (find != slow) {
                    find = find.next;
                    slow = slow.next;
                }
                return find;
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
