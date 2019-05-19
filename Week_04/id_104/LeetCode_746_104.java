class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length=cost.length;
        int[] depth=new int[length];
        depth[0]=cost[0];
        depth[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            depth[i]=Math.min(depth[i-1],depth[i-2])+cost[i];
        }
        return Math.min(depth[length-1],depth[length-2]);
    
    }
}