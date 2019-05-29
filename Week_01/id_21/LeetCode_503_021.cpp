// 暴力破解方法
class Solution {
public:
  vector<int> nextGreaterElements(vector<int>& nums) {
    vector<int> result;

    if (nums.size() == 1) {
      result.push_back(-1);
      return result;
    }

    int i, j;
    for(i = 0; i < nums.size(); i ++) {
      
      if(i == nums.size() - 1) {
        j = 0;
      } else {
        j = i + 1;
      }
      while(j != i) {
        if (nums[j] > nums[i]) {
          result.push_back(nums[j]);
          break;
        }
        if (j == nums.size() - 1) {
          j = 0;
        } else {
          j++;
        }
        
      }
      if (i == j) result.push_back(-1);
    }
    return result;
  }
};