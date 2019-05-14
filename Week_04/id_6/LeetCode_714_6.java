

    // LeetCode 714


    // [ 1. 贪心算法  ]
    // 1）问题抽象：n天股票价格中，抽取某些天进行买卖
    // 2）利润最大：最低价买，最高价卖
    // ?? 手续费起什么作用   减手续费后的利润如果小于0，则不卖
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1){
            return 0;
        }

        int minPirce = prices[0];
        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= minPirce){
                minPirce = prices[i];
            }else {
                // 当天价格卖出利润大于0
                int n = prices[i] - minPirce - fee;
                if (n > 0){
                    sum += n;
                    // 后面有可能存在利润更大的，如果出现这种情况，把那部分利润补回来就行了
                    // ？？
                    minPirce = prices[i] - fee;
                }
            }
        }
        return sum;
    }




    // [ 1. 动态规划  ]

    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1){
            return 0;
        }

        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];

        // 第一天
        buy[0] = 0-prices[0];
        sell[0] = prices[0];

        // 推导公式
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-1]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]-fee);
        }

        return Math.max(buy[len-1], sell[len-1]);
    }