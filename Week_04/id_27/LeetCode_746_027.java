class Solution {


	/*
	如果我们用一个数组dp[]来存放到达每一层所需要的花费值。
	则则最终结果是求dp[cost.length]的值。
	因为每次可以走1层或者2层，并且可以从0或者从1开始，所以可以得到dp[0]为0，dp[1]为0。
	从2开始，dp[i]可以由通过dp[i-2]走2层或者通过dp[i-1]走一层到达，
	而这i-2和i-1层所要花费的值分别为cost[i-2]和cost[i-1]，
	所以，dp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])。
	该算法的空间复杂度为O(n)，时间复杂度为O(n)。
	*/
	public int minCostClimbingStairs(int[] cost) {
        int length = cost.length + 1;
        int[] dp = new int[length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[length - 1];
    }

		/*
		由于在i大于等于2的情况下，dp[i]只跟dp[i-1]和dp[i-2]接cost数组有关。
		所以我们只需要用三个变量来存储结果即可， 即dp0,dp1,dp2，这样的空间复杂度就变成了O(1)。
		*/

		public int minCostClimbingStairs1(int[] cost) {
        int length = cost.length + 1;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i < length; i++) {
            dp2 = Math.min(dp0 + cost[i - 2] , dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }


	public static void main(String[] args) {

		int[] cost = {10, 15, 20};
		//System.out.println(new Solution().minCostClimbingStairs(cost));

		int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(new Solution().minCostClimbingStairs(cost1));

	}




}
