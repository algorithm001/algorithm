package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_922_30 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4, 0, 0, 4, 3, 3};
        int[] ints = sortArrayByParity(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return A;
        }
        int j = 0;
        int i = 1;
        while (j < A.length && i < A.length) {
            if ((A[i] & 1) == (i & 1)) {
                i += 2;
                continue;
            }
            if ((A[j] & 1) == (j & 1)) {
                j += 2;
                continue;
            }
            swap(A, i, j);
        }
        return A;
    }

    public static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}
