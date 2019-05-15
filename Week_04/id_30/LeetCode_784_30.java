package com.shufeng.algorithm4.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gsf
 * @date 2019-05-12 10:04
 */
public class LeetCode_784_30 {
    public static void main(String[] args) {

        String str = "a1b2";
//        char c = 'A';
//        System.out.println((int) c);
//        System.out.println(c);
        List<String> list = letterCasePermutation(str);
        System.out.println(list);
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        char[] chars = S.toCharArray();
        letterCasePermutation(list, chars, "");
        return list;
    }

    public static void letterCasePermutation(List<String> list, char[] chars, String str) {
        if (chars.length == str.length()) {
            list.add(str);
            return;
        }

        char c = chars[str.length()];
        String s = String.valueOf(c);

        if (c >= 'A' && c <= 'z') {
            letterCasePermutation(list, chars, str + s.toLowerCase());
            letterCasePermutation(list, chars, str + s.toUpperCase());
        } else {
            letterCasePermutation(list, chars, str + s);
        }
    }
}
