/**
 * @param {number} k
 * @param {number[]} nums
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
var KthLargest = function(k, nums) {
  this.k = k;
  this.nums = nums;
};

// left=2*parent+1;right=2*parent+2;
// min top heap
class Heap {
  constructor(k, nums) {
    this.data = new Array(k);
    this.data[0] = nums[0];
    for (let i = 1; i < nums.length; i++) {
      if (i < k - 1) {
        this.data[i] = nums[i];
        this.makeHeap(i);
      } else {
       this.add(nums[i]);
      }
    }
  }
  add(num) {
    if(num>this.getTop()){
      this.delTop();
      this.data[k-1]=nums[i];
      this.makeHeap(k-1);
    }
  }
  getParentIndexByMyIndex(index) {
    return index % 2 === 1 ? (index - 1) / 2 : (index - 2) / 2;
  }
  makeHeap(index) {
    if (0 === index) {
      return;
    }
    let parentIndex = this.getParentIndexByMyIndex(index);
    let curentIndex = index;

    // min Heap sweap
    if (this.data[parentIndex] > this.data[curentIndex]) {
      [this.data[parentIndex], this.data[curentIndex]] = [
        this.data[curentIndex],
        this.data[parentIndex]
      ];
    }
    this.makeHeap(parentIndex);
  }

  delTop() {}
  getTop() {
    return this.data[0];
  }
}

/**
 * @param {number} val
 * @return {number}
 */
KthLargest.prototype.add = function(val) {};

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(val)
 */
