public class LeetCode_83_85 {
}

/**
 * @Package:
 * @ClassName: LinkedListDelDup
 * @Description: 删除排序链表中的重复元素
 * @leetcode url :https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * @Author: wangzhao
 * @Date: 2019-04-15 15:18:28
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class LinkedListDelDup {


    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode result = head;

        while (head.next != null) {
            /**
             * 当前结点与下一结点值比较
             * 如果相等，则将当前结点的下一结点指向下下结点
             */
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }
            /**
             * 比较当前结点与下一结点的值是否相等，
             * 如果相等则当前结点不移动到下一结点
             * 循环上一步判断
             */
            if (head.next != null && head.val != head.next.val) {
                head = head.next;
            }
        }

        return result;
    }

    public ListNode deleteDuplicates2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        /**
         * 取出当前结点的下一结点
         */
        ListNode next = head.next;
        /**
         * 判断当前结点与下一结点的值是否相等
         */
        if (head.val == next.val) {
            /**
             * 如果相等，将当前结点的下一结点指向下一届结点的下一结点
             */
            head.next = next.next;
            /**
             * 递归调用
             */
            deleteDuplicates2(head);
        } else {
            /**
             * 当前结点与下一结点的值不相等，递归下一结点
             */
            deleteDuplicates2(next);
        }
        return head;
    }


    public static void main(String[] args) {


        Integer[] arr = {1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5};

        //初始化一个无用结点。去除边界问题
        ListNode cur = new ListNode(-1);
        ListNode head = cur;

        for (Integer i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        /**
         * 循环去重
         */
        ListNode resultNode = new LinkedListDelDup().deleteDuplicates(head.next);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
        System.out.println("----------------我是分隔符------------------");
        /**
         * 递归去重
         */
        resultNode = new LinkedListDelDup().deleteDuplicates2(head.next);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }
}