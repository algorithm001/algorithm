package com.shufeng.algorithm4.demo;

import java.util.Arrays;

/**
 * @author gsf
 * @date 2019-05-12 09:34
 */
public class LeetCode_455_30 {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        int[] arr1 = {1,2,3};
        int i = findContentChildren(arr, arr1);
        System.out.println(i);
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1;
        int j = s.length - 1;
        int k = 0;
        while (j >= 0 && i >= 0) {
            if (g[i] > s[j]) {
                i--;
                continue;
            }

            j--;
            i--;
            k++;
        }
        return k;
    }
}
