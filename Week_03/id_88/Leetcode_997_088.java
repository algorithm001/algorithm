class Solution {
    public int findJudge(int N, int[][] trust) {
        int trustNum[] = new int[N];
        int trustedNum[] = new int[N];
        int numOnCondition = 0;
        int ret = 0;
        
        for(int[] trustPair : trust)
        {
            trustNum[trustPair[0] - 1]++;
            trustedNum[trustPair[1] - 1]++;
        }
        
        int i = 0;
        for( ; i < N; i++)
        {
            if(trustNum[i] == 0)
            {
                if(trustedNum[i] == N - 1)
                {
                    numOnCondition++;
                    ret = i+1;
                }
            }
        }
        
        if(numOnCondition > 1 || numOnCondition == 0) return -1;
        
        return ret;
    }
};