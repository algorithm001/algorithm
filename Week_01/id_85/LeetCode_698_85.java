import java.util.Arrays;

public class LeetCode_698_85 {
}

/**
 * @Package:
 * @ClassName: RecurvePartKEqualSubsets
 * @Description: *****************************
 * **************给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * **************示例 1：
 * **************输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * **************输出： True
 * **************说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 难度：中等
 * @leetCode url:https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 * @Author: wangzhao
 * @Date: 2019-04-19 11:39:28
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class RecurvePartKEqualSubsets {

    /**
     *
     * 思路：
     * 1.需要均分，因此全集数字之和不能为奇数，
     * 2.分割子集之和等于平均数
     * 3.查看所有数字的组合是否满足第二条
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (nums == null || k == 0) return false;

        if (k == 1) return true;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        if (sum % 2 != 0 && k % 2 == 0) {
            return false;
        }
        int avg = sum / k;

        boolean[] flagNums = new boolean[nums.length];

        return dfs(nums, k, avg, 0, 0, flagNums);
    }


    /**
     *
     * @param nums 数组全集
     * @param k 分割数
     * @param avg 平均值
     * @param sum 当前计算和
     * @param nextBegin 下个开始数下标
     * @param flagNums 标记已参与计算结果和为avg的数
     * @return
     */
    private boolean dfs(int[] nums, int k, int avg, int sum, int nextBegin, boolean[] flagNums) {

        if (k == 1) {
            return true;
        }
        if (avg == sum) {
            return dfs(nums, k - 1, avg, 0, 0, flagNums);
        }

        for (int i = nextBegin; i < nums.length; i++) {
            if (flagNums[i]) {
                continue;
            }
            flagNums[i] = true;
            if (dfs(nums, k, avg, sum + nums[i], i + 1, flagNums)) {
                return true;
            }
            flagNums[i] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        boolean result = new RecurvePartKEqualSubsets().canPartitionKSubsets(nums, k);
        System.out.println(result);
    }
}
