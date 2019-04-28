package com.leetcode.hash;

/**
 * 242. 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *  示例 1:
 *      输入: s = "anagram", t = "nagaram"
 *      输出: true
 *
 *  示例 2:
 *      输入: s = "rat", t = "car"
 *      输出: false
 *
 *  思路分析：只要记录两个字符串各个字符串出现的次数，然后判断是否相同即可。（时间复杂度O(n)，空间复杂度O(1)）
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] cntVec = new int[26];

        for (int i = 0;i < s.length();i++)
            cntVec[s.charAt(i) - 'a'] += 1;

        for (int j = 0;j <t.length();j++)
            cntVec[t.charAt(j) - 'a'] -= 1;

        for (int k = 0; k < cntVec.length;k++){
            if (cntVec[k] != 0)
                return false;
        }
        return true;
    }

}
