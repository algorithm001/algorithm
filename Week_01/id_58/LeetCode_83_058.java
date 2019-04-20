package algorithm.Week_01.id_58;

/**
 *
 * 83. Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * 分析：
 * 这里是一个排好序的数组，这样的话，我们就省掉了很多的事情，
 * 只要拿一个元素和他后边的元素比较即可，如果相同则next指针指向它后边的元素，
 * 如果不相同，则接着考察下一个元素
 *
 * @auther: guangjun.ma
 * @date: 2019/4/17 17:36
 * @version: 1.0
 */
public class LeetCode_83_058 {

    /**
     * ListNode节点定义
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            //1、定义一个current指针，用于操作当前元素
            //head指针不动，只是记录链表头结点
            ListNode current = head;
            //当前节点非空，当前结点的下一个结点也不为空，即不是空结点也不是最后的结点
            while (current != null && current.next != null){
                //当前节点等于下一个结点的值
                if (current.val == current.next.val){
                    //当前结点的next指针，指向当前结点的下一个结点的下一个结点
                    //即next指针掉过一个结点，指向它后边的一个结点
                    current.next = current.next.next;
                }else{
                    //如果不相等，接着考察下一个元素，current指针后移一位
                    current = current.next;
                }
            }
            //返回头结点
            return head;
        }
    }

}
