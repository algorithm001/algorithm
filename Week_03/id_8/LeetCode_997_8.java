class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] a = new int[N + 1];
        for (int[] t : trust) {
            ++a[t[1]];
            --a[t[0]];
        }
        for (int i = 1; i < N + 1; ++i) {
            if (a[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}