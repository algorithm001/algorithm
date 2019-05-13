class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        if (nums[0] > nums[nums.length - 1]) {
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] < nums[i - 1]) {
                    return nums[i];
                }
            }
        }
        return nums[0];
    }
}