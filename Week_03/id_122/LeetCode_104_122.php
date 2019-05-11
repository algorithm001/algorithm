<?php
/**
 * Created by PhpStorm.
 * User: yuanyunxu
 * Date: 19/5/2
 * Time: ÏÂÎç4:11
 */
 class TreeNode {
     public $val = null;
     public $left = null;
     public $right = null;
     function __construct($value) { $this->val = $value; }
 }

class Solution {

    /**
     * @param TreeNode $root
     * @return Integer
     */
    function maxDepth($root) {
        if (!$root) {
            return 0;
        }
        return max($this->maxDepth($root->left) +1, $this->maxDepth($root->right) + 1);
    }
}