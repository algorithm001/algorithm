/*
  746. 使用最小花费爬楼梯
  数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
  每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
  您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
  
示例:

输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
输出: 6
解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。

*/
/*
思路：
    到达低i阶楼梯有两种情况，第一种是由第i - 2阶楼梯跨两步直接到达第i阶，第二种是有第i - 1阶楼梯跨一步
    到达第i阶楼梯。所以最后走完所有楼梯，可以由第costSize - 2阶跨两步到达顶端，也可以由第costSize - 1
    阶跨一步到达顶端。取两者的较小代价即可。
*/
class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int costSize = cost.size();
        //分别代表到达第index - 2、index - 1需要的代价
        int firstRes = cost[0], secondRes = cost[1];
        for(int index = 2; index < costSize; ++index)
        {
            //到达第index所需要的代价 == min（到达index - 2代价，到达index - 1代价）+ 跨上第index需要的代价
            int tempRes = min(firstRes, secondRes) + cost[index];
            firstRes = secondRes;
            secondRes = tempRes;            
        }
        //第costSize - 2阶跨两步到达顶端，也可以由第costSize - 1阶跨一步到达顶端。取两者的较小代价即可。
        return min(firstRes, secondRes);
    }
};