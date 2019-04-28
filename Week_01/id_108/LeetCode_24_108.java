/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/20
 */
public class LeetCode_24_108 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution1 {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            //标识要交换的第一个节点
            ListNode first = head;
            //标识要交换的第二个节点
            ListNode second = head.next;
            //标识下一组要交换的节点对
            ListNode cur = second.next;
            //交换
            first.next = cur;
            second.next = first;
            head = second;
            ListNode pre = first;
            //下一组
            first = cur;
            second = cur == null || cur.next == null ? null : cur.next;
            cur = second == null ? null : second.next;
            while(first != null && second != null){
                //交换
                first.next = cur;
                second.next = first;
                pre.next = second;
                pre = first;
                //下一组
                first = cur;
                second = cur == null || cur.next == null ? null : cur.next;
                cur = second == null ? null : second.next;
            }
            return head;
        }
    }

    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            //标识要交换的第一个节点
            ListNode first = head;
            //标识要交换的第二个节点
            ListNode second = head.next;
            //标识下一组要交换的节点对
            ListNode cur = second.next;
            //初始化前节点
            ListNode pre = null ;
            //第一次交换
            first.next = cur;
            second.next = first;
            head = second;
            while(true){
                pre = first;
                first = cur;
                second = cur == null || cur.next == null ? null : cur.next;
                cur = second == null ? null : second.next;
                if(first == null || second == null){
                    break;
                }
                swap(pre,first,second,cur);
            }
            return head;
        }

        private void swap(ListNode pre,ListNode first,ListNode second,ListNode cur){
            //交换
            first.next = cur;
            second.next = first;
            pre.next = second;
        }
    }
}
