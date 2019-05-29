package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/12
 */
public class LeetCode_169_108 {

    // 遍历一遍，相同则加1，不相同则减1，最后剩余的item就是众数
    class Solution1 {
        public int majorityElement(int[] nums) {
            int count = 1;
            int item = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    item = nums[i];
                    count = 1;
                } else if (nums[i] == item) {
                    count++;
                } else {
                    count--;
                }
            }

            return item;
        }
    }

    // 统计每个数字的词频，统计出现次数大于n/2的
    class Solution2 {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int maxCount = 0;
            int maxItem = 0;
            for (int num : nums) {
                int count = map.getOrDefault(num, 0) + 1;
                if (map.keySet().isEmpty()) {
                    maxCount = 1;
                    maxItem = num;
                }
                if (map.keySet().contains(num)) {
                    if (count > maxCount) {
                        maxCount = count;
                        maxItem = num;
                    }

                }
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            return maxItem;
        }
    }

    //分治方法
    class Solution3 {
        public int majorityElement(int[] nums) {

            if (nums.length == 1) {
                return nums[0];
            }
            int mid = nums.length / 2;

            int[] left = Arrays.copyOfRange(nums, 0, mid);
            int[] right = Arrays.copyOfRange(nums, mid, nums.length);
            int a = majorityElement(left);
            int b = majorityElement(right);

            if (a == b) {
                return a;
            }
            return count(a, nums) > (nums.length / 2) ? a : b;
        }

        private int count(int num, int[] nums) {
            int count = 0;
            for (int i : nums) {
                if (num == i) {
                    count++;
                }
            }
            return count;
        }
    }
}
