[746: 最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/submissions/)

###解题思路  动态规划问题，主要还是要找到递推公式
### 由题目我们能到看到到达当前位置的最小花费来自于上一步和上上一步的最小花费
### 递归公式就是 f(n) = min(f(n-1) + cost[n-1], f(n-2) + cost(n-2)), f(0) = 0, f[1] = 0, 
### f[2] = min(f(1) + cost[1], f(0)+cost[0])

def min_cost_climbing_stairs(cost)
    f = []
    f[0] = 0
    f[1] = 0
    f[2] = [f[0] + cost[0], f[1]+cost[1]].min
    for i in (2..cost.length) do
        f[i] = [f[i-2] + cost[i-2], f[i-1]+cost[i-1]].min
    end
    return f[cost.length]
    
end
