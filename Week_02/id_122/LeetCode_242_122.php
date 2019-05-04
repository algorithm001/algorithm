<?php
/**
 * Created by PhpStorm.
 * User: zhangzhengyi
 * Date: 2019/4/22
 * Time: 上午12:49
 */
class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        $len_s = strlen($s);
        $len_t = strlen($t);
        if ($len_s == 0 && $len_t == 0) {
            return true;
        }
        if ($len_s != $len_t) {
            return false;
        }
        $map = array();
        for ($i=0; $i != $len_s; $i++) {
            if (empty($map[$s[$i]])) {
                $map[$s[$i]] = 1;
            } else {
                ++$map[$s[$i]];
            }
        }
        for ($i=0; $i != $len_t; $i++) {
            if (empty($map[$t[$i]])) {
                return false;
            } else {
                --$map[$t[$i]];
            }
        }
        foreach ($map as $k => $value) {
            if ($value != 0) {
                return false;
            }
        }
        return true;
    }
}