class Solution {
public:
    int majorityElement(vector<int>& nums) {
        /* 建立hash表　key-value */
        unordered_map<int, int> map;
        int ret = 0;
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            map[nums[i]]++;
            if (map[nums[i]]>len/2) {
                ret = nums[i];
                break;
            }
        }
        return ret;
    }
};
