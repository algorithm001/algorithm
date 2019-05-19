<?php
/**
 * Created by PhpStorm.
 * User: zhangzhengyi
 * Date: 2019/5/12
 * Time: 下午4:29
 */
class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        if (empty($prices)) {
            return 0;
        }
        $n = count($prices);
        $sell = array(0,);
        $buy = array(0,);
        $cool = array(0,);
        $buy[0] = -$prices[0];
        for ($i = 1; $i != $n; $i++) {
            $sell[$i] = max($buy[$i-1] + $prices[$i], $sell[$i-1]);
            $buy[$i] = max($cool[$i-1] - $prices[$i], $buy[$i-1]);
            $cool[$i] = max($sell[$i-1], $buy[$i-1], $cool[$i-1]);
        }
        return $sell[$n - 1];
    }
}