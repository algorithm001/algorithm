import common.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy  = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next;
            ListNode nextNext = cur.next.next;
            next.next = nextNext.next;
            nextNext.next = next;
            cur.next = nextNext;
            cur = nextNext.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SwapPairs swapPairs = new SwapPairs();
        swapPairs.swapPairs(node1);
    }

}
