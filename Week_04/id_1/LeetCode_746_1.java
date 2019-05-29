
// 解法正确但是因为大量重复计算超时
// class Solution {
//     private int[] cost;
//       public int minCostClimbingStairs(int[] cost) {
  
//           this.cost = cost;
//           int len = cost.length;
  
//           return Math.min(minCost(len-1), minCost(len-2));
//       }
  
//       public int minCost(int n) {
  
//           if (n <= 1) {
//               return this.cost[n];
//           }
//           return this.cost[n] + Math.min(minCost(n-1), minCost(n-2));
  
//       }   
//   }

// 参考 discuss 部分的结果，将数据中的值相加，而不是取值计算
class Solution {
    private int[] cost;
      public int minCostClimbingStairs(int[] cost) {
  
         for (int i = 2; i < cost.length; i++) {
              cost[i] += Math.min(cost[i-1], cost[i-2]);
          }
          return Math.min(cost[cost.length-1], cost[cost.length-2]);
      }  
  }


  