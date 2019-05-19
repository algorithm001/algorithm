public class LeetCode_746_085 {
}

/**
 * @Package:
 * @ClassName: MinCostClimbingStairs
 * @Description: 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * **************每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * **************您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * @leetcode_url:https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @Author: wangzhao
 * @Date: 2019-05-12 11:53:46
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class MinCostClimbingStairs {

    public int minCostClimbingStairs2(int[] cost) {

        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int length = cost.length;

        for (int i = 2; i < length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }


        return Math.min(cost[length - 1], cost[length - 2]);
    }

    public int minCostClimbingStairs(int[] cost) {

        if (cost == null || cost.length == 0) {
            return 0;
        }

        return minStep(cost, -1);
    }

    private int minStep(int[] cost, int step) {

        if (step >= cost.length) {
            return 0;
        }
        int val1 = 0;
        if (step + 1 < cost.length) {
            val1 = cost[step + 1];
        }

        int val2 = 0;
        if (step + 2 < cost.length) {
            val2 = cost[step + 2];
        }

        int res1 = val1 + minStep(cost, step + 1);
        int res2 = val2 + minStep(cost, step + 2);

        return Math.min(res1, res2);
    }


    public static void main(String[] args) {
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] cost = {0, 1, 2, 2};
        int[] cost = {0, 2, 2, 1};


        int num = new MinCostClimbingStairs().minCostClimbingStairs2(cost);
        System.out.println(num);
    }
}
