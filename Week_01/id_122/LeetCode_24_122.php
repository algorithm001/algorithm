<?php
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class ListNode {
    public $val = 0;
    public $next = null;
    function __construct($val) { $this->val = $val; }
}

class Solution {

    /**
     * @param ListNode $head
     * @return ListNode
     */
    function swapPairs($head) {

        //没有元素，或者只有一个元素
        if ($head == null || $head->next == null) {
            return $head;
        }
        $shaoBing = new ListNode(null);
        $shaoBing->next = $head->next;

        //到这里至少链表中至少有两个元素
        $prev = $head;
        $prior = $prev->next;
        $next = $prior->next;

        while ($next && $next->next) {
            $prev->next = $next->next;
            $prior->next = $prev;
            $prev = $next;
            $prior = $next->next;
            $next = $prior->next;
        }

        //最后交换末尾两个元素, 针对单数个链表元素做处理
        $prev->next = $next ? $next : null;
        $prior->next = $prev;
        return $shaoBing->next;
    }
}
