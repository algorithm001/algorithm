/*
  746. ʹ����С������¥��
  �����ÿ��������Ϊһ�����ݣ��� i�����ݶ�Ӧ��һ���Ǹ�������������ֵ cost[i](������0��ʼ)��
  ÿ��������һ�������㶼Ҫ���Ѷ�Ӧ����������ֵ��Ȼ�������ѡ�������һ�����ݻ������������ݡ�
  ����Ҫ�ҵ��ﵽ¥�㶥������ͻ��ѡ��ڿ�ʼʱ�������ѡ�������Ϊ 0 �� 1 ��Ԫ����Ϊ��ʼ���ݡ�
  
ʾ��:

����: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
���: 6
����: ��ͻ��ѷ�ʽ�Ǵ�cost[0]��ʼ�����������Щ1������cost[3]��һ������6��

*/
/*
˼·��
    �����i��¥���������������һ�����ɵ�i - 2��¥�ݿ�����ֱ�ӵ����i�ף��ڶ������е�i - 1��¥�ݿ�һ��
    �����i��¥�ݡ����������������¥�ݣ������ɵ�costSize - 2�׿��������ﶥ�ˣ�Ҳ�����ɵ�costSize - 1
    �׿�һ�����ﶥ�ˡ�ȡ���ߵĽ�С���ۼ��ɡ�
*/
class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int costSize = cost.size();
        //�ֱ�������index - 2��index - 1��Ҫ�Ĵ���
        int firstRes = cost[0], secondRes = cost[1];
        for(int index = 2; index < costSize; ++index)
        {
            //�����index����Ҫ�Ĵ��� == min������index - 2���ۣ�����index - 1���ۣ�+ ���ϵ�index��Ҫ�Ĵ���
            int tempRes = min(firstRes, secondRes) + cost[index];
            firstRes = secondRes;
            secondRes = tempRes;            
        }
        //��costSize - 2�׿��������ﶥ�ˣ�Ҳ�����ɵ�costSize - 1�׿�һ�����ﶥ�ˡ�ȡ���ߵĽ�С���ۼ��ɡ�
        return min(firstRes, secondRes);
    }
};