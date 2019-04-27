/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 
 * 由于链表是排序的， 只需要遍历链表，并把点前结点的值与后继结点的值比较
 * 如果相等则：current.next = current.next.next
 * 
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    if (head === null) { return head; }
    
    const dummyHead = new ListNode(); // 使用虚拟头结点
    dummyHead.next = head;
    let current = dummyHead;
    
    while(current.next) {
        // 删除结点
        if (current.val === current.next.val) {
            current.next = current.next.next;
        } else {// 移动结点
            current = current.next;
        }
    }
    
    return dummyHead.next;
};