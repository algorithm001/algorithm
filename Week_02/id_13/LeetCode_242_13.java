package leetCode.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * valid-anagram：
 * https://leetcode.com/problems/valid-anagram/
 *
 * @author JP.Jiang
 * @version Java
 * @since 2019/04/23
 */

public class LeetCode_242_13 {

    /**
     * 【week2】
     * 利用哈希表解决这个问题
     * 遍历字符串，对读取过的单个字符进行计数
     * 利用Map计数 {letter:count}
     * 两个遍历后的Map进行对比
     * <p>
     * 时间复杂度：
     * 令字符串s长度为n
     * 遍历字符串 -- O(n)
     * Map中计数 -- O(1)
     * 总体复杂度 -- O(n)
     *
     * @param s source string
     * @param t target string
     * @return source equals target -> true ; else -> false
     */
    public boolean isAnagram(String s, String t) {
        return countMap(s).equals(countMap(t));
    }

    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!countMap.containsKey(ch)) {
                countMap.put(ch, 1);
            } else {
                countMap.replace(ch, countMap.get(ch) + 1);
            }
        }
        return countMap;
    }

    /**
     * 【week1】
     * 拿到两个字符串先排序
     * 如果两个排序后的字符串相等
     * 那么就是一样的
     * <p>
     * 时间复杂度：
     * 令字符串s长度为n
     * O(N*logN)
     *
     * @param s source string
     * @param t target string
     * @return source equals target -> true ; else -> false
     */
    public boolean isAnagramForWeek1(String s, String t) {
        return sorted(s).equals(sorted(t));
    }

    private String sorted(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return Arrays.toString(ch);
    }
}
