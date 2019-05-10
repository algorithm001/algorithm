import java.util.Arrays;
/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * <p> 简单
 * <p>  dynamic programming
 * <p>  爬楼梯，只能爬一梯或者二梯
 *
 * @author aiter
 * @date 2019/05/10 8:29 AM
 */
public class LeetCode_746_14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //Solution2 solution = new Solution2();

        System.out.println(String.format("期望值：%d，实际值：%d",
            6, solution.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1})));
        System.out.println(String.format("期望值：%d，实际值：%d",
            15, solution.minCostClimbingStairs(new int[] {10, 15, 20})));

        System.out.println(String.format("期望值：%d，实际值：%d",
            0, solution.minCostClimbingStairs(new int[] {0, 0, 0, 0})));

        System.out.println(String.format("期望值：%d，实际值：%d",
            0, solution.minCostClimbingStairs(new int[] {0, 0, 1, 0})));

        System.out.println(String.format("期望值：%d，实际值：%d",
            1, solution.minCostClimbingStairs(new int[] {0, 0, 1, 1})));
    }

    static class Solution2 {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length + 1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= cost.length; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }

            return dp[cost.length];

        }
    }

    /**
     * 被动态规划，搞疯了。{@link Solution2#minCostClimbingStairs(int[])} 使用的是状态转移方程？ 而我费时费力用的是状态转移表？
     */
    static class Solution {

        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;//楼梯数量
            int[][] status = new int[n][2];

            for (int i = 0; i < n; i++) {
                status[i][0] = -1;
                status[i][1] = -1;
            }

            status[0][0] = 0;
            status[0][1] = cost[0];

            for (int i = 1; i < n; i++) {
                //上一梯没走，这一梯必须走。上一梯没走，那么上上一梯，肯定是走了的。
                if (i == 1 || status[i - 1][0] == status[i - 2][1]) {
                    if (status[i][1] >= 0) {
                        status[i][1] = Math.min(status[i][1], status[i - 1][0] + cost[i]);
                    } else {
                        status[i][1] = status[i - 1][0] + cost[i];
                    }
                }

                //上一梯走了。
                if (status[i - 1][1] >= 0) {
                    //不走这一梯
                    status[i][0] = status[i - 1][1];

                    //走这一梯
                    if (status[i][1] >= 0) {
                        status[i][1] = Math.min(status[i][1], status[i - 1][1] + cost[i]);
                    } else {
                        status[i][1] = status[i - 1][1] + cost[i];
                    }
                }

                System.out.println(i + ":" + Arrays.toString(status[i]));
            }
            return status[n - 1][0] < status[n - 1][1] ? status[n - 1][0] : status[n - 1][1];
        }
    }
}

