
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

            if (index != k) { // 查找 k 个节点中的 head 和 tail 节点
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
                // 个数达到 k 时执行交换，返回下一组的 head 节点
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

        // 反转链表
        ListNode preNode = null;
        ListNode currentNode = head;
        while (currentNode != tail) {
            ListNode next = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = next;
        }

        // 当前组的 tail 节点执行 swap
        ListNode node= currentNode.next;
        currentNode.next = preNode;

        // 反转完成，将上一组的 tail 节点指向当前组的 head 节点
        // 第一次反转时上一组 tail 为 null，因此要执行判空操作
        if (this.preGroupTail != null) {
            this.preGroupTail.next = currentNode;
        }else {
            // 上一组的 tail 为空说明是第一组执行交换
            // 结果一定是第一组交换后的 head 节点
            result = currentNode;
        }
        this.preGroupTail = head;
        return node;
    }
}
