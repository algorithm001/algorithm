package leetcode.Algorithms._301_400._309_BestTimeToBuyAndSellStockWithCooldown;

/**
 * Created by jialei.zou on 2019/5/8 .
 ref:
 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 示例:

 输入: [1,2,3,0,2]
 输出: 3
 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * stock相关的题目都看一下，本题没什么思路，直接看ref

     ref
     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations

     buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
     sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);

     Let b2, b1, b0 represent buy[i - 2], buy[i - 1], buy[i]
     Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]


     该题目主要要初始化买卖两个操作的int数组
     卖不仅依赖于卖数组自己（对比自身看要不要进行卖的动作），还要依赖于买数组，反过来，买也是一样

     买卖的前两个值都可以进行分别初始化

     如果要求给出如何进行操作，可以从后向前，其他规则如下
     1. 倒着从卖开始
     2. 如果最后有几个相等的 例如 11 11 11，那一定是从最左侧开始，
     3. 买卖交替进行
     4. 除了第一个买，其他买需要间隔一天等待
          [ 1, 2, 3, 0, 2, 5, 7, 3, 8]
     buy: [-1,-1,-1, 1, 1, 1, 1, 3, 3]
     sell:[ 0, 1, 2, 2, 3, 6, 8, 8, 11]
          [ 买,卖,等, 买,等,卖, 等,买, 卖,]

     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {return 0;}

        //b1是-1个元素，s1是sell -1个元素 s2是-2个元素
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0; s2 = s1; s1 = s0;
        }
        return s0;
    }

    public int maxProfitPractise(int[] prices) {
        if(prices == null || prices.length <= 1) {return 0;}

        //定义买卖两个数组, 相应位置执行买或卖动作能够赚到的最多的钱
        int buy[] = new int[prices.length];
        int sell[] = new int[prices.length];
        //确定规则
        //buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i])
        //sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i])

        //初始化数据
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(sell[0], buy[0]+prices[1]);

        //剩下的进行循环
        for (int i = 2; i<prices.length; i++){
            buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        return sell[prices.length-1];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown stcok = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(stcok.maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(stcok.maxProfitPractise(new int[]{1,2,3,0,2}));
    }

}
