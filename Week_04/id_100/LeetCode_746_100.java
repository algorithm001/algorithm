class Solution {
    public int minCostClimbingStairs(int[] cost) {
          int len = cost.length; 
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1],cost[i - 2]);
        }
        return  Math.min(cost[len - 2],cost[len - 1]);
    }
}
