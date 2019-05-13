Method 1:
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        return nums[nums.size()/2];
    }
};


Method 2:
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int num = nums[0];
        int cnt = 1;
        for(int i = 1; i < nums.size(); i++){
            if(nums[i] == num) {
                cnt++;
            } else{
                if(cnt > 0) cnt--;
                else{
                    num = nums[i];
                    cnt = 1;
                }
            }
        }
        return num;
    }
};

Method 3:
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        vector<int> bits(32,0);
        for(int num : nums) {
            for(int i = 0; i < 32; i++) {
                bits[i] += (num >> (31- i)) & 1; // get the number of 1
            }
        }
        
        int res = 0;
        for(int i = 0; i < 32; i++) {
            if(bits[i] > (nums.size()/2)) {
                res |= (1 << (31 - i));
            }
        }
        return res;
    }
};

