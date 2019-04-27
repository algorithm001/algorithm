import java.util.Arrays;

/**
 * leetcode 242
 *
 * @author hewei
 * @date 2019/4/26 20:10
 */
public class LeetCode_242_53 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar,tChar);
    }


}
