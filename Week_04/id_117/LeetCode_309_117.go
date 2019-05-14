package solution

/*
309. Best Time to Buy and Sell Stock with Cooldown

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/
/*
解题思路:
prices := [1,2,3,0,2]
1.第i天买股票能够剩下的最大利润
(1)第i-1天买股票能够剩下的最大利润, 即第i天冷冻
(2)第i-2天卖股票剩余的最大利润 - 第i天买股票能够剩下的最大利润
公式: buy[i] = max(buy[i-1], sell[i-2] - prices[i-1])
2.第i天卖股票能够剩下的最大利润
(1)第i-1天卖股票能够剩下的最大利润, 即第i天冷冻
(2)第i天卖股票的钱 + 第i-1天买股票剩余的最大利润
公式: sell[i] = max(sell[i-1], buy[i-1] + prices[i-1])
3.初始化设置buy[1]= prices[0], 默认第1天就开始买, 如果第2天是较低价格, 则会重新设置
*/

func getMax(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func maxProfit(prices []int) int {
	pLen := len(prices)
	if pLen <= 0 {
		return 0
	}
	sell := make([]int, pLen+1)
	buy := make([]int, pLen+1)
	buy[1] = -prices[0]
	for i := 2; i <= pLen; i++ {
		buy[i] = getMax(buy[i-1], sell[i-2]-prices[i-1])
		sell[i] = getMax(sell[i-1], buy[i-1]+prices[i-1])
	}
	return sell[pLen]
}
