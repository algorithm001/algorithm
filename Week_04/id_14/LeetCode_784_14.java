import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-case-permutation/
 *
 * <P> 简单
 * <p> backtracking
 * S 的长度不超过12。 S 仅由数字和字母组成。
 *
 * @author aiter
 * @date 2019/05/10 6:37 AM
 */
public class LeetCode_784_14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        System.out.println(String.format("输出值：%s", solution.letterCasePermutation("a1b2")));
        System.out.println(String.format("输出值：%s", solution2.letterCasePermutation("a1b2")));
        System.out.println(String.format("输出值：%s", solution.letterCasePermutation("a12b")));
        System.out.println(String.format("输出值：%s", solution2.letterCasePermutation("a12b")));
        System.out.println(String.format("输出值：%s", solution.letterCasePermutation("a1b2c3")));
        System.out.println(String.format("输出值：%s", solution2.letterCasePermutation("a1b2c3")));
        System.out.println(String.format("输出值：%s", solution.letterCasePermutation("3z4")));
        System.out.println(String.format("输出值：%s", solution2.letterCasePermutation("3z4")));
        System.out.println(String.format("输出值：%s", solution.letterCasePermutation("12345")));
        System.out.println(String.format("输出值：%s", solution2.letterCasePermutation("12345")));
    }

    /**
     * 这种方式更优雅一下。终止条件的地方添加list元素
     */
    static class Solution2 {
        public List<String> letterCasePermutation(String S) {
            char[] chars = S.toCharArray();
            List<String> list = new ArrayList<>();

            getWord(list, chars, 0);

            return list;
        }

        private void getWord(List<String> list, char[] chars, int n) {
            if (n == chars.length) {
                list.add(new String(chars));
                return;
            }
            char c = chars[n];
            //递归下一个字符
            getWord(list, chars, n + 1);

            if (c >= 'a' && c <= 'z') {
                chars[n] = Character.toUpperCase(c);
                getWord(list, chars, n + 1);
            } else if (c >= 'A' && c <= 'Z') {
                chars[n] = Character.toLowerCase(c);
                getWord(list, chars, n + 1);
            }
        }
    }

    /**
     * 自己实现的方式，感觉有点绕。
     */
    static class Solution {
        public List<String> letterCasePermutation(String S) {
            char[] chars = S.toCharArray();
            List<String> list = new ArrayList<>();

            list.add(S);
            getWord(list, chars, 0);

            return list;
        }

        private void getWord(List<String> list, char[] chars, int n) {
            if (n == chars.length) {
                return;
            }
            char c = chars[n];
            if (c >= 'A' && c <= 'z') {
                int m = n + 1;
                //如果是字母，先使用本身递归，然后大小写转换后再递归一次
                getWord(list, chars, m);

                if (c <= 'Z') {
                    chars[n] = Character.toLowerCase(c);
                    list.add(new String(chars));
                    getWord(list, chars, m);
                } else {
                    chars[n] = Character.toUpperCase(c);
                    list.add(new String(chars));
                    getWord(list, chars, m);
                }
            } else {
                //非字母，就直接递归下一个字符
                getWord(list, chars, n + 1);
            }
        }
    }
}
