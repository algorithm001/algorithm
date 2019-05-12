class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        if(cost.size()==0){
            return 0;
        }
        if(cost.size()==1){
            return cost[0];
        }
        if(cost.size()==2){
            return std::min(cost[0],cost[1]);
        }
        int step[1024] = {0}; //可以从0和1开始，所以step[0]和step[1]都为0
        for(int i=2;i<=cost.size();i++){
            step[i] = std::min(step[i-1]+cost[i-1],step[i-2]+cost[i-2]);
        }
        return step[cost.size()];
    }
};