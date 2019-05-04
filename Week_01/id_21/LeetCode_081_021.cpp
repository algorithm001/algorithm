/*
 * BF: 直接遍历，算法复杂度 O(N)
 */
class Solution {
public:
  bool search(vector<int>& nums, int target) {
    for(auto itr = nums.begin(); itr != nums.end(); itr++) {
      if (*itr == target) return true;
    }
    return false;
  }
};

/*
 * 二分法查找
 */
class Solution {
public:
  bool search(vector<int>& nums, int target) {
    if (nums.size() < 1) return false;
    if (nums.size() == 1) return nums[0] == target;
    // 前半段，顺序查找 target
    // 如果没有找到 target ，但是找到反转的位置，则停止顺序查找
    int begin = 0;
    while (begin + 1 < nums.size()) {
      if (nums[begin] == target || nums[begin + 1] == target) return true;
      if (nums[begin] > nums[begin + 1]) break;
      begin++;
    }

    // 后半段使用二分法查找
    int end = nums.size();
    while (begin + 1 < end && end <= nums.size()) {
      int pos = (begin + end) / 2;
      if (nums[pos] == target) return true;
      if (begin == end) break;
      if (nums[pos] < target) begin = pos;
      else end = pos;
    }

    return false;
  }
};