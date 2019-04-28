
/**
33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

 */
class Solution {
    public int search(int[] nums, int target) {
        return pureBinarySearch(nums, target);
    }

    /**
     * inspired by idea from https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14435/Clever-idea-making-it-simple  
     */
    public int pureBinarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int low = 0; int high = nums.length;

        while (low < high) {
            int mid = (low + high)/2;
            int num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid] : target < nums[0] ?  - Integer.MAX_VALUE : Integer.MAX_VALUE;

            if(num < target) {
                low = mid +1;
            }else if(num > target) {
                high = mid;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
