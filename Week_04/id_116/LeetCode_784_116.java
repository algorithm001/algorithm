package backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @see
 * @since 2019/5/10
 */
public class LeetCode_784_116 {

    List<String> list = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] cs = s.toCharArray();
        recursion(cs, 0);
        return list;
    }

    private void recursion(char[] cs, int i) {
        if (cs.length == i) {
            list.add(new String(cs));
            return;
        }
        int j;
        if ((j = cs[i]) >= 'a' && (j = cs[i]) <= 'z') {
            recursion(cs, i + 1);
            cs[i] = (char) (j - 32);
            recursion(cs, i + 1);
        } else if (j >= 'A' && j <= 'Z') {
            recursion(cs, i + 1);
            cs[i] = (char) (j + 32);
            recursion(cs, i + 1);
        } else {
            recursion(cs, i + 1);
        }
    }

}
