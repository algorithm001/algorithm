/**
 * 算法训练营第一周作业 链表-->简单
 * 
 * leetcode  83. 删除排序链表中的重复元素
 * 
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */



/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    let saveHead = head
    // 外层while控制循环完整个链表的长度
    while(head && head.next) {
        // 内层循环用于比较当前值是否和下一个值相等，相等则通过改变节点的指向来“删除”元素
        while(head.next && head.next.val === head.val) {
            head.next = head.next.next
        }
        // 移动head到下一个节点
        head = head.next
    }
    return saveHead
};