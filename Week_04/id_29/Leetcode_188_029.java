package leetcode.Algorithms._101_200._188_BestTimeToBuyAndSellStockIV;

import java.util.Collections;

/**
 * Created by jialei.zou on 2019/5/9 .

 ref:
 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/

 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 示例 1:

 输入: [2,4,1], k = 2
 输出: 2
 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 示例 2:

 输入: [3,2,6,5,0,3], k = 2
 输出: 7
 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

 */
public class BestTimeToBuyAndSellStockIV {

    /**
     * 没想清楚如何控制K次的操作，看了其他人的解答后写的：
     *
     * 如下的方式最符合我的思维方式
     * https://blog.csdn.net/danielrichard/article/details/75091410
     * https://blog.csdn.net/danielrichard/article/details/75090039#

    如下是交易2次的说明：
     既然你说只能交易两次，那么我就对buy和sell的两次交易分别用两个数组存不就行了？！说做就做，状态转移方程如下：

     firstBuy[i] = max(firstBuy[i - 1], -prices[i])

     firstSell[i] = max(firstSell[i - 1], firstBuy[i - 1] + prices[i])

     secondBuy[i] = max( secondBuy[i - 1], firstSell[i - 1] - prices[i])

     secondSell[i] = max( secondSell[i - 1], secondBuy[i - 1] + prices[i])

     方程很好理解：

     1. 如果第 i 天为第一次买的状态，要么就是之前买过了，第i天不卖，对应于firstBuy[i -1]，要么就是之前没有买，第i天买入股票，对应于-prices[i]；

     2. 如果第 i 天为第一次卖的状态，要么就是之前卖出了，第i天不买，对应于firstSell[i -1]，要么就是之前买入了股票，第i天卖出股票，对应于firstBuy[i - 1] + prices[i]；

     3. 如果第 i 天为第二次买的状态，要么就是之前已经二次买过了，第i天不卖，对应于secondBuy[i -1]，要么就是之前卖过一次了，第i天再次买入股票，对应于firstSell[i - 1] - prices[i]；

     4. 如果第 i 天为第二次卖的状态，要么就是之前已经二次卖过了，第i天不买，对应于secondSell[i -1]，要么就是之前第二次购买，第i天卖出股票，对应于secondBuy[i - 1] + prices[i]；

     最后，还需要对第一天的买卖进行初始化：

     firstBuy[0] = -prices[0]

     secondBuy[0] = -prices[0]

     firstSell[0] = 0

     secondSell[0] = 0

     补充：
     关于初始化，任何一次（第k次）开始买卖的值为
     buy[0] = -prices[0];
     sell[0] = 0
     是初始化最坏情况，之后就会根据之前k-1次的收益来进行更优调整


    */
    public int maxProfit(int k, int[] prices) {
        if(prices==null|| prices.length<2){
            return 0;
        }
        int len = prices.length;
        if (k >= len / 2) {
            k = len/2;
        }
        //一次都不进行买卖的情况下，latestSell各项都是0
        int[] latestSell = new int[prices.length];

        //如下数据用于记录每次买卖中相应位置的最大值
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];


        for (int j = 1; j<=k; j++){
            //每次进行一次买卖都对最左侧的进行 最差情况的初始化
            buy[0] = -prices[0];
            sell[0] = 0;
            //每一次增加一次都是基于上一次
            for (int i = 1; i<prices.length; i++){
                buy[i] = Math.max(buy[i-1], latestSell[i-1]-prices[i]);
                sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
            }

            copy(sell, latestSell) ;
        }
        return sell[sell.length-1];
    }

    /*
            *
            * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54113/A-Concise-DP-Solution-in-Java
            *
            * @param k
     * @param prices
     * @return
             */
    private void copy(int[] sourc, int[] des){
        for (int i=0; i<sourc.length; i++){
            des[i] = sourc[i];
        }
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV sellStockIV = new BestTimeToBuyAndSellStockIV();
//        System.out.println(sellStockIV.maxProfit(2, new int[]{3,2,6,5,0,3}));
//        System.out.println(sellStockIV.maxProfit(2, new int[]{2,4,1}));
        System.out.println(sellStockIV.maxProfit(2, new int[]{3,3,5,0,0,3,1,4}));


    }


    public int maxProfitRef1(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            return quickSolve(prices);
        }

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++){
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/275295/Slow-but-easy-to-understand-java-solution-with-explanation
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitRef2(int k, int[] prices) {
        int length = Math.min(k, prices.length / 2) + 1; // caculate the theoretically max transactions we can make
        int sell[] = new int[length];
        int buy[] = new int[length];
        for(int i = 0; i < length; i++){
            buy[i] = Integer.MIN_VALUE;
        }
        for(int i = 0; i < prices.length; i++) {
            for(int j = length - 1; j >= 1; j--) { // index from high to low since hold[k] depends on sell[k - 1]
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
            }
        }
        return sell[length - 1];
    }

}
