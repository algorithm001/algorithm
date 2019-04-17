/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 *
 * <p> 链表
 * <p> 简单
 *
 * @author Yunjian Liu
 * @date 2019/04/17
 */
public class LeetCode_21_14 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        //listNode1.next.next = new ListNode(4);
        listNode1.next.next = new ListNode(2);
        listNode1.next.next.next = new ListNode(2);
        listNode1.next.next.next.next = new ListNode(4);
        listNode1.next.next.next.next.next = new ListNode(5);
        listNode1.next.next.next.next.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = solution.mergeTwoLists(listNode1, listNode2);

        while (listNode3 != null) {
            System.out.print(listNode3.val + "->");
            listNode3 = listNode3.next;
        }
    }
}

class Solution {
    /**
     * <pre>
     *     +-----+     +-----+     +-----+
     *     |  1  | --> |  2  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *
     *     +-----+     +-----+     +-----+
     *     |  1  | --> |  3  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *
     *       cur
     *        |
     *     listNode
     *        |
     *     +-----+     +-----+     +-----+
     *     |  1  | --> |  2  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *        p
     *        |
     *     +-----+     +-----+     +-----+
     *     |  1  | --> |  3  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *
     *
     *     listNode      tmp
     *        |           |
     *     +-----+     +-----+     +-----+
     *     |  1  | --> |  2  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *       cur
     *        |
     *        p
     *        |
     *     +-----+     +-----+     +-----+
     *     |  1  | --> |  3  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *
     *     listNode       p
     *        |           |
     *     +-----+     +-----+     +-----+
     *     |  1  |     |  2  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *        |
     *        |
     *       cur
     *        |
     *     +-----+     +-----+     +-----+
     *     |  1  | --> |  3  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *
     *
     *
     *     listNode       p
     *        |           |
     *     +-----+     +-----+     +-----+
     *     |  1  |     |  2  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *        |
     *        |
     *       cur          tmp
     *        |           |
     *     +-----+     +-----+     +-----+
     *     |  1  | --> |  3  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *
     *     listNode       p
     *        |           |
     *     +-----+     +-----+     +-----+
     *     |  1  |     |  2  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *        |           ^
     *        |           |
     *       cur          |           tmp
     *        |           |           |
     *     +-----+        |        +-----+     +-----+
     *     |  1  | -->----         |  3  | --> |  4  |
     *     +-----+                 +-----+     +-----+
     *
     *
     *     listNode      cur
     *        |           |
     *     +-----+     +-----+     +-----+
     *     |  1  |     |  2  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *        |           ^
     *        |           |
     *       cur          |           p
     *        |           |           |
     *     +-----+        |        +-----+     +-----+
     *     |  1  | -->----         |  3  | --> |  4  |
     *     +-----+                 +-----+     +-----+
     *
     *
     *     listNode      cur         tmp
     *        |           |           |
     *     +-----+     +-----+     +-----+
     *     |  1  |     |  2  | --> |  4  |
     *     +-----+     +-----+     +-----+
     *        |           ^
     *        |           |
     *       cur          |           p
     *        |           |           |
     *     +-----+        |        +-----+     +-----+
     *     |  1  | -->----         |  3  | --> |  4  |
     *     +-----+                 +-----+     +-----+
     *
     *
     *     listNode      cur                tmp
     *        |           |                  |
     *     +-----+     +-----+            +-----+
     *     |  1  |     |  2  | -->-----   |  4  |
     *     +-----+     +-----+        |   +-----+
     *        |           ^           |
     *        |           |           |
     *       cur          |           p
     *        |           |           |
     *     +-----+        |        +-----+     +-----+
     *     |  1  | -->----         |  3  | --> |  4  |
     *     +-----+                 +-----+     +-----+
     *
     *
     *     listNode                          p
     *        |                              |
     *     +-----+     +-----+            +-----+
     *     |  1  |     |  2  | -->-----   |  4  |
     *     +-----+     +-----+        |   +-----+
     *        |           ^          cur
     *        |           |           |
     *       cur          |           |
     *        |           |           |
     *     +-----+        |        +-----+     +-----+
     *     |  1  | -->----         |  3  | --> |  4  |
     *     +-----+                 +-----+     +-----+
     *
     *
     *     listNode                          p
     *        |                              |
     *     +-----+     +-----+            +-----+
     *     |  1  |     |  2  | -->-----   |  4  |
     *     +-----+     +-----+        |   +-----+
     *        |           ^           |
     *        |           |           |
     *       cur          |           |          cur
     *        |           |           |           |
     *     +-----+        |        +-----+     +-----+
     *     |  1  | -->----         |  3  | --> |  4  |
     *     +-----+                 +-----+     +-----+
     *
     * </pre>
     *
     * 思路：
     * <pre>
     *    用一个指针，指向当前节点(cur)。另一个指针(p)指向，另一个链还未合并进来的第一个位置。
     *    1. 比较p的cur的next，如果p更小，那么就把p接到合并链中。
     *
     *    如果一个链已经比较完，把p链直接接到最后
     * </pre>
     * <p> 会破坏原来的链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode listNode = l1;

        ListNode p = l2;
        if (l2.val < l1.val) {
            listNode = l2;
            p = l1;
        }
        ListNode cur = listNode;

        while (cur.next != null) {
            if (p.val < cur.next.val) {
                ListNode tmp = cur.next;
                cur.next = p;
                cur = p;
                p = tmp;
            } else {
                cur = cur.next;
            }
        }
        cur.next = p;

        return listNode;
    }
}
