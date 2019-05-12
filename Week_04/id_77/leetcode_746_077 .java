class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int l = cost.length;
        for(int i=2;i<l;i++){
            cost[i] = min(cost[i-2],cost[i-1]) + cost[i];
        }
        return min(cost[l-2],cost[l-1]);
    }
    
  
    public int min(int x,int y){
        return x<y?x:y;
    }
                          
                         
}