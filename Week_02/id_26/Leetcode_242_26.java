package com.fanlu.leetcode.hashtable;
// Source : https://leetcode.com/problems/valid-anagram/
// Id     : 242
// Author : Fanlu Hai
// Date   : 2018-04-22
// Other  : anagram noun. a word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman.
// Tips   : 1.Use int[] with ascii as hash table; 2.use 'for i certain numbers' instead of 'for reach'.

public class ValidAnagram {

    //38.34%  70.24%
    public boolean isAnagramSlow(String s, String t) {
        if (null == s || null == t)
            return false;
        if (s.length() != t.length())
            return false;

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int tmpS = s.charAt(i) - 'a';
            int tmpT = t.charAt(i) - 'a';
            letters[tmpS]++;
            letters[tmpT]--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0)
                return false;
        }
        return true;
    }

    // try to remove tmp variables to see if it runs faster
    // And it does
    // 72.38% 70.94%
    public boolean isAnagramFast(String s, String t) {
        if (null == s || null == t)
            return false;
        if (s.length() != t.length())
            return false;

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
            letters[t.charAt(i) - 'a']--;
        }

        for (int i : letters) {
            if (letters[i] != 0)
                return false;
        }
        return true;
    }


    // try to remove tmp variables to see if it runs faster
    // And it does
    // use for i instead of for reach, it becomes even faster
    // 90.46% 71.14%
    public boolean isAnagram(String s, String t) {
        if (null == s || null == t)
            return false;
        if (s.length() != t.length())
            return false;

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
            letters[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("abcdefg", "abcdefg"));
        System.out.println(validAnagram.isAnagram("abcdefg", "abcdefgg"));
        System.out.println(validAnagram.isAnagram("abcdefg", "gbcdefa"));
        System.out.println(validAnagram.isAnagram("aaaaaaa", "aaaaaba"));
        System.out.println(validAnagram.isAnagram(null, null));
    }
}
