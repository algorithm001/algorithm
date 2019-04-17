/*
* 存两个临时变量，left和right, 如果left>right,则返回right;
* 如果只有一个元素，则返回它自己；
* 如果没有旋转过，则返回第一个元素
*/
class Solution {
public:
    int findMin(vector<int>& nums) {
        int count = nums.size();
        if (count == 1) {
            return nums[0];
        }
            
        int left  = nums[0];
        int right = nums[1];
        if (left > right) {
            return right;    
        }
        
        int i;
        for (i = 2; i < count; i++) {
            left  = right;
            right = nums[i];
            
            if (left > right) {
                return right;    
            }
        }
        
        if (i == count) {
            return nums[0];
        }
        
        return -1;
    }
};

