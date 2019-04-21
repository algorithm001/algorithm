/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        // 1. 边界处理：链表为空或只有一个节点
        if(head == null || head.next == null){
            return head;
        }
        
        // 2. 定义 left 和 right 两个前后指针。
        ListNode left = head;
        ListNode right = head.next;
        
        // 3. 当 right 不为空时，进行如下操作：
        //  - 若两指针节点数据相同，则 right 移动，left 不动
        //  - 若两指针节点数据不同，则 left.next 指向 right，然后 left 和 right 都移动
        while(right!=null){
            if(left.val == right.val){
                right=right.next;
            }else{
                left.next = right;
                left = right;
                right = right.next;
            }
        }
        
        // 4. 边界处理：前面的循环终止条件是 right 为null，有两种情况：
        //  - left.next 为 null
        //  - left 及 到 null 前的节点数据相同
        //  so =>
        left.next = null;
        return head;
    }
}
