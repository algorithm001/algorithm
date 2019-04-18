
/**
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 1. 边界处理：两个都为null或任意一个为null
        if(l1==null || l2==null ){
            return l1 == null ? l2 : l1;
        }

        // 2. 初始化新链表中的节点。
        // - 为了简化处理，初始化一个头结点作为哨兵节点，值为0。
        // - 再初始化一个临时指针，指向头结点，从头开始往链表上挂节点。
        ListNode head = new ListNode(0);
        ListNode current = head;

        // 3. 同时遍历两个链表，哪个头结点值最小，则把哪个节点的头拆下来
        //  - 注意，拆头结点的时候，千万别把指针拆丢了
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                current.next = l1;
                l1=l1.next;
            }else{
                current.next = l2;
                l2=l2.next;
            }
            current=current.next;
            current.next = null;
        }

        // 4. 边界处理：可能某一个指针还没走完，直接无脑追加上就好了
        if(l1!=null){
            current.next = l1;
        }
        if(l2!=null){
            current.next = l2;
        }

        // 5. 最后，返回 head.next，因为head节点数据无意义
        return head.next;

    }
}
