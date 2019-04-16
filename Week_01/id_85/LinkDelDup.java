/**
 * @Package:
 * @ClassName: Solution
 * @Description: 删除排序链表中的重复元素
 * @Author: wangzhao
 * @Date: 2019-04-15 15:18:28
 * @Version: 1.0.0
 * @Since: 1.8
 **/
public class LinkDelDup {


    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode result = head;

        while (head.next != null) {
            /**
             * 当前节点与下一节点值比较
             * 如果相等，则将当前节点的下一节点指向下下节点
             */
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }
            /**
             * 比较当前节点与下一节点的值是否相等，
             * 如果相等则当前节点不移动到下一节点
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
         * 取出当前节点的下一节点
         */
        ListNode next = head.next;
        /**
         * 判断当前节点与下一节点的值是否相等
         */
        if (head.val == next.val) {
            /**
             * 如果相等，将当前节点的下一节点指向下一届节点的下一节点
             */
            head.next = next.next;
            /**
             * 递归调用
             */
            deleteDuplicates2(head);
        } else {
            /**
             * 当前节点与下一节点的值不相等，递归下一节点
             */
            deleteDuplicates2(next);
        }
        return head;
    }


    public static void main(String[] args) {


        Integer[] arr = {1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5};

        //初始化一个无用节点。去除边界问题
        ListNode cur = new ListNode(-1);
        ListNode head = cur;

        for (Integer i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        /**
         * 循环去重
         */
        ListNode resultNode = new LinkDelDup().deleteDuplicates(head.next);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
        System.out.println("----------------我是分隔符------------------");
        /**
         * 递归去重
         */
        resultNode = new LinkDelDup().deleteDuplicates2(head.next);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}