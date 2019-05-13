class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int dp1= cost[0];
        int dp2 = cost[1];
        for(int i=2; i<cost.size(); i++){
            int tmpdp = min(dp1,dp2) + cost[i];
            dp1 = dp2;
            dp2 = tmpdp;
        }
        int result = min(dp1,dp2);
        return result;
    }
};
