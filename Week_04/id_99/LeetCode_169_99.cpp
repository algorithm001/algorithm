class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int size = nums.size();
        if(1 == size) {
            return nums[0];
        }
        
        vector<int> left(&nums[0], &nums[size/2]);
        vector<int> right(&nums[size/2], &nums[size]);
        
        int leftMajor = majorityElement(left);
        int rightMajor = majorityElement(right);
        
        if (leftMajor == rightMajor) {
            return leftMajor;
        } else {
            int leftCount = 0, rightCount = 0;
            for (int i = 0; i<size; ++i) {
                if(nums[i] == leftMajor) {
                    leftCount++;
                }
                if(nums[i] == rightMajor) {
                    rightCount++;
                }
            }
            return leftCount > rightCount?leftMajor:rightMajor;
        }
    }
    
};