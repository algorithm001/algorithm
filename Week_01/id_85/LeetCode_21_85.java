public class LeetCode_21_85 {

}
/**
 * @Package:
 * @ClassName: LeetCode_21_85.LinkedListSortMerge
 * @Description: 有序链表合并为一个新的有序链表
 * @leetcode url :https://leetcode.com/problems/merge-two-sorted-lists
 * @Author: wangzhao
 * @Date: 2019-04-16 10:16:48
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class LinkedListSortMerge {


    /**
     *思路：
     * 1.两个链表同时移动比较，值大的结点暂停移动，直到该结点为较小值
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(-1);
        ListNode cur = node;
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }
            if (l1 == null) {
                cur.next = l2;
                break;
            }
            if (l2 == null) {
                cur.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return node.next;
    }


    public static void main(String[] args) {
        Integer[] arr = {0,1, 1, 3, 6, 7};
        Integer[] arr1 = {0,2, 3, 5, 6,8};

        //初始化一个无用结点。去除边界问题
        ListNode cur = new ListNode(-1);
        ListNode head1 = cur;

        for (Integer i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }


        //初始化一个无用结点。去除边界问题
        cur = new ListNode(-1);
        ListNode head2 = cur;

        for (Integer i : arr1) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        ListNode resultNode = new LinkedListSortMerge().mergeTwoLists(head1.next, head2.next);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }
}
