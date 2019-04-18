/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        // 1. 边界值处理：空指针、一个节点、k小于等于1
        if(head==null || head.next==null || k<=1){
            return head;
        }
        
        // 2. 加哨兵节点
        ListNode guard = new ListNode(0);
        guard.next = head;
        
        // 3. 左侧已翻转完链表的尾节点，并将其指向 null，避免产生环
        ListNode left = guard;
        left.next = null;
        
        // 4. head 不为 null，则持续翻转
        while(head!=null){
            
            // 判断剩下的部分是否还有 k 个节点能翻转
            if(!hasEnoughNode(head,k)){
                break;
            }

            // 把头结点提拉出来，作为翻转部分的第一个节点
            ListNode new_tail = head;// 新翻转链表的尾节点
            ListNode new_head = head;// 新翻转链表的头结点
            head = head.next;
            new_tail.next = null;// 这是为了避免误操作搞出环来
            
            // 然后再找k-1个节点出来，插到链表头
            int count = k-1;
            while(count!=0){
                ListNode tmp = head;
                head = head.next;
                tmp.next = new_head;
                new_head = tmp;
                count--;
            }
            
            // 左边的链表，和新翻转的链表串起来
            left.next = new_head;
            
            // 移动尾巴
            left = new_tail;
        }
        
        // 5.最后再把没反转的部分给链上
        left.next = head;
        
        // 6. 返回
        return guard.next;
    }
    
    
    // 判断后面是否还有足够的节点可以反转。
    boolean hasEnoughNode(ListNode head,int k){
        ListNode tmp = head;
        while(k!=0){
            if(tmp == null){
                return false;
            }
            tmp=tmp.next;
            k--;
        }
        return true;
    }
    
}
