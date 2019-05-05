
public class Solution {

    private int average;
    private boolean[] mark;
    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (k == 1) {
            return true;
        }

        int sum = 0;
        int len = nums.length;

        for (int i = 0; i < len; i ++) {
            sum += nums[i];
        }

        if (sum % k != 0) {
            return false;
        }

        this.average = sum / k;
        mark = new boolean[len];

        return calSubSum(nums, 0, average, 0, k);

    }

    public boolean calSubSum(int[] nums, int curSum, int subSum, int start, int k) {

        if (k == 1) {
            return true;
        }

        if (curSum == subSum) {
            return calSubSum(nums, 0, subSum, 0, k - 1);
        }

        for (int i = start; i < nums.length; i ++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;

            if (this.calSubSum(nums, curSum + nums[i], subSum, i + 1, k)) {
                return true;
            }
            mark[i] = false;
        }
        return false;


    }

}
