# 这是上周的题一直就想到这个解，感觉拿不出手
class Solution:
    def arrangeCoins(self, n: int) -> int:
        level = 1
        while level <= n:
            n -= level
            level += 1
        return level-1

    def arrangeCoins2(self, n: int) -> int:
        level = 1
        m = int(n/2)+1 #细想了想最多有int(n/2)+1行了吧
        while level <= m:
            n -= level
            if n < 0:
                break
            level += 1
        return level-1

    # 看了别人的二分法思路思路O(logn)
