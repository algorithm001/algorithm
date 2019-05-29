/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 不允许修改给定的链表。也就是不能在数据节点做标记，也不能修改链表节点指向。
        // 第一种解法哈希表，第二种解法快慢指针。
         
        // 1. 边界处理
        if(head == null ||  head.next == null){
             return null;
        }
        
        // 2. 加哨兵节点
        ListNode guard = new ListNode(-1);
        guard.next = head;
        
        // 3. 定义快慢指针
        ListNode fast = guard;
        ListNode slow = guard;
        
        // 4. 遍历，检查是否有环。
        //  - 要是没环的话，会直接抛出去
        //  - 要是有环的话，则快慢指针一定会相遇，退出循环
        while(true){
            if(fast.next == null || fast.next.next==null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        
        // 5. 查找环的位置
        slow = guard;
        while(slow != fast){
            slow = slow.next;
            fast= fast.next;
        }
        return slow;        
    }
}
