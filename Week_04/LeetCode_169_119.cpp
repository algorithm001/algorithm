class Solution {
public:
    int majorityElement(vector<int>& nums) {
//         //哈希解法
//         unordered_map<int,int> digit_count;
        
//         for (int i = 0; i < nums.size(); i++) {
//             digit_count[nums[i]]++;
//             if (i >= (nums.size()>>1) && digit_count[nums[i]] > (nums.size()>>1)) {
//                     return nums[i];
//                 }
//         }
        
//         return -1;
        // 摩尔投票法
        int res = 0, cnt = 0;
        for (int num:nums) {
            if (cnt == 0) {
                res = num;
                cnt++;
            } else {
                if (res == num) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        return res;
    }
};
