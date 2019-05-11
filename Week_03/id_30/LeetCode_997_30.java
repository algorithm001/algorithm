package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_997_30 {

    public static void main(String[] args) {
        int[][] trust = new int[2][2];
        int[] a = {1, 3};
        int[] a1 = {2, 3};

        trust[0] = a;
        trust[1] = a1;


        int judge = findJudge(1, trust);
        System.out.println(judge);
    }

    public static int findJudge(int N, int[][] trust) {
        int[] arr = new int[N + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < trust.length; i++) {
            if (trust[i].length > 0) {
                arr[trust[i][1]]++;
                set.add(trust[i][0]);
            }
        }

        if (set.size() != N - 1) {
            System.out.println(set.size());
            return -1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}

