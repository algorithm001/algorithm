/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/20
 */
public class LeetCode_83_108 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode pre = head;
            ListNode tmp = head.next;
            while(pre != null){
                if(tmp != null && pre.val == tmp.val){
                    pre.next = tmp.next;
                    tmp.next = null;
                    tmp = pre.next;
                } else {
                    pre = pre.next;
                    tmp = pre != null ? pre.next : null;
                }
            }
            return head;
        }
    }
}
