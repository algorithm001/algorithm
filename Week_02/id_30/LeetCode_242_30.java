package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_242_30 {

    public static void main(String[] args) {
        System.out.println((int) 'a');

        String s = "aa", t = "bb";
        System.out.println(isAnagram1(s, t));
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return String.valueOf(ss).equals(String.valueOf(tt));
    }
}

