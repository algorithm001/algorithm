class Solution {
    //返回顺序索引
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //初始化图
        Graph  graph = new Graph(numCourses);
        for(int i=0;i<prerequisites.length;i++){
            graph.addEdge(prerequisites[i][0],prerequisites[i][1]);
        }
        //返回读书顺序
        int[] order = new int[numCourses];
        // 记录遍历节点
        boolean[] visited = new boolean[numCourses];
        //相关节点是否在执行栈中 -> 检测图中的环
        boolean[] inStack = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i] == false){
                 visited[i] = true;
                if(!dfs(i,graph.adj,visited,order,inStack)){
                    return new int[0];
                }
            }
        }

        return order;
    }
    
    public boolean dfs(int vertex,LinkedList<Integer> adj[],boolean[] visited,int[] order,boolean[] inStack){
      // 进入运行栈
      inStack[vertex] = true;
      for(int i=0;i<adj[vertex].size();i++){
          int w = adj[vertex].get(i);
          if(visited[w] == true){
              if(inStack[w]){
                //检测到环 ->  直接返回
                  return false;
              }
              continue;
          }
          visited[w] = true;
          //检测到环 -> 直接返回
          if(!dfs(w,adj,visited,order,inStack)){
              return false;
          }
      }  

        //退出运行栈
        inStack[vertex] = false;
        //标记执行顺序
        order[index++] = vertex;
        return true;
        
    }
     
class Graph {
  // 顶点的个数
  private int v; 
  // 邻接表
  private LinkedList<Integer> adj[]; 

  public Graph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i=0; i<v; ++i) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int s, int t) { 
     // s 先于 t，边 s->t
    adj[s].add(t);
  }
}

}