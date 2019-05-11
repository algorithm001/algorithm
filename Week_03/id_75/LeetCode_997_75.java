/**    
* 例如trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
* 逆邻接表 入度
* 1
* 2
* 3=>1->2->4
* 4=>1->2
*
* 邻接表 出度
* 1=>3->4
* 2=>3->4
* 3
* 4=>3
* 3的出度为0 入度为N - 1所以3是法官
*/
class Solution {
    private LinkedList<Integer> adj[];//邻接表 计算出度
    private LinkedList<Integer> i_adj[];//逆邻接表 计算入度
    public int findJudge(int N, int[][] trust) {
        //创建图
        adj = new LinkedList[N];
        i_adj = new LinkedList[N];
        for(int i = 0; i < N; ++i){
            adj[i] = new LinkedList<>();
            i_adj[i] = new LinkedList<>();
        }
        
        //初始图数据
        for(int i = 0; i < trust.length; ++i){
            adjAddEdge(trust[i][0] - 1,trust[i][1] - 1);
            inverse_adjAddEdge(trust[i][1] - 1,trust[i][0] - 1);
        }
        
        
        for(int i = 0; i < N; ++i){
            if(i_adj[i].size() == (N - 1) && adj[i].size() == 0){
                return i + 1;
            }
        }
        return -1;
    }
    
    /**
    * i 被信任居民的编号
    * j 居民的编号
    */
    public void inverse_adjAddEdge(int i,int j){
        i_adj[i].add(j);
    }
    
    /**
    *i 居民编号
    *j 被信任居民编号
    */
    public void adjAddEdge(int i,int j){
        adj[i].add(j);
    }
}

//建个A[N][2]大小的二维数组
//二维数组的A[i][0]为入度,统计编号i的居民被多少人信任;A[i][1]为出度，统计编号i的居民信任多少人
//入度为N-1,出度为0是结果
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] A = new int[N][2];
        for(int i = 0; i < trust.length; i++){
            int out_degree = trust[i][0];
            int in_degree = trust[i][1];
            A[out_degree - 1][0]++;
            A[in_degree - 1][1]++;
        }
        for(int i = 0; i < N; i++){
            if(A[i][0] == 0 && A[i][1] == (N - 1)){
                return i + 1;
            }
        }
        return -1;
    }     
}