public class LeetCode_81_129 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0, mid;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] < nums[high] && (target < nums[low] || target > nums[high])) return false;
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[low] == nums[mid] && nums[high] == nums[mid]) {
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
