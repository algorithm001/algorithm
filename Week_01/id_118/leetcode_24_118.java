/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        // 1. 边界：空链表或只有一个节点
        if(head==null || head.next == null){
            return head;
        }
        
        // 2. 为了方便处理，需要加一个哨兵节点，指向 head
        ListNode guard = new ListNode(0);
        guard.next = head;
        
        // 3. 然后，两个节点的交换需要涉及到其前后节点，加起来共四个节点，按顺序分别将他们定义为：
        // start_left,要交换两个节点中起点的前一个节点。初始为 guard
        // start，要交换的起点。初始为 head
        // end，要交换的终点。初始为 head.next
        // end_right，要交换的两个节点中终点的后一个节点。初始为 head.next.next。这个节点有可能为空
        ListNode start_left = guard;
        ListNode start = head;
        ListNode end = head.next;
        ListNode end_right = head.next.next;
        
        // 4. 开始做节点交换和指针移动，end==null时停止
        while(end!=null){
            // 先交换
            start_left.next = end;
            start.next = end_right;
            end.next = start;
            // 后移动。注意判断接下来是否还有两个非空节点
            if(end_right == null || end_right.next == null){
                break;
            }
            start_left = start;
            start = start_left.next;
            end = start.next;
            end_right = end.next;
        }
        
        // 5. 最后返回 guard.next。注意，这里不要返回 head，因为head 已经被交换到第二个节点了。
        return guard.next;
    }
}
