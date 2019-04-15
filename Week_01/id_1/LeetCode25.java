
class Solution {

    ListNode preGroupTail = null;
    ListNode result = null;

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) {
            return head;
        }

        int index = 1;
        ListNode groupHead = head;
        ListNode groupTail = head;

        while (true) {

            if (index != k) {
                groupTail = groupTail.next;
                if (groupTail != null) {
                    index ++;
                    continue;
                }else {
                    // 链表长度小于 K 的情况
                    if (this.preGroupTail != null) {
                        this.preGroupTail.next = groupHead;
                        break;
                    }else {
                        return head;
                    }
                }
            }else {
                ListNode node = this.swap(groupHead, groupTail);
                if (node == null) {
                    break;
                }
                groupHead = node;
                groupTail = node;
                index = 1;
            }
        }
        return result;
    }

    private ListNode swap(ListNode head, ListNode tail) {

        ListNode preNode = null;
        ListNode currentNode = head;
        while (currentNode != tail) {
            ListNode next = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = next;
        }

        ListNode node= currentNode.next;
        currentNode.next = preNode;

        if (this.preGroupTail != null) {
            this.preGroupTail.next = currentNode;
        }else {
            result = currentNode;
        }
        this.preGroupTail = head;
        return node;
    }
}
