/**
 * @Package:
 * @ClassName: LinkedListReverseKGroup
 * @Description: 给出一个链表，每 k 个结点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果结点总数不是 k 的整数倍，那么将最后剩余结点保持原有顺序。
 * 难度：困难
 * @leetcode url :https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @Author: wangzhao
 * @Date: 2019-04-16 14:35:49
 * @Version: 1.0.0
 * @Since: 1.8
 **/
public class LinkedListReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 0) {
            return null;
        }
        if (k == 1) {
            return head;
        }

        int i = 1;

        ListNode oldList = head;

        ListNode cursor = head;

        ListNode first = head;

        ListNode result = null;

        ListNode lastCursor = new ListNode(-1);

        boolean isDiv = false;
        while (cursor.next != null) {
            i++;
            ListNode _next = cursor.next;
            cursor.next = _next.next;
            _next.next = first;
            first = _next;
            lastCursor.next = first;

            isDiv = false;
            if (i % k == 0) {
                lastCursor = cursor;
                cursor = cursor.next;
                if (result == null) {
                    result = first;
                }
                isDiv = true;
                first = cursor;
                i++;
                if (cursor == null) {
                    break;
                }
            }

        }
        if (result == null && !isDiv) {
            result = oldList;
        }

        if (result != null && !isDiv) {
            cursor = first;
            while (cursor.next != null) {
                ListNode _next = cursor.next;
                cursor.next = _next.next;
                _next.next = first;
                first = _next;
                lastCursor.next = first;
            }
        }

        return result;
    }

    public ListNode reverse(ListNode head, ListNode end) {


        ListNode cursor = head;

        ListNode first = head;
        while (cursor.next != null) {

            ListNode _next = cursor.next;
            cursor.next = _next.next;
            _next.next = first;
            first = _next;
            if (cursor.next == end) {
                break;
            }
        }

        return first;
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Integer[] arr1 = {0, 1};

        //初始化一个无用结点。去除边界问题
        ListNode cur = new ListNode(-1);
        ListNode head = cur;

        ListNode puase = null;
        int t = 0;
        for (Integer i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
//            t++;
//            if (t == 4) {
//                puase = cur;
//
//            }
        }


        int k = 1;

//        ListNode resultNode = new LinkedListReverseKGroup().reverse(head.next,puase);
        ListNode resultNode = new LinkedListReverseKGroup().reverseKGroup(head.next, k);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }
}
