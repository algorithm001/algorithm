// https://leetcode.com/problems/kth-largest-element-in-a-stream/

/**
 * @param {number} k
 * @param {number[]} nums
 */
var KthLargest = function(k, nums) {
  this.minHeap = new MinHeap(k);
  nums.forEach(n => this.minHeap.add(n));
};

/**
 * @param {number} val
 * @return {number}
 */
KthLargest.prototype.add = function(val) {
  return this.minHeap.add(val);
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = Object.create(KthLargest).createNew(k, nums)
 * var param_1 = obj.add(val)
 */

// /**
//  * @param {number} k
//  * @param {number[]} nums
//  */
// var KthLargest = function(k, nums) {
//   this.k = k - 1;
//   this.sortArray = nums.sort((a, b) => b - a);
//   this.Kth = this.sortArray[k];
// };

// /**
//  * @param {number} val
//  * @return {number}
//  */
// KthLargest.prototype.add = function(val) {
//   const len = this.sortArray.length;
//   if (len === 0) {
//     this.sortArray = [val];
//     return val;
//   }
//   let i = len - 1;
//   while (i >= -1) {
//     if (val > this.sortArray[i]) {
//       this.sortArray[i + 1] = this.sortArray[i];
//       i--;
//     } else {
//       this.sortArray[i + 1] = val;
//       break;
//     }
//   }

//   return this.sortArray[this.k];
// };

// /**
//  * Your KthLargest object will be instantiated and called as such:
//  * var obj = new KthLargest(k, nums)
//  * var param_1 = obj.add(val)
//  */
