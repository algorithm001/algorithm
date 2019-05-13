/**
 * @param {number} k
 * @param {number[]} nums
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */

// left=2*parent+1;right=2*parent+2;
// min top heap
class KthLargest {
  constructor(k, nums) {

    // 如果 nums 的长度 小于k； 用最小值 填充元素。（题目规定 k<=nums.length-1）
    nums.push(Number.MIN_SAFE_INTEGER);

    this.length = k;
    this.data = new Array(k);
    this.data[0] = nums[0];
    const len = nums.length;
    for (let i = 1; i < len; i++) {
      if (i < k) {
        this.data[i] = nums[i];
        this.makeHeap(i);
      } else {
        this.add(nums[i]);
      }
    }
  }
  add(num) {
    const top = this.getTop();
    if (num > top ) {
      this.delTop();
      this.data[this.length - 1] = num;
      this.makeHeap(this.length - 1);
    }
    return this.getTop();
  }
  getParentIndexByMyIndex(index) {
    return index % 2 === 1 ? (index - 1) / 2 : (index - 2) / 2;
  }
  getChildrenIndexByParentIndex(index) {
    return {
      left: 2 * index + 1,
      right: 2 * index + 2
    };
  }

  // 从上到下堆化（用于替换堆顶元素后）
  makeHeapDown(index) {
    if (index >= this.length) {
      return;
    }

    const { left, right } = this.getChildrenIndexByParentIndex(index);
    const leftValue =
      left < this.length ? this.data[left] : Number.MAX_SAFE_INTEGER;
    const rightValue =
      right < this.length ? this.data[right] : Number.MAX_SAFE_INTEGER;
    const value =
      index < this.length ? this.data[index] : Number.MIN_SAFE_INTEGER;

    if (leftValue <= rightValue && leftValue < value) {
      // l
      [this.data[index], this.data[left]] = [this.data[left], this.data[index]];

      this.makeHeapDown(left);
    } else if (rightValue < leftValue && rightValue < value) {
      // r
      [this.data[index], this.data[right]] = [
        this.data[right],
        this.data[index]
      ];
      this.makeHeapDown(right);
    }
  }

  // 从下到上 堆化（用于添加一个元素）
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
  delTop() {
    this.data[0] = this.data[this.length - 1];
    this.makeHeapDown(0);
  }
  getTop() {
    return this.data[0];
  }
}
