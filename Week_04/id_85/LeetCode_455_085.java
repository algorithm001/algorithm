import java.util.Arrays;

public class LeetCode_455_085 {
}

/**
 * @Package:
 * @ClassName: AssignCookies
 * @Description: 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * **************对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
 * **************如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * **************你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * **************注意：
 * **************你可以假设胃口值为正。
 * **************一个小朋友最多只能拥有一块饼干。
 * @leetcode_url:https://leetcode-cn.com/problems/assign-cookies/
 * @Author: wangzhao
 * @Date: 2019-05-12 10:14:17
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        if (g == null || g.length == 0) {
            return 0;
        }
        if (s == null || s.length == 0) {
            return 0;
        }

        int child = 0;
        int cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }

        return child;
    }

    public static void main(String[] args) {

        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        int num = new AssignCookies().findContentChildren(g, s);
        System.out.println(num);
    }

}
