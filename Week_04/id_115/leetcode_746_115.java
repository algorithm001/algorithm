class Solution {
    public int minCostClimbingStairs(int[] cost) {
  int[] f = new int[cost.length + 1];//到达每层楼最小花费
        f[0] = 0;
        f[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
        }
        return f[cost.length];
    }
}