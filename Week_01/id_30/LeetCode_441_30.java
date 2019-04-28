package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_441_30 {

    public static void main(String[] args) {
        int i = arrangeCoins(5);
        System.out.println(i);
    }
    public static int arrangeCoins(int n) {
        if (n <= 1) {
            return n;
        }
        long low = 0;
        long high = n;
        while (low < high) {
            // 二分法查询硬币可以摆放的行数
            long mid = low + (high - low) / 2;
            // 核心公式 放满n行用的硬币数：n*(n+1)/2
            // 如果给的硬币数大于mid，证明比这行多去右面去找行数，如果小去左边找行数
            if (mid * (mid + 1) / 2 <= n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int) (low - 1);
    }
}
