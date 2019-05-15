class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] in = new int[N+1];
        int[] out = new int[N+1];
        for(int i=0;i<trust.length;i++){
            out[trust[i][0]] ++;
            in[trust[i][1]] ++;
        }
        int res = -1;
        int target = N-1;
        for(int i= 1;i<=N;i++){
            if(in[i]==target && out[i]==0){
                res = i;
                break;
            }
        }
        return res;
    }
}