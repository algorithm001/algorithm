/*
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 
 * @author apple
 * @desc 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例： 输入：1->2->4, 1->3->4
 *       输出：1->1->2->3->4->4
 */
public class MergeTwoListNode {

    // @desc 刚开始是有两种思路吧： 1. 将其中一个链表的数据插入到另一个列表之中 2. 重新定义一个链表将其加入。
    // 我使用的是第二种方式
    // 注意点：在编写代码的时候遇到了很多坑吧，应该就是自己平时练的太少，很多地方刚开始都没有想到。
    // 1. 要定义两个节点，一个节点用来保存合并生成的 头结点 head，一个节点负责去合并两个链表；我一开始只定义了一个节点
    // 2. head = new ListNode(l1.val); 这里赋值时，我最开始 是这样赋值的 head =
    // list，这里傻了，忘了链表的指针了，导致后边赋值时，直接把好多的值都覆盖掉了
    // 3. 还有一个问题就是，赋值后一定要记得 continue

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = null;
        ListNode pre = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (pre == null) {
                    head = new ListNode(l1.val);
                    pre = head;
                } else {
                    pre.next = new ListNode(l1.val);
                    pre = pre.next;
                }
                l1 = l1.next;
                continue;
            }
            if (l2.val < l1.val) {
                if (pre == null) {
                    head = new ListNode(l2.val);
                    pre = head;
                } else {
                    pre.next = new ListNode(l2.val);
                    pre = pre.next;
                }
                l2 = l2.next;
                continue;
            }
        }
        if (l1 == null)
            pre.next = l2;
        if (l2 == null)
            pre.next = l1;
        return head;
    }
}
