/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建一个新的listnode
        //两个有序的listnode每个取一个，比较，并加入新的Listnode
        ListNode listNode = new ListNode(0);
        ListNode current = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                //l1加入listnode  l1位置后移
                current.next = l1;
                current = l1;
                l1 = l1.next;

            } else {
                //l2加入listnode  l2位置后移
                current.next = l2;
                current = l2;
                l2 = l2.next;

            }

        }

        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }

        return listNode.next;
    }
}