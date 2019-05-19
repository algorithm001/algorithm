package com.potato.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_169_036 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;
        for (int i : nums) {
            if (map.containsKey(i)) {
                count = map.get(i) + 1;
            } else {
                count = 1;
            }

            if (count > n / 2) {
                return i;
            }

            map.put(i, count);
        }
        return -1;
    }
}
