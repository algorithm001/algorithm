/**
 * https://leetcode-cn.com/problems/find-the-town-judge/
 *
 * <p> 简单
 * <p> 图
 *
 * @author aiter
 * @date 2019/04/30 6:32 AM
 */
public class LeetCode_997_14 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int N = 3;
        int[][] trust = {{1, 3}, {2, 3}};

        int r = solution.findJudge(N, trust);

        System.out.println(String.format("期望值：3，实际值：%d", r));

        Solution2 solution2 = new Solution2();

        System.out.println(String.format("期望值：3，实际值：%d", solution2.findJudge(N, trust)));
    }

    /**
     * <pre>
     *   需求描述：
     *     1. 小镇的法官不相信任何人。
     *          没有指向的顶点。   出度=0
     *     2. 每个人（除了小镇法官外）都信任小镇的法官。
     *          其他的点，都指向这个顶点。秘密的法官的  入度=N-1
     *     3. 只有一个人同时满足属性 1 和属性 2 。
     *          只能有一个顶点的。出度=0，入度=N-1
     *
     *     +-----+----+
     *     |入度 |出度 |
     *     +-----+----+
     *     | N-1 | 0  |  -->  秘密法官
     *     +-----+----+
     *     |0.N-1| >0 |  -->  其他
     *     +-----+----+
     *
     * </pre>
     */
    static class Solution {
        public int findJudge(int N, int[][] trust) {
            //这种方法可以不判断，persons二维数组遍历时，N=1时，也能满足
            //if (N == 1 && trust.length == 0) {
            //    return 1;
            //}
            int[][] persons = new int[N + 1][2];

            for (int[] items : trust) {
                //统计入度
                persons[items[1]][0] = persons[items[1]][0] + 1;
                //统计出度
                persons[items[0]][1] = persons[items[0]][1] + 1;
            }

            int judgeCnt = 0;
            int idx = 0;
            for (int i = 1; i < persons.length; i++) {
                int[] items = persons[i];
                //入度=N-1 && 出度=0
                if (items[0] == N - 1 && items[1] == 0) {
                    judgeCnt++;
                    idx = i;
                }
            }
            if (judgeCnt == 1) {
                return idx;
            }

            return -1;
        }
    }

    static class Solution2 {
        public int findJudge(int N, int[][] trust) {
            //这个条件开始没注意
            if (N == 1 && trust.length == 0) {
                return 1;
            }
            int[][] persons = new int[N + 1][2];

            int judgeCnt = 0;
            int idx = 0;
            for (int[] items : trust) {
                //统计入度
                persons[items[1]][0] = persons[items[1]][0] + 1;
                if (persons[items[1]][0] == N - 1) {
                    //入度=N-1 && 出度=0 就是法官
                    if (persons[items[1]][1] == 0) {
                        judgeCnt++;
                        idx = items[1];
                    }
                }
                //统计出度
                persons[items[0]][1] = persons[items[0]][1] + 1;
                //被选中的法官，有出度了，就不是法官
                if (items[0] == idx) {
                    judgeCnt--;
                    idx = 0;
                }
            }

            if (judgeCnt == 1) {
                return idx;
            }

            return -1;
        }
    }
}
