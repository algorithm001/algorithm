import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetCode 720
 * 
 * @author apple
 */
public class Solution {

    public static String longestWord(String[] words) {
        Arrays.sort(words); // 首先使用 Arrays
                            // 工具类对字符串数组进行排序，字符串长度长的在后面，字符串长的肯定包含字符串短的
        Set<String> set = new HashSet<>(); // 保存满足要求的字符串
        String res = "";
        // 开始遍历数组
        for (String s : words) {
            // 如果字符串的长度为1， 那么res=s，并且将其放到set中，如果字符串的长度大于1，那么如果其 length-1 在set
            // 中，那么res = s
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        longestWord(new String[] { "w", "a", "wo", "wor", "worl", "world" });
    }
}

