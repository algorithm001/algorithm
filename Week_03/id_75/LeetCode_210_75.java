//Kahn算法
class Solution {
    private LinkedList<Integer> adj[]; //邻接表
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph(numCourses,prerequisites);
        
        int[] inDegree = new int[numCourses];//统计每个顶点的入度
        for(int i = 0; i < prerequisites.length; i++){
            int w = prerequisites[i][0];
            inDegree[w]++;
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) queue.add(i);
        }
        
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int i = queue.remove();
            list.add(i);
            for(int j = 0; j < adj[i].size(); ++ j){
                int k = adj[i].get(j);
                inDegree[k]--;
                if(inDegree[k] == 0) queue.add(k);
            }
        }
        //对于Kahn算法，如果最后输出出来的顶点个数少于图中顶点个数，图中还有入度不是0的顶点，那就说明图中存在环
        if(list.size() < numCourses || list.isEmpty()) return new int[0];
        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public void Graph(int v,int[][] prerequisites){
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            int s = prerequisites[i][1];
            int t = prerequisites[i][0];
            addEdge(s,t);
        }
    }
    
    public void addEdge(int s,int t){
        adj[s].add(t);
    }
}


//DFS算法
class Solution {
    private boolean[] visited; //记录访问过的点
    private boolean[] onStack; //dfs遍历可能有环的存在，用onStack记录已经遍历过得节点，若在递归过程中存在已经遍历过的节点，就说明存在环
    private List<Integer> list; //结果序列
    private LinkedList<Integer> inverseAdj[]; //逆邻接表
    private boolean hasCycle = false; //判断是否是环

        
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        inverseAdj = new LinkedList[numCourses]; //构建逆邻接表
        for(int i = 0; i < numCourses; i++){
            inverseAdj[i] = new LinkedList<>();
        }
        
        //初始逆邻接表数据
        for(int i = 0; i < prerequisites.length; i++){
            int s = prerequisites[i][0];
            int t = prerequisites[i][1];
            inverseAdj[s].add(t);
        }

        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];
        list = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            if(hasCycle) break;
            if(visited[i] == false){
                visited[i] = true;
                dfs(i);
            }
        }
        
        if(hasCycle) return new int[0];
        
        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    //dfs优先深度遍历
    private void dfs(int i){
        onStack[i] = true;
        for(int j = 0; j < inverseAdj[i].size(); j++){
            if(hasCycle) return;
            int w = inverseAdj[i].get(j);
            if(visited[w] == false){
                visited[w] = true;
                dfs(w);
            }
            if(onStack[w]) hasCycle = true;
        }
        onStack[i] = false;
        //把节点加到序列里
        list.add(i);
    }
    
}