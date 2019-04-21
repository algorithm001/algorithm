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
        ListNode ref = head;
        while (ref != null && ref.next != null) {
            if (ref.val == ref.next.val) {
                ref.next = ref.next.next;
            } else {
                ref = ref.next;
            }
        }
        return head;


    }

    /**
     * 自己的做法，略显丑陋
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-99999);
        ListNode cur = dummyHead, p = head;
        cur.next = head;

        while(p != null) {
            while( p != null && cur.val == p.val) {
                p = p.next;
            }
            if(p == null) {
                cur.next = null;
            } else {
                cur.next = p;
                cur = cur.next;
            }
        }
        return dummyHead.next;


    }
}