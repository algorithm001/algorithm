# coding=UTF8
# ---------------------
# 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
# 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，
# 都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
# 注意：
# 你可以假设胃口值为正。
# 一个小朋友最多只能拥有一块饼干。
# 示例 1:
# 输入: [1,2,3], [1,1]
# 输出: 1
# 解释:
# 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
# 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
# 所以你应该输出1。
# 示例 2:
# 输入: [1,2], [1,2,3]
# 输出: 2
# 解释:
# 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
# 你拥有的饼干数量和尺寸都足以让所有孩子满足。
# 所以你应该输出2.


class Solution:
    # 执行用时 : 2564 ms, 在Assign Cookies的Python3提交中击败了5.08% 的用户
    # 内存消耗 : 14.7 MB, 在Assign Cookies的Python3提交中击败了17.98% 的用户
    def findContentChildren(self, g, s):
        g = sorted(g)  # 胃口
        s = sorted(s)  # 饼干
        num, ss, gg = 0, 0, 0
        for i in range(ss, len(s)):
            for j in range(gg, len(g)):
                if s[i] >= g[j]:
                    num += 1
                    gg = j + 1
                    break
                else:
                    ss = i + 1
                    continue
        return num

    # 用while改造了一下居然提高这么多
    # 执行用时 : 108 ms, 在Assign Cookies的Python3提交中击败了50.07% 的用户
    # 内存消耗 : 14.4 MB, 在Assign Cookies的Python3提交中击败了87.93% 的用户
    def findContentChildren(self, g, s):
        g.sort()
        s.sort()
        count = 0
        i = 0
        j = 0
        while i < len(g) and j < len(s):
            if g[i] <= s[j]:
                count += 1
                i += 1
                j += 1
            else:
                j += 1
        return count

s = [1, 1]  # 饼干
g = [1, 2, 3]  # 孩子

demo = Solution()
print("result: %s" % demo.findContentChildren3(g, s))

