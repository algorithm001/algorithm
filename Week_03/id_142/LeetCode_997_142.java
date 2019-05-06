class Solution {

    public int findJudge(int N, int[][] trust) {
        int[] trustArr = new int[N + 1];   // how many people this person trusts
        int[] trustedArr = new int[N + 1]; // how many people trust this person
        for (int[] pair : trust) {
            trustArr[pair[0]]++;
            trustedArr[pair[1]]++;
        }
        int judge = -1;
        for (int i = 1; i <= N; i++) {
            if (trustArr[i] == 0) { // not trust anyone, may be the judge
                if (judge == -1) {
                    judge = i;      // update judge
                } else {
                    return -1;      // got the second judge, return -1
                }
            }
        }
        // the judge must be trusted by N-1 people.
        if (judge != -1 && trustedArr[judge] == N - 1) {
            return judge;
        }
        return -1;
    }
}
