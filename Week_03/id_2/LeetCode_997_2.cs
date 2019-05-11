public class Solution {
    public int FindJudge(int N, int[][] trust) {
        
        int[][] arr = new int[N][];
        for(int i = 0; i < arr.Length; i++)
        {
            arr[i] = new int[2];
        }
        
        
        foreach(var item in trust)
        {
            arr[item[0]-1][0]++;
            arr[item[1]-1][1]++;
        }
        
        for(int i = 0;i < arr.Length; i++)
        {
            if(arr[i][0] == 0 && arr[i][1] == N - 1)
            {
                return i+1;
            }
        }
        return -1;
    }
}
