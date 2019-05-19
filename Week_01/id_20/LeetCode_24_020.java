/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode h = head;

        while (h != null) {
            if (h != null && h.next != null) {
                ListNode tmp = h.next;
                //p指向两个节点中的第二个节点
                p.next = tmp;
                //交换位置
                h.next = h.next.next;
                tmp.next = h;

                //继续遍历
                p = p.next.next;
                h = h.next;
            } else {
                p.next = h;
                h = h.next;
            }
        }
        return dummy.next;
    }
}
