package com.potato.leetcode;

public class LeetCode_746_036 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] tmp = new int[2];
        tmp[0] = cost[0];
        tmp[1] = cost[1];

        int min = 0;
        for (int i = 2; i < cost.length; i++) {
            min = Math.min(tmp[0], tmp[1]);
            tmp[0] = tmp[1];
            tmp[1] = min + cost[i];
        }
        return Math.min(tmp[0], tmp[1]);
    }
}
