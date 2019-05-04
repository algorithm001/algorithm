<?php
/**
 * Created by PhpStorm.
 * User: yuanyunxu
 * Date: 19/4/18
 * Time: ÏÂÎç9:27
 */

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class TreeNode {
    public $val = null;
    public $left = null;
    public $right = null;
    function __construct($value) { $this->val = $value; }
}

class Solution {
    private $max = 0;

    /**
     * @param TreeNode $root
     * @return Integer
     */
    function longestUnivaluePath($root) {
        if (!$root) {
            return 0;
        }
        $this->maxP($root, $root->val);
        return $this->max;
    }

    function maxP($root, $val) {
        if (!$root) {
            return 0;
        }
        $left = $this->maxP($root->left, $root->left->val);
        $right = $this->maxP($root->right, $root->right->val);
        $this->max = max($this->max, $left + $right);
        if ($root->val == $val) {
            return max($left, $right) + 1;
        }
        return 0;
    }
}