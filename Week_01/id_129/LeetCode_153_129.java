public class LeetCode_153_129 {
    public int findMin(int[] nums) {
        int low = 0, mid;
        int high = nums.length - 1;
        if (high == 0) return nums[0];
        int min = nums[0];
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[low] <= nums[mid]) {
                min = Math.min(nums[low], min);
                low = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                high = mid - 1;
            }
        }
        return min;
    }
}
