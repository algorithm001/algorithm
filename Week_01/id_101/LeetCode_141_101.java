package linkedlist.linkedListCycle;

import linkedlist.ListNode;

/**
 * @author Seina
 * @version 2019-01-14 20:37:52
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            low = low.next;
            if (fast == low){
                return true;
            }
        }
        return false;
    }
}