package com.geek.week02;

public class LeetCode_242_036_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'a']--;
        }

        boolean result = true;
        for (int i : map) {
            if (i != 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
