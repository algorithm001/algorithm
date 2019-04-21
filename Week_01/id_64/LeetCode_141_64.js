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

  /**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 使用快慢指针, 当快指针在环里打转碰上慢指针即检测到环
 * 
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    let slow = head;
    let fast = head;
    while (fast != null) {
      if (fast.next == null) { return false; }
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) return true;
    } 
    
    return false;
  };