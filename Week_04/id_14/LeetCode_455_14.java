import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 *
 * <p> 分发饼干
 * <p> 简单
 * <p> 贪心算法
 *
 * @author aiter
 * @date 2019/05/10 7:39 AM
 */
public class LeetCode_455_14 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        System.out.println(String.format("期望值：%d，实际值：%d",
            1, solution.findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1})));

        System.out.println(String.format("期望值：%d，实际值：%d",
            2, solution.findContentChildren(new int[] {1, 2}, new int[] {1, 2, 3})));

        System.out.println(String.format("期望值：%d，实际值：%d",
            1, solution.findContentChildren(new int[] {1, 2, 3}, new int[] {3})));
    }

    static class Solution2 {
        /**
         * @param g 孩子
         * @param s 饼干
         * @return 满足的孩子的数量
         */
        public int findContentChildren(int[] g, int[] s) {
            int count = 0;

            //O(n)
            Arrays.sort(g);
            //O(m)
            Arrays.sort(s);

            int i = 0, j = 0;
            while (i < g.length && j < s.length) {
                //满足
                if (g[i] <= s[j]) {
                    count++;
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            return count;
        }
    }

    static class Solution {
        /**
         * @param g 孩子
         * @param s 饼干
         * @return 满足的孩子的数量
         */
        public int findContentChildren(int[] g, int[] s) {
            int count = 0;

            //O(n)
            Arrays.sort(g);
            //O(m)
            Arrays.sort(s);

            //O(m*n)
            for (int i = 0; i < s.length; i++) {
                for (int j = count; j < g.length; j++) {
                    //满足
                    if (g[j] <= s[i]) {
                        count++;
                    }

                    //满足，不满足，都需要看更大的饼干
                    break;
                }
            }

            return count;
        }
    }
}

