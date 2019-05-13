/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function (cost) {
  let minClimbingStairsMap = new Map()
  return minCost(cost.length, cost, minClimbingStairsMap)
}

const minCost = (stairs, cost, minClimbingStairsMap) => {
  if (minClimbingStairsMap.has(stairs)) {
    return minClimbingStairsMap.get(stairs)
  }
  const oneStairsBeforeCost = stairs - 1 < 0 ? 0 : minCost(stairs - 1, cost, minClimbingStairsMap) + cost[stairs - 1]
  const twoStairsBeforeCost = stairs - 2 < 0 ? 0 : minCost(stairs - 2, cost, minClimbingStairsMap) + cost[stairs - 2]
  const stairsResult = Math.min(oneStairsBeforeCost, twoStairsBeforeCost)
  minClimbingStairsMap.set(stairs, stairsResult)
  return stairsResult
}
