package com.shufeng.algorithm4.demo;

/**
 * @author gsf
 * @date 2019-05-12 11:03
 */
public class LeetCode_746_30 {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int i = minCostClimbingStairs(cost);
        System.out.println(i);

    }

    public static int minCostClimbingStairs(int[] cost) {

        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
