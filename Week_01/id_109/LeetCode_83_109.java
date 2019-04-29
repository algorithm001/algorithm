/**
 * @Auther: quanhc
 * @Date: 2019-04-20 21:17
 * @Description:
 */
public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        if (head.val == head.next.val){
            head.next = head.next.next;
            deleteDuplicates(head);

        }
        deleteDuplicates(head.next);
        return head;
    }
}
