public class LeetCode_33_85 {
}

/**
 * @Package:
 * @ClassName: LeetCode_33_85.ArraySortedSearch
 * @Description: ************************************
 * **************假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * **************( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * **************搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * **************你可以假设数组中不存在重复的元素。
 * **************算法时间复杂度必须是 O(log n) 级别。     难度：难
 * @leetcode url :https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * @Author: wangzhao
 * @Date: 2019-04-17 22:22:56
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class ArraySortedSearch {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (target == nums[0]) {
            return 0;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {7, 8, 1, 2, 3, 4, 5, 6};
        int target = 2;

        int index = new ArraySortedSearch().search(nums, target);
        System.out.println(index);
    }
}
