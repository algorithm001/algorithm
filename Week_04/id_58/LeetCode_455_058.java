package algorithm.Week_04.id_58;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 *
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 *
 * Example 1:
 * Input: [1,2,3], [1,1]
 *
 * Output: 1
 *
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 * Example 2:
 * Input: [1,2], [1,2,3]
 *
 * Output: 2
 *
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 *
 * 分析：
 * 贪心的思想就是用最少的饼干去满足最多孩子
 *
 * @auther: guangjun.ma 
 * @date: 2019/5/12 23:25
 * @version: 1.0
 */
public class LeetCode_455_058 {
    public int findContentChildren(int[] g, int[] s) {
        //初始化孩子、饼干的个数
        int child = 0;
        int cookie = 0;

        //比较操作的前提是排序
        Arrays.sort(g);
        Arrays.sort(s);

        //分配
        while(child < g.length && cookie < s.length){//若孩子或者饼干遍历完毕则退出
            //该饼干刚好满足孩子则加一
            if(g[child] <= s[cookie]){
                child++;
            }
            //若不能满足则用下一个饼干尝试
            cookie++;
        }
        //最后返回孩子的个数即可
        return child;
    }
}
