/**
*  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
*  <p> 链表
*  <p> 简单
*
*  <p> 这个比较简单，但是正因为简单，所以大家使用的方法都类似，有什么优化发方案？
* @author Yunjian Liu
* @date 2019/04/17 
*/
public class LeetCode_83_14 {
    public static void main(String [] args) {
        Solution solution = new Solution();

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(1);
        //listNode1.next.next = new ListNode(4);
        listNode1.next.next = new ListNode(2);
        listNode1.next.next.next = new ListNode(2);
        listNode1.next.next.next.next = new ListNode(4);
        listNode1.next.next.next.next.next = new ListNode(5);
        listNode1.next.next.next.next.next.next = new ListNode(5);

        ListNode listNode3 = solution.deleteDuplicates(listNode1);

        while (listNode3 != null) {
            System.out.print(listNode3.val + "->");
            listNode3 = listNode3.next;
        }
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null) {
                return head;
            }
            ListNode cur = head;

            while (cur.next != null) {
                if(cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                }else {
                    cur = cur.next;

                }
            }

            return  head;
        }
    }
}
