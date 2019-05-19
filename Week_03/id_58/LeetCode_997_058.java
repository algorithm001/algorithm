package algorithm.Week_03.id_58;

/**
 * 997. Find the Town Judge
 *
 *In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Note:
 *
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 *
 *
 * 分析：此题主要是理解题意，找出法官，也可以用有向图解
 * 评论里的解法很巧妙，值得学习！！
 *
 * 法官：入度为N-1 出度为0的结点（其他人都指向法官，法官不指向其他人）
 *
 *
 * @auther: guangjun.ma 
 * @date: 2019/5/5 20:10
 * @version: 1.0
 */
public class LeetCode_997_058 {
    public int findJudge(int N, int[][] trust) {
        //定义一个二维数据,第一个放入度，第二个放出度
        int[][]  people = new int[N][2];

        //遍历所有的结点，计算所有结点的入度和出度
        for(int[] person :  trust){
            int out = person[0];
            int in = person[1];
            people[out - 1][0]++;
            people[in - 1][1]++;
        }

        //找出入度为N-1 出度为0的结点，即为法官
        for(int i = 0 ; i < N ; i++){
            if(people[i][0] == 0 && people[i][1] == N -1){
                return i+1;
            }
        }

        //未找到，默认处理 -1
        return - 1;
    }

}
