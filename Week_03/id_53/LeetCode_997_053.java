/**
 * leetcode 997
 *
 * @author hewei
 * @date 2019/5/4 09:13
 */
public class LeetCode_997_053 {
    public int findJudge(int N, int[][] trust) {
        int[] outgoing = new int[N+1];
        int[] incoming = new int[N+1];

        for(int i=0; i<trust.length; i++) {
            int o = trust[i][0];
            int in = trust[i][1];

            outgoing[o] += 1;
            incoming[in] += 1;
        }

        for(int i=1; i<N+1; i++) {
            if(incoming[i] == N-1 && outgoing[i] == 0)
                return i;
        }
        return -1;
    }
}
