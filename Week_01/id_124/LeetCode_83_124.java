import common.ListNode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
