import java.util.HashMap;

public class LeetCode_142_129 {
    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        HashMap<ListNode, Integer> map = new HashMap<>();
        int index = 0;
        ListNode result = null;
        while (head != null) {
            Integer value = map.get(head);
            if (value == null) {
                map.put(head, index);
                head = head.next;
            } else {
                result = head;
                break;
            }
        }
        return result;
    }
}
