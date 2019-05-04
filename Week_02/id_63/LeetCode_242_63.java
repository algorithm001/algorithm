/*
242. 有效的字母异位词
题目描述
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (t.length() < s.length()) {
            return false;
        }
        short[] flags = new short[26];
        for (int i = 0; i < s.length(); i++) {
            flags[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            flags[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (flags[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
