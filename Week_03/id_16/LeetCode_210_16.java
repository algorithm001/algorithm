/**[图][中等]
现在你总共有 n 门课需要选，记为 0 到 n-1。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

示例 1:
输入: 2, [[1,0]] 
输出: [0,1]
解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。

示例 2:
输入: 4, [[1,0],[2,0],[3,1],[3,2]]
输出: [0,1,2,3] or [0,2,1,3]
解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
	 
说明:
输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。

提示:
1.这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
2.通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
3.拓扑排序也可以通过 BFS 完成。
*/

/*
思路1：
拓扑排序，BFS：与DFS比需要记录顶点入度
先将边缘列表，转化为邻接表表示图，并记录每个顶点的入度，即学习本门课前需要学习其他的课程数量。
将入度为零的顶点加入结果集中，并将本顶点指向的顶点入度减一，在查找入度为零的顶点，以此循环。
最后如果，结果集能覆盖所有顶点即得解，否则无解。
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //用邻接表表示图，并记录每个顶点的入度
        LinkedList<Integer>[] neighborList = new LinkedList[numCourses];
        int[] indegree = new int[numCourses];
        
        for(int[] pair : prerequisites){
            if(neighborList[pair[1]] == null)
                neighborList[pair[1]] = new LinkedList<Integer>();
            neighborList[pair[1]].add(pair[0]);
            indegree[pair[0]]++;
        }
        
        //优先学习入度为0的课
        int[] res = new int[numCourses];
        int cur = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                res[cur++] = i;
        }
        
        for(int j = 0; j < cur; j++){//巧妙的写法:指针cur会随循环不断向后移动
            if(neighborList[res[j]] != null){
                for(int neb : neighborList[res[j]]){
                    indegree[neb] -= 1;
                    if(indegree[neb] == 0)
                        res[cur++] = neb;
                }
            }
        }
        
        return cur == numCourses ? res : new int[0];
    }
}

/*
思路2：
拓扑排序，DFS
先将边缘列表，转化为邻接表表示图，并记录每个顶点的入度，即学习本门课前需要学习其他的课程数量。
将入度为零的顶点加入结果集中，并将本顶点指向的顶点入度减一，在查找入度为零的顶点，以此循环。
最后如果，结果集能覆盖所有顶点即得解，否则无解。

思考：DFS一般需要用到递归，需要将存储数据的容器放在方法外声明，变量才能正常工作。
*/
class Solution {
    private LinkedList<Integer>[] neighborList;
    private boolean[] isVisited;
    private boolean[] onStack; //用来判断成环的栈
    private int[] res;
    private int cnt;
    private boolean hasCycle;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        neighborList = new LinkedList[numCourses];
        isVisited = new boolean[numCourses];
        onStack = new boolean[numCourses];
        res = new int[numCourses];
        cnt = numCourses - 1;
        
        //用邻接表表示图
        for(int[] pair : prerequisites){
            if(neighborList[pair[1]] == null)
                neighborList[pair[1]] = new LinkedList<Integer>();
            neighborList[pair[1]].add(pair[0]);
        }
        
        //dfs查找环
        for(int node = 0; node < numCourses; node++){
            if(!isVisited[node])
                dfs(node);
        }
        
        return hasCycle ? new int[0] : res; 
    }
    
    private void dfs(int node){
        onStack[node] = true;
        isVisited[node] = true;
        if(neighborList[node] != null){
            for(int neb : neighborList[node]){
                if(!isVisited[neb]){
                    dfs(neb);
                }else if(onStack[neb]){
                    hasCycle = true;
                    return;
                }
            }
        }
        res[cnt--] = node;
        onStack[node] = false;
    }
}