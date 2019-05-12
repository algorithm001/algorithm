class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> res(nums.size(),-1);
        stack<pair<int,int>> stk;
        int len = nums.size();
        for(int i=0; i<len*2; i++){
            while(!stk.empty()&&stk.top().first<nums[i%len]){
                auto it = stk.top();
                stk.pop();
                res[it.second]=nums[i%len];
            }
            if(i<len){
                stk.push(pair<int,int>(nums[i], i));
            }
        }
        return res;
    }
};
