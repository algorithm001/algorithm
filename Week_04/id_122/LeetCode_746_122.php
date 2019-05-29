<?php
/**
 * Created by PhpStorm.
 * User: zhangzhengyi
 * Date: 2019/5/12
 * Time: 下午4:06
 */
class Solution {

    /**
     * @param Integer[] $cost
     * @return Integer
     */
    function minCostClimbingStairs($cost) {
        if (empty($cost)) {
            return 0;
        }
        $len = count($cost);
        if ($len == 1) {
            return $cost[0];
        }
        $tmp1 = $cost[0];
        $tmp2 = $cost[1];
        for ($i = 2; $i != $len; $i++) {
            $tmp = $tmp2;
            $tmp2 = $cost[$i] + min($tmp1, $tmp2);
            $tmp1 = $tmp;

        }
        return min($tmp1, $tmp2);

    }
}