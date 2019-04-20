/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    const dummyHead = new ListNode();
    let curr = dummyHead;
    let currL1 = l1;
    let currL2 = l2;
    
    while(currL1 != null && currL2 != null) {
        // 比较两个结点的大小，小的先加入新链表
        if (currL1.val <= currL2.val) {
            curr.next = currL1;
            currL1 = currL1.next;
        } else {
            curr.next = currL2;
            currL2 = currL2.next;
        }
        curr = curr.next;
    }
    
    // 如果 l1 还没遍历完直接加入新链表
    if (currL1 != null) {
        curr.next = currL1;
    }
    // 如果 l2 还没遍历完直接加入新链表
    if (currL2 != null) {
        curr.next = currL2;
    }
    
    return dummyHead.next;
};

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 递归实现 
 *
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    // 返回非空的链表
    if (l1 == null || l2 == null) { return l1 ? l1 : l2; }
    if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l2.next, l1);
        return l2;
    } 
};