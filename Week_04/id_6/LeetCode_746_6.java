

    // LeetCode 746


    // [ 1. 动态规划  ]

    // 到达每个点的花费的集合 看成状态集合，然后根据这个集合推导下一个点的花费集合
    // 因为题目只求花费的最小值，所以集合只保留一个值即可
    // 动态的向前推进
    // 推导依据：f(n) = f(n-1) + f(n-2) + val(n)  斐波那契数
    // 到达第cost.length个点(数组外的点)时，花费值即为所求
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1){
            return cost[0];
        }
        if (n == 2){
            return Math.min(cost[0], cost[1]);
        }

        int[] sum = new int[n+1];
        sum[0] = cost[0];
        sum[1] = cost[1];
        int i = 2;
        // 计算每个点的花费集合，只保留最小值
        for (i = 2; i < n; i++) {
            sum[i] = Math.min(sum[i - 1], sum[i - 2]) + cost[i];
        }

        return Math.min(sum[i - 1], sum[i - 2]);
    }

	
	