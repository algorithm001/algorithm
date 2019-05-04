package leetCode.week3;

/**
 * Find the Town Judge
 * https://leetcode-cn.com/problems/find-the-town-judge/
 * https://leetcode.com/problems/find-the-town-judge/
 *
 * @author JP.Jiang
 * @version Java
 * @since 2019/05/01
 */
public class LeetCode_997_13 {

    /**
     * 根据题意知道法官大人的入度为N-1，出度为0
     * 只要符合这两者的人就是法官
     *
     * @param N 人数
     * @param trust 信任关系集合
     * @return 法官大人代表的数字
     */
    public int findJudge(int N, int[][] trust) {
        // 出度数组
        int[] outDegree = new int[N+1];
        // 入度数组
        int[] inDegree = new int[N+1];

        for (int[] ints : trust) {
            int o = ints[0];
            int in = ints[1];

            outDegree[o] += 1;
            inDegree[in] += 1;
        }

        // 入度为N-1且出度为0的是法官
        for(int i=1; i<N+1; i++) {
            if(inDegree[i] == N-1 && outDegree[i] == 0)
                return i;
        }

        return -1;
    }
}
