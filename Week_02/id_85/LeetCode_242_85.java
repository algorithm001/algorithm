import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_242_85 {
}

/**
 * @Package:
 * @ClassName: ValidAnagram
 * @Description: 有效的字母异位词 难度：简单
 * @Author: wangzhao
 * @Date: 2019-04-22 18:48:46
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        HashMap<Character, Integer> map = new HashMap();
        for (char c : sarr) {

            Integer n = map.get(c);
            if (n == null) {
                map.put(c, 1);
            } else {
                map.put(c, n + 1);
            }
        }
        for (char c : tarr) {
            Integer n = map.get(c);
            if (n == null || n == 0) {
                return false;
            } else {
                map.put(c, n - 1);
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {

        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        Arrays.sort(sarr);
        Arrays.sort(tarr);

        return Arrays.equals(sarr, tarr);
    }


    public static void main(String[] args) {

        String s = "ac";
        String t = "bb";
        boolean r = new ValidAnagram().isAnagram(s, t);
        System.out.println(r);

        r = new ValidAnagram().isAnagram2(s, t);
        System.out.println(r);
    }


}
