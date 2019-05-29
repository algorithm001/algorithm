class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int len = cost.size();
        
        if (len <= 2) {
            return std::min(cost[0], cost[1]);
        }
        
        int step[1001];
        step[0] = 0;
        step[1] = 0;
        for(int i = 2; i <= len; i++){
            step[i] = std::min(step[i-2] + cost[i-2], step[i-1] + cost[i-1]);
        }
        
        return step[len];
    }
};

