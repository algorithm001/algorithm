/**
 * @param {number[]} cost
 * @return {number}
 * https://leetcode.com/problems/min-cost-climbing-stairs/submissions/
 */
var minCostClimbingStairs = function(cost) {
  cost.push(0);
  let index=cost.length-1;

  //add cache
  const cache={};

  const getCost=index=>{
    if(index<2){
      return cost[index];
    }
    if(cache[index]!==undefined){
      return cache[index];
    }
    const sum= cost[index]+Math.min(getCost(index-1),getCost(index-2));
    cache[index]=sum;
    return sum;
  }
  return getCost(index);

};