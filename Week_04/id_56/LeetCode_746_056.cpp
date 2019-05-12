class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int costSize = cost.size();
        int firstRes = cost[0], secondRes = cost[1];//分别代表到达第index - 2、index - 1需要的代价
        for (int index = 2; index < costSize; ++index){
            //到达第index所需要的代价 == min（到达index - 2代价，到达index - 1代价）+ 跨上第index需要的代价
            int tempRes = min(firstRes, secondRes) + cost[index];
            //递推更新
            firstRes = secondRes;
            secondRes = tempRes;
        }
        //第costSize - 2阶跨两步到达顶端，也可以由第costSize - 1阶跨一步到达顶端。取两者的较小代价即可。
        return min(firstRes, secondRes);
    }
};
