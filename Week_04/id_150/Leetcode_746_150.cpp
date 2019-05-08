class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        vector<int> res(cost.size() + 1, 0);
        res[0] = cost[0];
        res[1] = cost[1];
        
        for(int i = 2; i < cost.size() + 1; i++) {
            if(i == cost.size()) {
                res[i] = min(res[i - 1], res[i - 2]);
            } else {
                res[i] = min(res[i - 1], res[i - 2]) + cost[i];
            }
        }
        
        return res[cost.size()];   
        
    }
    
};
