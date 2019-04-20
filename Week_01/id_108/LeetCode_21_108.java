/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/20
 */
public class LeetCode_21_108 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null){
                return l2;
            }
            if(l2 == null){
                return l1;
            }
            // 链表1的游标
            ListNode cur1 = l1;
            // 链表2的游标
            ListNode cur2 = l2;
            //合并后的链表的表头
            ListNode head = null;
            if(cur1.val < cur2.val){
                head = cur1;
                cur1 = cur1.next;
            }else{
                head = cur2;
                cur2 = cur2.next;
            }
            //将head指向null，防止指针影响
            head.next = null;
            // 合并后的链表的游标
            ListNode cur = head;
            while (cur1 != null && cur2 != null){
                if(cur1.val < cur2.val){
                    cur.next = cur1;
                    cur1 = cur1.next;
                }else{
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
                //游标后移，并指向空
                cur = cur.next;
                cur.next = null;
            }
            if(cur1 != null){
                cur.next = cur1;
            }
            if(cur2 != null){
                cur.next = cur2;
            }
            return head;
        }
    }
}
