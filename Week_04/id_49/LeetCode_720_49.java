package com.v0ex.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bugcoder
 */
public class LeetCode_720_49 {

    /**
     * brute force + 剪枝法
     * @param words
     * @return
     */
    public String longestWord(String[] words){
        String result = "";
        Set<String> set = new HashSet<>();
        for(String word : words){
            set.add(word);
        }
        for(String word: words){
            //凡是小于目标字符串长度的字符串都不符合要求
            if(word.length() < result.length() ||
                    //长度相等，但是按照字典顺序大于目标字符串长度的也不符合要求
                    word.length()== result.length()&&word.compareTo(result)>0){
                continue;
            }
            boolean flag = true;
            for(int i = 1;i < word.length();i++){
                if(!set.contains(word.substring(0,i))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result = word;
            }
        }
        return result;
    }
}
