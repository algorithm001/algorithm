package leetcode.Algorithms._1_100._83_RemoveDuplicatesFromSortedList;

/**
 * Created by jialei.zou on 2019/4/19 .
 * ref:
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 Example 1:

 Input: 1->1->2
 Output: 1->2
 Example 2:

 Input: 1->1->2->3->3
 Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next;
            while(next != null && next.val == cur.val){
                cur.next = cur.next.next;
                next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RemoveDuplicatesFromSortedList remove = new RemoveDuplicatesFromSortedList();
        ListNode result = remove.deleteDuplicates(node1);
        while (result!= null){
            System.out.printf(result.val+",");
            result = result.next;
        }

    }
}
