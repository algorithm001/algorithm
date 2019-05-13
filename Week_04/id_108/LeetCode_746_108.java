import java.util.Arrays;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/12
 */
public class LeetCode_746_108 {

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            if (cost.length < 2) {
                return 0;
            }
            if (cost.length == 2) {
                return Math.min(cost[0], cost[1]);
            }

            int sum[] = Arrays.copyOfRange(cost, 0, cost.length);

            for (int i = 2; i < sum.length; i++) {
                sum[i] = sum[i] + Math.min(sum[i - 1], sum[i - 2]);
            }
            return Math.min(sum[sum.length - 1], sum[sum.length - 2]);
        }
    }
}
