/**
 * 455. 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/
 * 贪心算法，greedy
 * T(n) = O(nlogn)
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
  // 将小孩的饼干从大到小排序
  g = g.sort((a, b) => b - a);
  s = s.sort((a, b) => b - a);
  
  let si = 0, gi = 0, res = 0;
  while(gi < g.length && si < s.length) {
    if (s[si] >= g[gi]) {
      res++;
      si++;
      gi++;
    } else {
      gi++;
    }
  }
  return res;
};