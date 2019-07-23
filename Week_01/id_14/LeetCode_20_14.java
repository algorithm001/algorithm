import java.util.Stack;

/**
* https://leetcode-cn.com/problems/valid-parentheses/
* <p> 栈 stack
* <p> 简单
*/
public class LeetCode_20_14 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] arrs = {"()"
            , "()[]{}"
            , "(]"
            , "([)]"
            , "{[]}"};
        boolean[] results = {true, true, false, false, true};
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i] + ":" + (results[i] == solution.isValid(arrs[i])));
        }
    }

    static class Solution {
        private final static char[] A = {'(', '{', '[', ']', '}', ')'};

        /**
         * 利用java的Stack，遇到左括号，就入栈(push)，遇到右括号就出栈(pop)
         * <pre>
         *     1. 如果需要出栈时，栈为空，无效表达式
         *     2. 左右括号的差值，只有1或2，直接使用当前byte和pop的做差值运算。不等于1或2，就不匹配
         *     3. <strong>性能不太好</strong>
         * </pre>
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            if (s == null) {
                return true;
            }
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == A[0] || chars[i] == A[1] || chars[i] == A[2]) {
                    stack.push(chars[i]);
                } else if (chars[i] == A[3] || chars[i] == A[4] || chars[i] == A[5]) {
                    if(stack.empty()){
                        return false;
                    }
                    /**
                     * <pre>
                     *     40  (
                     *     41  )
                     *     91  [
                     *     93  ]
                     *    123  {
                     *    125  }
                     * </pre>
                     */
                    int tmp = chars[i] - stack.pop();
                    if (tmp != 1 && tmp != 2) {
                        return false;
                    }
                }
            }

            return stack.empty();
        }
    }

}
/**
 * 执行用时 : 7 ms, 在Valid Parentheses的Java提交中击败了79.22% 的用户
 * 内存消耗 : 34 MB, 在Valid Parentheses的Java提交中击败了89.16% 的用户
 */
