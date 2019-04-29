/**
  * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
  * 示例 1:
  * 输入: 1->1->2
  * 输出: 1->2
  * 示例 2:
  * 输入: 1->1->2->3->3
  * 输出: 1->2->3
*/

public class DeleteDuplicateNode {

	/**
     * @desc 发现上一种方法完全没有必要去那样，应为链表是已经排序好的了，并且已知前一个节点的当前的节点，可以直接进行比较
     * @annotation 注意在head为 null 的情况和链表只有一个节点的情况
     * @param head
     * @return
     */
    public static ListNode deleteDuplicatesV1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            if (pre == null || pre.val != current.val) {
                pre = current; // 保存上一节点，防止断链
                current = current.next;
            } else {
                pre.next = current.next;
                current = pre.next;
            }
        }
        return head;
    }
}
