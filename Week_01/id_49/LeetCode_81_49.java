package com.bugcodes.leetcode;

/**
 * Search in Rotated Sorted Array II
 *
 * @author bugcoder
 */
public class LeetCode_81_49 {

    public boolean search(int[] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high){
            mid = low + (high - low)/2;
            //如果中间的数正好是目标值，找到
            if (nums[mid] == target){
                return true;
            }
            //如果两边的数与中间的数相等，则同时移动左右指针
            if (nums[low] == nums[mid] && nums[high] == nums[mid]){
                ++low;
                --high;
                //左半段有序递增的情况下,二分查找
            }else if (nums[low] <= nums[mid]){
                if (nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
                //右半段有序递增的情况下,二分查找
            }else {
                if (nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
