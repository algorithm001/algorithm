<?php
/**
 * Created by PhpStorm.
 * User: zhangzhengyi
 * Date: 2019/4/22
 * Time: 上午1:06
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

    private $minArr = array(-1,-1); //array[0]最小， array[1]第二小
    /**
     * @param TreeNode $root
     * @return Integer
     */
    function findSecondMinimumValue($root) {
        if ($root == null) {
            return -1;
        }
        $this->minArr[0] = $root->val;
        $this->findValue($root);
        return $this->minArr[1];
    }

    private function findValue($root) {
        if ($root == null) {
            return;
        }
        if ($root->val < $this->minArr[0]) {
            $this->minArr[1] = $this->minArr[0];
            $this->minArr[0] = $root->val;
        } elseif ($root->val > $this->minArr[0] && $root->val < $this->minArr[1]) {
            $this->minArr[1] = $root->val;
        } elseif ($root->val > $this->minArr[1] && $this->minArr[1] == -1 && $root->val != $this->minArr[0]) {
            $this->minArr[1] = $root->val;
        }
        $this->findValue($root->left);
        $this->findValue($root->right);
    }
}