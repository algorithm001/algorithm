class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int m = nums[0];
        int c = 0;
        for(int c = 0,i = 0; i < nums.size();i++)
        {
            if (c == 0)
            {
                m = nums[i]; c = 1;
            }
            else
            {
                m == nums[i] ? c++ : c--;
            }
        }
        return m;
        
    }
};
