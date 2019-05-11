"https://leetcode-cn.com/problems/arranging-coins/"
"Author : Shaodong Song" 
"Date : 2019-04-20"

"""
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
*
* *
* *

Because the 3rd row is incomplete, we return 2.
"""

class Solution(object):
    def arrangeCoins(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        if n == 0:
            return 0
        
        if n == 1:
            return 1
        
        lo = 0
        mid = 0
        hi = n

        while hi - lo > 1:
            mid = (lo + hi) >> 1
            sum_num = mid * (mid + 1) >> 1
            
            if sum_num == n:
                return mid
            elif sum_num > n:
                hi = mid
            else:
                lo = mid
            
        return lo


class Solution1(object):
    def arrangeCoins(self, n):
        """
        :type n: int
        :rtype: int
        """

        i = 1
        num = n
        while num >= i:
            num -= i
            i += 1
            
        return i - 1


class Solution2(object):
    def arrangeCoins(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        num = int((2 * n) ** 0.5)
        if n < 2 or (1 + num) * num / 2 <= n:
            return num
        else:
            return num - 1


so = Solution()
so1 = Solution()
so2 = Solution()

print "arrangeCoins 10 = %d line" % so.arrangeCoins(10)
print "arrangeCoins 9 = %d line" % so1.arrangeCoins(9)
print "arrangeCoins 8 = %d line" % so2.arrangeCoins(8)



