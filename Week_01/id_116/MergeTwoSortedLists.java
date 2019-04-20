/**
 * TODO
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/4/20
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dummyHead.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

