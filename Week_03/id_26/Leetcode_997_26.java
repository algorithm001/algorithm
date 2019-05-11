package com.fanlu.leetcode.graph;
// Source : https://leetcode.com/problems/find-the-town-judge/
// Id     : 997
// Author : Fanlu Hai
// Date   : 2018-05-03
// Other  :
// Tips   :


public class FindTheTownJudge {

    //98.73% 100.00%
    public int findJudge(int N, int[][] trust) {
        boolean[] notJudge = new boolean[N + 1];
        int[] beingTrusted = new int[N + 1];

        for (int[] pair : trust) {
            // if trust others, then not judge
            notJudge[pair[0]] = true;

            boolean not = notJudge[pair[0]];
            int beTru = pair[1];

            if (notJudge[pair[1]]) {
                continue;
            }
            beingTrusted[pair[1]]++;
        }

        for (int i = 1; i < N + 1; i++) {
            if (beingTrusted[i] == N - 1 && !notJudge[i])
                return i;
        }
        return -1;
    }

}
