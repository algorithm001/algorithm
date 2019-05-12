/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/20
 */
public class LeetCode_25_108 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(k == 1){
                return head;
            }
            if(head == null){
                return head;
            }
            ListNode tail = needReverse(head,k);
            if(tail == null){
                return head;
            }
            //下一组要翻转的起点
            ListNode nextFirst = tail.next;
            tail.next = null;
            ListNode[] pair = reverse(head);
            head = pair[0];
            ListNode lastTail = pair[1];
            //翻转起点
            ListNode reverseStart = nextFirst;
            while(true){
                tail = needReverse(nextFirst,k);
                if(tail == null){
                    lastTail.next = nextFirst;
                    break;
                }
                //翻转起点
                reverseStart = nextFirst;
                //跳到未来的下一组
                nextFirst = tail.next;
                tail.next = null;
                pair = reverse(reverseStart);
                lastTail.next = pair[0];
                lastTail = pair[1];
            }
            return head;
        }

        //判断链表是否可以翻转,如果可以翻转，则返回翻转链表的最后一个节点
        private ListNode needReverse(ListNode head,int k){
            int i = 1;
            ListNode cur = head;
            while(i<k && cur != null && cur.next != null){
                cur = cur.next;
                i++;
            }
            return i == k ? cur : null;
        }

        //返回翻转后的链表的首尾对
        private ListNode[] reverse(ListNode head){
            ListNode pre = head;
            ListNode cur = head.next;
            ListNode tmp = cur == null ? null : cur.next;
            head.next = null;

            while(cur != null){
                cur.next = pre;
                pre = cur;
                cur = tmp;
                tmp = tmp == null ? null : tmp.next;
            }
            return new ListNode[]{pre,head};
        }
    }

}
