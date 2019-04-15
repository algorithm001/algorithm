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
        // 换个思路，用哈希表
         
        // 1. 边界处理
        if(head == null ||  head.next == null){
             return null;
        }
        
        // 2. 定义哈希表
        HashSet<ListNode> hashSet = new HashSet<>();
        
        // 3. 加哨兵节点和临时节点
        ListNode guard = new ListNode(-1);
        guard.next = head;
        ListNode cur = guard;
        
        // 4. 访问过则直接返回，没有则加进去。
        while(null != cur.next){
            if(hashSet.contains(cur.next)){
                return cur.next;
            }
            cur = cur.next;
            hashSet.add(cur);
        }
        
        // 5. 到最后都没找到，则无环
        return null;
    }
}
