/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 使用 set 标记访问过的 node
 * 
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    if (head == null || head.next == null) { return false; }
    
    const visitedSet = new Set();
    while (head) {
      if (visitedSet.has(head)) {
        return true;
      }
      visitedSet.add(head);
      head = head.next;
    }
    
    return false;
  };