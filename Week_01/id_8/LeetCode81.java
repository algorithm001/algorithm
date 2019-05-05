class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        for (int i : nums) {
            if (target == i) {
                return true;
            }
        }
        return false;
    }
}