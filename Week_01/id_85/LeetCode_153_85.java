public class LeetCode_153_85 {
}

/**
 * @Package:
 * @ClassName: ArraySortedFindMin
 * @Description: *****************************************************
 * **************假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * **************( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * **************请找出其中最小的元素。
 * **************你可以假设数组中不存在重复元素。 难度：中
 * @leetcode url:https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * @Author: wangzhao
 * @Date: 2019-04-17 14:42:15
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class ArraySortedFindMin {

    public int findMin(int[] nums) {

        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int last = nums.length - 1;
        int lastVal = nums[last];

        for (int i = 0; i < nums.length; i++) {

            if (nums[0] > nums[last]) {
                lastVal = nums[last];
                last--;
                continue;
            }
            if (nums[0] <= nums[last]) {
                break;
            }
        }
        if (nums[0] < lastVal) {
            return nums[0];
        }

        return lastVal;
    }


    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 1, 2};

        int result = new ArraySortedFindMin().findMin(arr);

        System.out.println(result);
    }
}
