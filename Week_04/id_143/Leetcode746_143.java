public class Leetcode746_143 {

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int length=cost.length;
            if(length<2){
                return 0;
            }

            if(length==2){
                return Math.min(cost[0],cost[1]);
            }

            for(int i=2;i<length;i++){
                cost[i]+=Math.min(cost[i-1],cost[i-2]);
            }

            return Math.min(cost[length-2],cost[length-1]);
        }
    }
}
