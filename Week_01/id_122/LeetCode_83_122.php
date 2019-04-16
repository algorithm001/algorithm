<?php
/**
 * Created by PhpStorm.
 * User: yuanyunxu
 * Date: 19/4/16
 * Time: ÏÂÎç3:15
 */

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
    function deleteDuplicates($head) {
        if ($head == null) {
            return $head;
        }
        $prior = $head;
        while ($prior->next) {
            $next = $prior->next;
            if ($prior->val == $next->val) {
                $prior->next = $next->next;
                $next->next = null;
                continue;
            }
            $prior = $prior->next;
        }
        return $head;
    }
}