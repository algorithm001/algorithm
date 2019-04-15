class Solution {

    ListNode prePairTail = null;

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode result = head.next;
        
        ListNode node = head;
        ListNode next = head.next;
        while (node != null && next != null) {

            node = swap(node, next);

            if (node == null) {
                break;
            }
            next = node.next;
        }
        return result;

    }

    private ListNode swap(ListNode node, ListNode next) {

        ListNode tmpNext = next.next;
        next.next = node;
        node.next = tmpNext;
        if (prePairTail != null) {
            prePairTail.next = next;
        }
        prePairTail = node;
        return tmpNext;
    }

}
