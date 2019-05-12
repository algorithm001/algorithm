package data.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 */
public class Leetcode153 {
    /*
       这个题相当于找到旋转点
     */
    //[3,4,5,1,2]
    public int findMin(int[] nums) {
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            //表示后一个比前一个大
            if (nums[i] <= nums[minIndex]) {
                if (minIndex != i) {
                    minIndex = i;
                    break;
                }
            }
        }
        return nums[minIndex];
    }
}
