/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 迭代实现
 * 交换: prev.next -> curr.next; curr.next.next -> curr; curr.next = curr.next.next;
 * 移动: prev = curr; curr = curr.next;
 * 
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    const dummyHead = new ListNode();
    dummyHead.next = head;
    let prev = dummyHead; // 前驱
    let curr = dummyHead.next // 当前
    while(curr != null && curr.next != null) {
        const tmp = curr.next.next;
        prev.next = curr.next;
        curr.next.next = curr;
        curr.next = tmp;
        
        prev = curr;
        curr = curr.next;
    }
    
    return dummyHead.next;
};

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 递归实现
 * 
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    if (head === null || head.next === null) { return head; }
    const next = head.next;
    head.next = swapPairs(next.next);
    next.next = head;
    
    return next;
};