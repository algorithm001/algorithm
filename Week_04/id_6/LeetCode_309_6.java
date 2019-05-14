

    // LeetCode 309


    // [ 1. 动态规划  ]

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0){
            return 0;
        }

        int[] buy = new int[len];
        int[] sell = new int[len];

        buy[0] = 0 - prices[0];
        sell[0] = 0;

        for (int i = 1; i < len; i++) {
            if (i == 1){
                buy[i] = Math.max(sell[0]-prices[i], buy[i-1]);
            }else {
                buy[i] = Math.max(sell[i-2]-prices[i], buy[i-1]);
            }

            sell[i] = Math.max(prices[i]+buy[i-1], sell[i-1]);
        }

        return Math.max(sell[len-1], buy[len-1]);
    }