//https://leetcode.com/problems/valid-anagram/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null && t != null || s != null && t == null || s.length() != t.length())
            return false;
        int[] sarr = new int[26];
        int[] tarr = new int[26];
        for (int i=0; i<s.length(); i++) {
            sarr[s.charAt(i)-'a']++;
            tarr[t.charAt(i)-'a']++;
        }
        for (int i=0; i<26; i++) {
            if (sarr[i] != tarr[i])
                return false;
        }
        return true;
    }
}