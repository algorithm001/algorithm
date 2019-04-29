<?php
/**
 * Created by PhpStorm.
 * User: yuanyunxu
 * Date: 19/4/16
 * Time: ÏÂÎç3:41
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
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function mergeTwoLists($l1, $l2) {
        if ($l1 == null) {
            return $l2;
        }

        if ($l2 == null) {
            return $l1;
        }

        $first = $l1;
        $second = $l2;

        if ($first->val <= $second->val) {
            $head = $first;
            $first = $first->next;
        } else {
            $head = $second;
            $second = $second->next;
        }

        $now = $head;

        while (true) {
            if ($first == null) {
                $now->next = $second;
                break;
            }
            if ($second == null) {
                $now->next = $first;
                break;
            }

            if ($first->val <= $second->val) {
                $now->next = $first;
                $first = $first->next;
                $now = $now->next;
                continue;
            }
            $now->next = $second;
            $second = $second->next;
            $now = $now->next;
        }
        return $head;
    }
}