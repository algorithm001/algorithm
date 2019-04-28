/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/20
 */
public class LeetCode_142_108 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null){
                return null;
            }
            ListNode slow = head;
            ListNode quick = head;
            while(slow != null && quick != null){
                slow = slow.next;
                quick = quick == null || quick.next == null ? null : quick.next.next;
                if(slow == quick){
                    break;
                }
            }

            if(slow == null || quick == null){
                return null;
            }
            slow = head;
            while(slow != quick){
                slow = slow.next;
                quick = quick.next;
            }
            return slow;
        }
    }
}
