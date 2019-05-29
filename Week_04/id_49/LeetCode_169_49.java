package com.v0ex.leetcode;

import java.util.Arrays;

/**
 * @author bugcoder
 */
public class LeetCode_169_49 {

    public int majorityElement(int[] nums) {
        if(nums.length==1||nums.length==2){
            return nums[0];
        }
        Arrays.sort(nums);
        int length = nums.length;
        int start = 0;
        int end = length-1;
        int mid = start + (end-start)/2;
        if (nums[start] == nums[mid] && nums[mid] == nums[mid+1]){
            mid = start;
        }
        if (nums[end] == nums[mid] && nums[mid] == nums[mid-1]){
            mid = end;
        }
        return nums[mid];
    }

    /**
     * 很有意思的Boyer-Moore投票算法
     * @param nums
     * @return
     */
    public int majorityElementBmVoting(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
