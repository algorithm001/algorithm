class LeetCode_997_95 {
    public int findJudge(int N, int[][] trust) {
        int i,j;
        int[] res = new int[N];
        int[] flag = new int[N];
        for(i=0;i<trust.length;i++) {
            flag[trust[i][0]-1]=1;//信任了别人，不可能是法官
            res[trust[i][1]-1]++; //统计这个人被信任的次数
        }
        for(i=0;i<N;i++) {
            if(res[i]==N-1 && flag[i]==0) {
                return i+1;
            }
        }
        return -1;
    }
}