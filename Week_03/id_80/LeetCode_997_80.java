//通过出度入度 来判断
//如果是秘密法官，则入度 =N-1,出度 =0；
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] peoples = new int[N][2];
        for(int[] people : trust){
            int out = people[0];
            int in = people[1];
            peoples[out - 1][0] ++;
            peoples[in - 1][1] ++;
        }
        for(int i = 0; i < N; i++){
            if(peoples[i][0] == 0 && peoples[i][1] == N - 1)
                return i + 1;
        }
        return -1;
    }
}