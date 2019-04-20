package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_905_30 {

    public static int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return A;
        }
        int j = A.length - 1;
        int i = 0;
        while (i < j) {
            if ((A[i] & 1) == 1) {
                swap(A, i, j);
                j--;
                continue;
            }
            i++;
        }
        return A;
    }
    public static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}
