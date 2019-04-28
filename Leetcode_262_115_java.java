package data.leetcode.hash;

import java.util.HashMap;

public class Leetcode262 {
    /**
     * 执行时间过长
     * 执行用时 : 57 ms, 在Valid Anagram的Java提交中击败了15.39% 的用户
     * 内存消耗 : 41.9 MB, 在Valid Anagram的Java提交中击败了25.98% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer integer = sMap.get(c);
            if (integer == null) {
                integer = 0;
            }
            sMap.put(c, ++integer);
        }
        for (int i = 0; i < t.length(); i++) {
            if (sMap.containsKey(t.charAt(i))) {
                Integer integer = sMap.get(t.charAt(i));
                integer--;
                if (integer == 0) {
                    sMap.remove(t.charAt(i));
                } else {
                    sMap.put(t.charAt(i), integer);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 第二种解法，是将数据进行一个因射到26位字母
     * <p>
     * 执行用时 : 4 ms, 在Valid Anagram的Java提交中击败了96.25% 的用户
     * 内存消耗 : 38.1 MB, 在Valid Anagram的Java提交中击败了95.44% 的用户
     * 进行下一个挑战：
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq1[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            freq2[t.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {


        isAnagram2("aacc", "ccac");//false

        isAnagram2("aacc", "caac");//true

    }
}
