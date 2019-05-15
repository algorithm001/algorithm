from typing import List


class Solution:
    def maxProfit( prices: List[int], fee: int) -> int:
        n = len(prices)
        if n<2:
            return 0
        dp1 = [0 for _ in range(n)] #第i天手上有股票时的最大收益
        dp2 = [0 for _ in range(n)] #第i天手上无股票时的最大收益
        dp1[0] = -prices[0]
        for i in range(1,n):
            dp1[i] = max(dp1[i-1],dp2[i-1]-prices[i])  #昨天手上有股票与今天手上有股票的收益对比
            dp2[i] = max(dp2[i-1],dp1[i-1]+prices[i]-fee)  #昨天手上 无股票的收益和今天手上无股票的收益对比
        return dp2[n-1]


if __name__=="__main__":
    prices = [1, 3, 2, 8, 4, 9]
    fee = 2
    print(Solution.maxProfit(prices,fee))