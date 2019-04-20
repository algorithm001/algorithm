public class LeetCode_24_85 {
}
/**
 * @Package:
 * @ClassName: LeetCode_24_85.LinkedListSwapPairs
 * @Description: 给定一个链表，两两交换其中相邻的结点 难度：中
 * @leetCode url:https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @Author: wangzhao
 * @Date: 2019-04-16 10:52:29
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class LinkedListSwapPairs {

    /**
     *思路：
     * 1.暂存前结点
     * 2.交换两个结点位置
     * 3.将前结点的下一结点指向交换后的两个的结点的第一个结点
     * 4.移动前结点到交换后的两个结点的第二个结点
     * 5.如果存在结点交换，并且头结点为空，保存头结点，用于函数返回
     * 6.移动head到下一对结点的第一个结点
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode prev = new ListNode(-1);
        ListNode result = null;

        while (head != null) {

            if (head.next == null) {
                break;
            }
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;

            prev.next = next;
            prev = head;

            if (result == null) {
                result = next;
            }

            head = head.next;

        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, 4, 6, 7, 8};

        //初始化一个无用结点。去除边界问题
        ListNode cur = new ListNode(-1);
        ListNode head = cur;

        for (Integer i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }


        ListNode resultNode = new LinkedListSwapPairs().swapPairs(head.next);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }
}