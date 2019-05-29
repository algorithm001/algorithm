/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
  const numCounts = new Map()
  nums.forEach(i => {
    if (numCounts.has(i)) {
      numCounts.set(i, numCounts.get(i) + 1)
    } else {
      numCounts.set(i, 1)
    }
  })
  for (let [key, value] of numCounts.entries()) {
    if (value > nums.length / 2) {
      return key
    }
  }
}
