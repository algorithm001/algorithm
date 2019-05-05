import java.util.Arrays;

public class LeetCode_324_85 {
}

/**
 * @Package:
 * @ClassName: WiggleSortII
 * @Description: *****************************************
 * **************给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * ************** 难度：中
 * @Author: wangzhao
 * @Date: 2019-04-20 10:35:56
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class WiggleSortII {

    public void wiggleSort(int[] nums) {

        if (nums == null) return;

        nums = sort(nums);
        int left = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
        int right = nums.length - 1;
        int[] _nums = new int[nums.length];
        for (int i = 0; i < _nums.length; i++) {
            if (i % 2 == 0) {
                _nums[i] = nums[left];
                left--;
            } else {
                _nums[i] = nums[right];
                right--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = _nums[i];
        }
        Arrays.stream(nums).forEach(i -> System.out.print(i + ","));
    }

    private int[] sort(int[] nums) {
        //TODO:自写代码实现排序
        Arrays.sort(nums);
        return nums;
    }


    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 1, 2, 2, 1};
        new WiggleSortII().wiggleSort(nums);

    }
}

