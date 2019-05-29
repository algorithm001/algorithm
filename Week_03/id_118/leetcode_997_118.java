// https://leetcode-cn.com/problems/find-the-town-judge
// 997.找到小镇的法官
class Solution {
    // 这道题可以解读为：
    // 找出给定图中出度为0&&入度为N-1的点
    // 这个点要么不存在，要么唯一
    
    // 解题思路：
    // N是顶点数，trust 是一个 M*2 的数组，其中 M 是边数。
    // 若有一个点“出度0&&入度N-1”，则至少需要 N-1 条边。
    public int findJudge(int N, int[][] trust) {
        
        // 1. 取边数
        int M = trust.length;
        
        // 2. 边界处理：若边数<顶点数-1，则一定不存在要找的点
        if(M < N-1){
            return -1;
        }
        
        // 3. 遍历所有的边，分别统计每个顶点的入度和出度。初始时默认全是0。
        // 注意：边的数字是从1开始的，不是0，所以入度出度表，要定义长度为N+1，而不是N
        int[] in_degree = new int[N+1];
        int[] out_degree = new int[N+1];
        
        for(int i=0;i<M;i++){
            // 边，from->to：from出度+1，to入度+1
            int from = trust[i][0];
            int to = trust[i][1];
            out_degree[from]+=1;
            in_degree[to]+=1;
        }
        
        // 4. 同时扫描入度出度表，找出度为0&&入度为N-1的点。
        for(int i=1;i<=N;i++){
            if(in_degree[i]==N-1 && out_degree[i]==0){
                return i;
            }
        }
        
        return -1;
    }
}
